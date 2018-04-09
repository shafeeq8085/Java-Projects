package com.allianz.k2swing.main;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;

	public class JMenuSelectionManagerMain {
	  public static void main(final String args[]) {
	    JFrame frame = new JFrame("MenuSample Example");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JMenuBar menuBar = new JMenuBar();

	    // File Menu, F - Mnemonic
	    JMenu fileMenu = new JMenu("File");
	    fileMenu.setMnemonic(KeyEvent.VK_F);
	    menuBar.add(fileMenu);

	    // File->New, N - Mnemonic
	    JMenuItem newMenuItem = new JMenuItem("New");
	    fileMenu.add(newMenuItem);
	    
	    newMenuItem.addActionListener(new ActionListener(){

	      public void actionPerformed(ActionEvent e) {
	       MenuElement[] eles =  MenuSelectionManager.defaultManager().getSelectedPath();
	       for(MenuElement ele: eles){
	         System.out.println(ele);
	         
	       }
	       MenuSelectionManager.defaultManager().clearSelectedPath();
	      }});

	    frame.setJMenuBar(menuBar);
	    frame.setSize(350, 250);
	    frame.setVisible(true);
	  }
	}
