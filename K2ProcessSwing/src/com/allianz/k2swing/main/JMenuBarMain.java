package com.allianz.k2swing.main;


import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


	public class JMenuBarMain {

	  public static void main(final String args[]) {
	    JFrame frame = new JFrame("MenuSample Example");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JMenuBar menuBar = new JMenuBar();

	    JMenu fileMenu = new JMenu("File");

	    JMenuItem newMenuItem = new JMenuItem("New");
	    fileMenu.add(newMenuItem);

	    JMenuItem openMenuItem = new JMenuItem("Open");
	    fileMenu.add(openMenuItem);

	    JMenuItem closeMenuItem = new JMenuItem("Close");
	    fileMenu.add(closeMenuItem);
	    fileMenu.addSeparator();

	    JMenuItem saveMenuItem = new JMenuItem("Save");
	    fileMenu.add(saveMenuItem);
	    fileMenu.addSeparator();

	    JMenuItem exitMenuItem = new JMenuItem("Exit");
	    fileMenu.add(exitMenuItem);
	    
	    menuBar.add(fileMenu);
	    
	    JMenu EditMenu = new JMenu("Edit");

	    JMenuItem copyEditItem = new JMenuItem("Copy");
	    EditMenu.add(copyEditItem);

	    JMenuItem cutEditItem = new JMenuItem("Cut");
	    EditMenu.add(cutEditItem);

	    JMenuItem pasteEditItem = new JMenuItem("Paste");
	    EditMenu.add(pasteEditItem);

	    JMenuItem deleteEditItem = new JMenuItem("Delete");
	    EditMenu.add(deleteEditItem);
	    
	    JCheckBoxMenuItem caseMenuItem = new JCheckBoxMenuItem("Check Box");
	    caseMenuItem.setMnemonic(KeyEvent.VK_C);
	    EditMenu.add(caseMenuItem);

	    menuBar.add(EditMenu);


	    frame.setJMenuBar(menuBar);
	    frame.setSize(800, 600);
	    frame.setVisible(true);
	  }
	}

