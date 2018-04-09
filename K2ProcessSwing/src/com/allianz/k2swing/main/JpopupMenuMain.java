package com.allianz.k2swing.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

	public class JpopupMenuMain {
	  public static void main(String[] argv) throws Exception {
		  
		JFrame frame = new JFrame("PopupMenuSample Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    final JPopupMenu menu = new JPopupMenu();

	    JMenuItem item = new JMenuItem("NEW");
	    menu.add(item);
	    JMenuItem old = new JMenuItem("OLD");
	    old.setEnabled(false);
	    menu.add(old);
	    JMenuItem delete = new JMenuItem("DELETE");
	    menu.add(delete);

	    JButton component = new JButton();
	    component.addMouseListener(new MouseAdapter() {
	      public void mousePressed(MouseEvent evt) {
//	        if (evt.isPopupTrigger()) {
	          menu.show(evt.getComponent(), evt.getX(), evt.getY());
//	        }
	      }

	      public void mouseReleased(MouseEvent evt) {
//	        if (evt.isPopupTrigger()) {
	          menu.show(evt.getComponent(), evt.getX(), evt.getY());
//	        }
	      }
	    });
	    
	    frame.add(component);
	    component.setComponentPopupMenu(menu);

	    frame.setSize(800, 600);
	    frame.setVisible(true);
	  }
	}
