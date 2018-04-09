package com.allianz.k2swing.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.lang.reflect.Method;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class SplashscreenMain extends JFrame{
	
	private final Color COL_AZ_BLUE = new Color(0x31, 0x5a, 0x9c);
	private final Color COL_BACKGROUND = UIManager.getColor("Label.background").brighter();
	private final Color COL_FOREGROUND = COL_AZ_BLUE.darker();
	private JLabel cLabel;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final SplashscreenMain f = new SplashscreenMain();
		 try {
	            Thread.sleep(10000);
	        } catch (InterruptedException ex) {}
		 f.dispose();
		 System.exit(0);
	}
	
	public SplashscreenMain(){
		
        super("APKV-Java-Client");
        setName("SplashScreen2");
        setResizable(false);
        boolean lUndecorated = setUndecorated();
        URL mUrl = getClass().getClassLoader().getResource("VKLogo.gif");
        Image img = java.awt.Toolkit.getDefaultToolkit().getImage(mUrl);
        setIconImage(img);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                Toolkit.getDefaultToolkit().beep();
            }
            public void windowOpened(java.awt.event.WindowEvent e) {
	    }
        });

        Dimension mScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(mScreenSize.width / 2 - 260, mScreenSize.height / 2 - 170, 520, 340);
		
		JPanel mContentPane = new JPanel(new BorderLayout(), false);
		mContentPane.setBorder(createBorder(lUndecorated));
		mContentPane.add(getPicture(), BorderLayout.NORTH);
		mContentPane.add(getCenterLabel(), BorderLayout.CENTER);
		cLabel = getBottomLabel();
		mContentPane.add(cLabel, BorderLayout.SOUTH);
		getRootPane().setDoubleBuffered(false);
        setContentPane(mContentPane);
        show(); 
	}
	
	private JLabel cNLabel;
	public static Font VKDEFAULT_FONT_BOLD = new Font("Verdana",Font.BOLD,14);
	
	private Component getCenterLabel() {
        JPanel mPanel = new JPanel(new GridLayout(2, 1, 0, 20), false);
        mPanel.setOpaque(true);
        mPanel.setBackground(COL_BACKGROUND);
        mPanel.setForeground(COL_FOREGROUND);
        JLabel mLabel;

        mLabel = new JLabel("APKV-Java-Client");
        mLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        mLabel.setFont(new Font("Verdana", Font.BOLD, 28));
        mLabel.setBackground(COL_BACKGROUND);
        mLabel.setForeground(COL_FOREGROUND);
        mPanel.add(mLabel);

        cNLabel = new JLabel(" ");
        cNLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cNLabel.setVerticalAlignment(SwingConstants.TOP);
        cNLabel.setFont(VKDEFAULT_FONT_BOLD);
        cNLabel.setBackground(COL_BACKGROUND);
        cNLabel.setForeground(COL_FOREGROUND);
        cNLabel.setDoubleBuffered(false);
        mPanel.add(cNLabel);

        return mPanel;
    }
	
	private boolean setUndecorated() {
        try {
            Method m = getClass().getMethod("setUndecorated", new Class[] { Boolean.TYPE});
            m.invoke(this, new Object[] { Boolean.TRUE});
            return true;
        } catch (Exception ex) { // ignorieren, wenn nicht möglich
            return false;
        }
    }
	
	private Border createBorder(boolean pBorder) {
        Border lInner = BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,
                UIManager.getColor("Label.background")), UIManager.getBorder("TextField.border"));
        if (!pBorder) { return lInner; }
        return BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
                lInner);
    }
	
	private Component getPicture() {
        JLabel mLabel = new JLabel();
        mLabel.setBackground(COL_BACKGROUND);
        mLabel.setForeground(COL_FOREGROUND);
        mLabel.setOpaque(true);
        mLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        mLabel.setVerticalAlignment(SwingConstants.CENTER);
        mLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 60, 10));
        URL mURL = getClass().getClassLoader().getResource("APKV.gif");
        if (mURL != null) {
            mLabel.setIcon(new ImageIcon(mURL));
        }
        return mLabel;
    }
	
	private JLabel getBottomLabel() {
        JLabel mLabel = new JLabel(" ");
        mLabel.setOpaque(true);
        mLabel.setDoubleBuffered(false);
        mLabel.setBackground(COL_AZ_BLUE);
        mLabel.setForeground(Color.white);
        mLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mLabel.setFont(new Font("Verdana",Font.PLAIN,14));
        mLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return mLabel;
    }
}
