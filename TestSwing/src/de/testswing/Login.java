package de.testswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

public class Login extends javax.swing.JFrame{
	
	private JFrame login; 
	private JPanel control;
    private JLabel header;
    private JLabel footer;
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;    
    private javax.swing.JLabel jLabel5;    
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    
    public Login() {
    	
    	  prepareInitialScreen();
    }
  
	
    public static void main (String[] args){
    	Login initialScreen = new Login();
//    	initialScreen.showgroupLayoutDemo();
//    	initialScreen.showSpringLayoutDemo();
//    	initialScreen.showgridBagLayoutDemo();
//    	initialScreen.showgridLayoutDemo();
//    	initialScreen.showBoarderLayoutDemo();
//    	initialScreen.showWindowDemo();
//    	initialScreen.showMouseAdapterDemo();
//    	initialScreen.showCheckbox();
//    	initialScreen.showTextField();
//    	initialScreen.showTextArea();
//    	initialScreen.scrollbar();
//    	initialScreen.showOptionPaneDemo();
//    	initialScreen.showFileChooserDemo();
    	initialScreen.showProgressBarDemo();
    	
    	
    }
    
    private void prepareInitialScreen(){
    	
    	login = new JFrame("Login Screen");
    	login.setLayout(new GridLayout(3, 1));
    	login.setSize(800, 800);
    	
    	login.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
    	
    	control = new JPanel();
        header = new JLabel("Please Enter The Credentials",JLabel.CENTER);
        footer = new JLabel("",JLabel.CENTER);
        footer.setSize(80,80);
        
        login.add(header);
        login.add(control);
        login.add(footer);
        
        login.setVisible(true);
    }
    
    /**
     * 
     */
    private void showgroupLayoutDemo(){
    	    	
    	header.setText("Layout in action: GroupLayout Demo");
    	
    	jLabel1 = new javax.swing.JLabel();              /* Input Type  */
        jComboBox1 = new javax.swing.JComboBox();      
        jLabel2 = new javax.swing.JLabel();              /* Input Value */
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();              /* User Name   */
        jTextField2 = new javax.swing.JTextField();        
        jLabel4 = new javax.swing.JLabel();              /* Password    */
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();              /* Email id    */
        jTextField4 = new javax.swing.JTextField();

        jButton1 = new javax.swing.JButton();            /* Copy to IMSE */
        jButton2 = new javax.swing.JButton();            /* Get PDF      */
        jButton3 = new javax.swing.JButton();            /* Cancel       */

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        /* Input Type */
        jLabel1.setText("Input Type");
        jLabel1.setName("lbltype"); 
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UUID", "Filenet Id", "AFP File" }));
        jComboBox1.setName("cmbInptype");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        /* Input type's Value */        
        jLabel2.setText("Value");
        jLabel2.setName("lblInpvalue"); 
        jTextField1.setName("txtInpvalue"); 
        
        /* Username Value */        
        jLabel2.setText("Value");
        jLabel2.setName("lblUsername"); 
        jTextField1.setName("txtUsername");
        
        /* Host Password      */        
        jLabel3.setText("Username");
        jLabel3.setName("lblUsername"); 
        jTextField2.setName("txtUsername");
        
        /* Password          */        
        jLabel4.setText("Password");
        jLabel4.setName("lblPassword"); 
        jTextField3.setName("txtPassword");
        
        
        /* Email id          */        
        jLabel5.setText("Email Id");
        jLabel5.setName("lblEmailid"); 
        jTextField4.setName("txtEmailid");
        

        
        jButton1.setText("Copy to IMSE");
        jButton1.setName("btncopy"); 
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Get PDF");
        jButton2.setName("btngetpdf"); 
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.setName("btncancel"); 
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)                            
                            .addComponent(jLabel5))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)                            
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)                            
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)                            
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    

                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(140, Short.MAX_VALUE))
        );   	
    	
        pack();
        login.setVisible(true);
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:

            
    }                                          

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String inpType,fid;
        inpType = (String)(jComboBox1.getSelectedItem());
        if (inpType == "Filenet Id")
        {
            System.out.println("Ok input");
            fid = jTextField1.getText();
            System.out.println("Input fid=" + fid);
//            APKVDocumentDAOImpl_Filenet fobj = new APKVDocumentDAOImpl_Filenet();
//            fobj.getDBConnection();
//            fobj.insertTBCOAntragDaten(fid);
        }
        else
        {
            System.out.println("Not ok input");
            JOptionPane.showMessageDialog(null, "Please select Filenet Id as input !");
        }          
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { 
		System.out.println("Get PDF clicked !");
        String inptype,inpval,user,pwd,email,errmsg;
        inptype = (String)(jComboBox1.getSelectedItem());
        inpval  = jTextField1.getText();
        user    = jTextField2.getText();
        pwd     = jTextField3.getText();
        email   = jTextField4.getText();   
        errmsg  = null;
        if (inptype == "AFP File")
        {      	
        	if (inpval.length() > 0 && user.length() > 0 && pwd.length() > 0 && email.length() > 0)
        	{
        		System.out.println("Inputs are ok !");
        	}
        	else
        	{
                if (email.length() == 0)  errmsg = "Please enter your email address !";
                if (pwd.length() == 0)    errmsg = "Please enter your host password !";                
                if (user.length() == 0)   errmsg = "Please enter your host userid !";
                if (inpval.length() == 0) errmsg = "Please enter a valid host dataset name !";
                JOptionPane.showMessageDialog(null, errmsg);                
        	}
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
    }   
    
	private void showSpringLayoutDemo(){

        header.setText("Layout in action: SpringLayout");   
        SpringLayout layout = new SpringLayout();

        JPanel panel = new JPanel();
        panel.setLayout(layout);
        JLabel label = new JLabel("Enter Name: ");
        JTextField textField = new JTextField("", 15);
        panel.add(label);
        panel.add(textField);

        layout.putConstraint(SpringLayout.WEST, label,5,
           SpringLayout.WEST, control);
        layout.putConstraint(SpringLayout.NORTH, label,5,
           SpringLayout.NORTH, control);
        layout.putConstraint(SpringLayout.WEST, textField,5,
           SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, textField,5,
           SpringLayout.NORTH, control);
        layout.putConstraint(SpringLayout.EAST, panel,5,
           SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.SOUTH, panel,5,
           SpringLayout.SOUTH, textField);
        control.add(panel);
        login.setVisible(true);  
     } 

    
	private void showgridBagLayoutDemo(){
    	
    	header.setText("Border Layout Demo");
    	
    	JPanel newPanel = new JPanel();
    	newPanel.setSize(300,300);
    	newPanel.setBackground(Color.BLUE);
    	
    	GridBagLayout newGridBagLayout = new GridBagLayout();
    	newPanel.setLayout(newGridBagLayout);
    	
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.fill = GridBagConstraints.HORIZONTAL;
    	gbc.ipady = 20;
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	gbc.gridwidth = 2;
    	newPanel.add(new JButton("FIRST"),gbc);
    	
    	gbc.fill = GridBagConstraints.HORIZONTAL;
    	gbc.ipady = 20;
    	gbc.gridx = 0;
    	gbc.gridy = 2;
    	gbc.gridwidth = 2;
    	newPanel.add(new JButton("SECOND"),gbc);
    	
    	gbc.fill = GridBagConstraints.HORIZONTAL;
    	gbc.ipady = 20;
    	gbc.gridx = 0;
    	gbc.gridy = 4;
    	gbc.gridwidth = 2;
    	newPanel.add(new JButton("THIRD"),gbc);    	
    	
    	control.add(newPanel);
    	login.setVisible(true);
    }

    private void showgridLayoutDemo(){
    	
    	header.setText("Border Layout Demo");
    	
    	JPanel newPanel = new JPanel();
    	newPanel.setSize(300,300);
    	newPanel.setBackground(Color.BLUE);
    	
    	GridLayout newGridLayout = new GridLayout();
    	newGridLayout.setHgap(10);
    	newGridLayout.setVgap(10);
    	newGridLayout.setColumns(20);
    	newPanel.setLayout(newGridLayout);
    	
    	
    	newPanel.add(new JButton("one"));
    	newPanel.add(new JButton("two"));
    	newPanel.add(new JButton("three"));
    	
    	control.add(newPanel);
    	login.setVisible(true);
    }
    
    private void showBoarderLayoutDemo(){
    	
    	header.setText("Border Layout Demo");
    	
    	JPanel newPanel = new JPanel();
    	newPanel.setSize(300,300);
    	newPanel.setBackground(Color.BLUE);
    	
    	BorderLayout newBorderLayout = new BorderLayout();
    	newBorderLayout.setHgap(10);
    	newBorderLayout.setVgap(10);
    	newPanel.setLayout(newBorderLayout);
    	
    	newPanel.add(new JButton("one"),newBorderLayout.LINE_END);
    	newPanel.add(new JButton("two"),newBorderLayout.LINE_START);
    	newPanel.add(new JButton("three"),newBorderLayout.PAGE_END);
    	
    	control.add(newPanel);
    	login.setVisible(true);
    }
    
    private void showWindowDemo(){
    	
    	header.setText("Windiws Demo");
    	
    	JFrame newFrame = new JFrame();
    	newFrame.setSize(100,100);
    	
    	newFrame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				footer.setText("Window opened");
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				footer.setText("Window closing");
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				footer.setText("Window closed");
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    	
    	JLabel newLabel = new JLabel("New Window",JLabel.CENTER);
    	newFrame.add(newLabel);
    	newFrame.setVisible(true);
    }
    private void showMouseAdapterDemo(){
        header.setText("Listener in action: MouseAdapter");      

        JPanel panel = new JPanel();      
        panel.setBackground(Color.magenta);
        panel.setLayout(new FlowLayout());        
        panel.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e) {
              footer.setText("Mouse Clicked: ("
              +e.getX()+", "+e.getY() +")");
           }                
        });

        JLabel msglabel 
        = new JLabel("Welcome to TutorialsPoint SWING Tutorial."
        ,JLabel.CENTER);
        
        msglabel.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e) {
              footer.setText("Mouse Clicked: ("
              +e.getX()+", "+e.getY() +")");
           }                
        });
        
        msglabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				footer.setText("mousee pressed");
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				footer.setText("mouse exited");
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				footer.setText("mousee entered");
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				footer.setText("mousee clickeg");
			}
		});
        panel.add(msglabel);
        control.add(panel);
        login.setVisible(true);  
     }

    private void showCheckbox(){
    	
    	JCheckBox checkap = new JCheckBox("Apple");
    	JCheckBox checkor = new JCheckBox("Orange");
    	JCheckBox checkma = new JCheckBox("Mango");
    	
    	checkap.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				footer.setText(((JCheckBox)e.getItem()).getText()+"Checkbox"+(e.getStateChange() == 1?"Checked":"Unckecked"));
			}
		});
    	
    	control.add(checkap);
    	control.add(checkma);
    	control.add(checkor);
    	
    	login.setVisible(true);
    	
    	
    }
    
    private void showTextField(){
    	JLabel username = new JLabel("USERNAME",JLabel.RIGHT);
    	final JTextField UNAME = new JTextField(6);
    	JLabel password = new JLabel("PASSWORD",JLabel.CENTER);
    	final JPasswordField PWORD = new JPasswordField(6);
    	
    	JButton logon = new JButton("LOGIN");
    	JButton reset = new JButton("RESET");
    	
    	logon.setActionCommand("LOGON");
    	reset.setActionCommand("RESET");
    	
    	logon.addActionListener(new clickAction());
    	reset.addActionListener(new clickAction());
    	
    	
    	
//    	logon.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				String data;
//				data = "User name entered is : "+UNAME.getText()+" and Password entered is : "+PWORD.getPassword();
//				footer.setText(data);
//			}
//		});
    	
//    	JPanel newPanel = new JPanel();
//    	newPanel.setBackground(Color.GRAY);
//    	JLabel newLabel = new JLabel("Excellent Label",JLabel.CENTER);
//    	
//    	
//    	newLabel.addComponentListener(new custemComponentListener());
//    	
//    	newPanel.add(newLabel);
//    	control.add(newPanel);
    	
    	
    	control.add(username);
    	control.add(UNAME);
    	control.add(password);
    	control.add(PWORD);
    	control.add(logon);
    	control.add(reset);
    	
    	login.setVisible(true);
    	
    }
    
    private class custemComponentListener implements ComponentListener{
    	
    	public void componentShown(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			footer.setText("Component shown");
		}
		
		@Override
		public void componentResized(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			footer.setText("Component Resized");
		}
		
		@Override
		public void componentMoved(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			footer.setText("Component moved");
		}
		
		@Override
		public void componentHidden(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			footer.setText("Component hidden");
		}
    }
    private class clickAction implements ActionListener{
    	
    	
    	public void actionPerformed(ActionEvent e) {
    		String command = e.getActionCommand();
    		
    		if (command == "LOGON"){
    			
    			footer.setText("LOGON CLICKED");
    		} else if (command == "RESET"){
    			
    			footer.setText("RESET CLICKED");
    		} else {
    			
    			footer.setText("XXX CLICKED");
    		}
    	}
    }
    
    private void showTextArea(){
    	
    	JLabel text = new JLabel("Enter a text");
    	final JTextArea textarea = new JTextArea("",5,20);
    	JScrollPane textAreaScroll = new JScrollPane(textarea);
    	
    	JButton tbutton = new JButton("SHOW TEXT");
    	
    	tbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				String tdata = "Text entered is "+textarea.getText();
				footer.setText(tdata);
			}
		});
    	
    	control.add(text);
    	control.add(textAreaScroll);
    	control.add(tbutton);
    	login.setVisible(true);
    }
    
    
    private void scrollbar(){
    	
    	final JScrollBar scrollhoriz = new JScrollBar(JScrollBar.HORIZONTAL);
    	final JScrollBar scrollvert  = new JScrollBar();
    	
    	scrollhoriz.setMaximum(100);
    	scrollhoriz.setMinimum(1);
    	scrollvert.setMaximum(100);
    	scrollvert.setMinimum(1);
    	
    	scrollhoriz.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				// TODO Auto-generated method stub
				String data2 = "Scroll adjustment horizondal is "+scrollhoriz.getValue()+"and Vertical is "+scrollvert.getValue();
				footer.setText(data2);
			}
		});
    	
    	control.add(scrollhoriz);
    	control.add(scrollvert);
    	login.setVisible(true);
    	
    	
    }
    
    private void showOptionPaneDemo(){
    	
    	JButton Okbutton = new JButton("OK");
    	JButton Nokbutton = new JButton("OK/NOK");
    	JButton Cancelbutton = new JButton("OK/NOK/CANCEL");
    	
    	Okbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(login, "Welcome to the Option Pane");
				
			}
		});
    	
    	Nokbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				int output = JOptionPane.showConfirmDialog(login, "Click Any Button","OPTION PANE",JOptionPane.YES_NO_OPTION);
				
						if (output == JOptionPane.YES_OPTION){
							
							footer.setText("YES OPTION CLICKED");
						} else{
							
							footer.setText("NO OPTION CLICKED");
						}
			}
		});
    	
    	Cancelbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				int out = JOptionPane.showConfirmDialog(login, "Click Any Button","OPTION PANE",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
				if (out == JOptionPane.YES_OPTION){
					footer.setText("YES OPTION CLICKED");
				} else if (out == JOptionPane.NO_OPTION){
					footer.setText("NO OPTION CLICKED");
				} else {
					footer.setText("CANCEL OPTION CLICKED");
				}
			}
			
		});
    	
    	
    	control.add(Okbutton);
    	control.add(Nokbutton);
    	control.add(Cancelbutton);
    	
    	login.setVisible(true);
    }
    
    private void showFileChooserDemo(){
    	
    	final JFileChooser fileChoose = new JFileChooser();
    	JButton filebutton = new JButton("SELECT A FILE");
    	
    	filebutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				int returnint = fileChoose.showOpenDialog(login);
				if (returnint == JFileChooser.APPROVE_OPTION){
					
					java.io.File file = fileChoose.getSelectedFile();
					footer.setText("File Selected : "+file.getName());
				}
				else {
					footer.setText("Selection Cancelled by user");
				}
					
			}
		});
    	
    	control.add(filebutton);
    	login.setVisible(true);
    }
    
    private JProgressBar progressBar;
    private JButton startButton;
    private JTextArea outputTextArea;

    
    private void showProgressBarDemo(){
       header.setText("Control in action: JProgressBar"); 

       progressBar = new JProgressBar(0, 100);
       progressBar.setValue(0);
       progressBar.setStringPainted(true);
       startButton = new JButton("Start");

       outputTextArea = new JTextArea("",5,20);

       JScrollPane scrollPane = new JScrollPane(outputTextArea);    
          startButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             Task task = new Task();                
             task.start();
          }});

       control.add(startButton);
       control.add(progressBar);
       control.add(scrollPane);
       login.setVisible(true);  
    }


    
    private class Task extends Thread {    
        public Task(){
        }

        public void run(){
           for(int i =0; i<= 100; i+=50){
              final int progress = i;
              SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					progressBar.setValue(progress);
					outputTextArea.setText(outputTextArea.getText()+ 
					String.format("Completed %d%% of task.\n", progress));

				}
			});
             
              try {
                 Thread.sleep(3600);
              } catch (InterruptedException e) {}
           }
        }
     } 
    
    
}
