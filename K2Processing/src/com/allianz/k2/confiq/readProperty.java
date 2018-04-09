package com.allianz.k2.confiq;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class readProperty {
	
//	private static Logger loggerSlf4J = LoggerFactory.getLogger(readProperty.class);
	protected static final byte[] mk = new byte[] { -71, -72, -104, 29, 17, 119, 34, 77, -29, -24, -57, -123, -100, 10, -58, -118 };
	protected static final byte[] bs = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	protected static final byte[] fb = new byte[] { 0, 0, 0, 0 };

	protected static final String PROPERTY_NAME_PW = "Password";
	public static String configPath;
	public static String outPath;
	
	static {
		initConfigPathFromSystemProperty();
	}
	
	public Properties readProperties() {
		
//		System.out.println("Getting System Property");
//		Properties sysp = System.getProperties();
//		configPath = sysp.getProperty("config.filename");
//		System.out.println(">>> Using config file:" + configPath + " <<<");
		
		System.out.println("Getting the file");
		File  configFile = new File(configPath);
		if (!configFile.exists()){
			System.out.println("Configuration File '" + configPath + "' not found.");			
		}
//		InputStream stream = getClass().getClassLoader().getResourceAsStream(conffile);
		try {
			checkEncodedPW(configFile);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error encrypting password: " + e.getMessage());
		}
//		InputStream stream = OrderMain.class.getResourceAsStream("M:/DESKTOP/LatestDesktop/workspace/OrderProcessingSystem/Properties/properties.file.txt");
		
		Properties p = new Properties();
		try {
			if (configFile != null){
				System.out.println("Loading the file as properties");
				p.loadFromXML(new FileInputStream(configFile));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			p.put(PROPERTY_NAME_PW, decodePassword(p.getProperty(PROPERTY_NAME_PW)));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error decrypting password: " + e.getMessage());
		}
		
		return p;
	}
	
	private static void checkEncodedPW(File configFile) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException,
	TransformerFactoryConfigurationError, TransformerException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
	IllegalBlockSizeException, BadPaddingException, FileNotFoundException {
		//
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		// as during parsing the DOM parser always tries to find the DTD, we
		// 	provide
		// 	a dummy dtd here to prevent search for this dtd (it looks in the
		// www).

		builder.setEntityResolver(new EntityResolver() {
			public InputSource resolveEntity(java.lang.String publicId, java.lang.String systemId) throws SAXException, java.io.IOException {
				//
				if (null == publicId && null != systemId && systemId.equals("http://java.sun.com/dtd/properties.dtd"))
			// 	this deactivates the open office DTD
					return new InputSource(new ByteArrayInputStream("<?xml version='1.0' encoding='UTF-8'?>".getBytes()));
				else
					return null;
			}
		});

		InputStream is = new FileInputStream(configFile);
		Document doc = builder.parse(is);

		// 		-- Search properties element
		NodeList nodes = doc.getElementsByTagName("properties");

		// found properties ?
		if (0 < nodes.getLength()) {
			// use first one (there should be only one list )
			Element element = (Element) nodes.item(0);

			// find the PasswordData Element in the Properties list
			CharacterData pwCd = searchPasswordData(element);
			if (null != pwCd) {

				String pw = pwCd.getData();
				// if Password is not encoded, then encode it
				// and rewrite modified properties file
				if (!pw.endsWith("{AES}")) {
					String encPw = encodePassword(pw);
					encPw += "{AES}";
					System.out.println(">>> Plain password found, encoded to '" + encPw + "'");
					pwCd.setData(encPw);
					rewritePropertiesFile(doc, configFile);
					System.out.println(">>> Config file rewriten with encoded Password.");
				} else {
					System.out.println("Password ends with AES");
					pw = decodePassword(pw);
				}
			}

		}
	}
	private static CharacterData searchPasswordData(Element element) {
			// search entries
			NodeList entries = element.getElementsByTagName("entry");

			// loop thru entries, scan for Password entry
			for (int j = 0; j < entries.getLength(); j++) {
				Element line = (Element) entries.item(j);
				// if password found, check encoding
				if (PROPERTY_NAME_PW.equals(line.getAttribute("key"))) {
					Node pwNode = line.getFirstChild();
					if (pwNode instanceof CharacterData) {
						return (CharacterData) pwNode;
					}

				}
			}
			return null;
	}

		/**
		 * Rewrite the properties file to save the encoded pw
		 * 
		 * @param doc
		 * @throws TransformerFactoryConfigurationError
		 * @throws TransformerConfigurationException
		 * @throws FileNotFoundException
		 * @throws TransformerException
		 */
		private static void rewritePropertiesFile(Document doc, File configFile) throws TransformerFactoryConfigurationError, TransformerConfigurationException,
				FileNotFoundException, TransformerException {
			// transform the Document into a String
			DOMSource domSource = new DOMSource(doc);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://java.sun.com/dtd/properties.dtd");
			OutputStream os = new FileOutputStream(configFile);
			StreamResult sr = new StreamResult(os);

			transformer.transform(domSource, sr);
		}

		/**
		 * Decode the Password
		 * 
		 * @param pw
		 * @return
		 * @throws NoSuchPaddingException
		 * @throws NoSuchAlgorithmException
		 * @throws InvalidKeyException
		 * @throws BadPaddingException
		 * @throws IllegalBlockSizeException
		 */
		private static String encodePassword(String pw) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
				BadPaddingException {

			Cipher cipher;
			cipher = Cipher.getInstance("AES");

			SecretKeySpec skeySpec = new SecretKeySpec(mk, "AES");

			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

			byte[] encrypted = cipher.doFinal(pw.getBytes());

			StringWriter sw = new StringWriter();

			for (int i = 0; i < encrypted.length; i++) {
				int in = encrypted[i]; // get byte as int
				in = in < 0 ? in + 256 : in; // convert signed to unsigned
				if (in < 16) { // leading zero required ??
					sw.write("0");
				}
				sw.write(Integer.toHexString(in)); // write hex string
			}

			return sw.getBuffer().toString();

		}

		/**
		 * Encode the password
		 * 
		 * @param pw
		 * @return
		 * @throws NoSuchPaddingException 
		 * @throws NoSuchAlgorithmException 
		 * @throws InvalidKeyException 
		 * @throws BadPaddingException 
		 * @throws IllegalBlockSizeException 
		 */
		private static String decodePassword(String pw) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

			pw = pw.substring(0, pw.length() - 5); // remove trailing {AES}

			int i = 0;
			for (int j = 0; j < pw.length(); j = j + 2) { // loop over string
				// bytes
				String sb = (pw + "0").substring(j, j + 2); // get string byte
				int num2 = Integer.parseInt(sb, 16); // parse string byte as int
				num2 = num2 > 128 ? num2 - 256 : num2; // convert unsigned to
				// signed
				Integer in = new Integer(num2); // create integer
				bs[i] = in.byteValue(); // an get byte value
				i++; // byte counter
			}

			Cipher cipher = Cipher.getInstance("AES");
			SecretKeySpec skeySpec = new SecretKeySpec(mk, "AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);

			byte[] original = cipher.doFinal(bs);
			String opw = new String(original);
			System.out.println("Password here is: "+opw);
			return opw;

		}

	public static void initConfigPathFromSystemProperty() {
		Properties sysp = System.getProperties();
		configPath = sysp.getProperty("config.filename");
		System.out.println(">>> Using config file:" + configPath + " <<<");
//		outPath = sysp.getProperty("out.filename");
//		System.out.println(">>> Using output file:" + outPath + " <<<");
	}
	
}
