package de.testswing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CreateMain{
	
	public static void main (String[] args) {
		CreateMain CM = new CreateMain();
		CM.prepareGUI();
	}


public void prepareGUI(){
	final JFrame JF = new JFrame("EMPLOYEE PORTAL");
	JF.setSize(400,400);
    JF.setLayout(new GridLayout(3, 1));
    JF.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
           System.exit(0);
        }        
     });    
	final JLabel JL1 = new JLabel("",JLabel.CENTER);
	final JLabel JL2 = new JLabel("",JLabel.CENTER);
	JL2.setSize(350,100);
	final JPanel JP  = new JPanel();
	JP.setLayout(new FlowLayout());
	
	
	final JCheckBox JCB1 = new JCheckBox("Select Color");
	final JButton JB1 = new JButton("OK");
	final JButton JB2 = new JButton("NOTOK");
	final JButton JB3 = new JButton("CANCEL");
	
	
    final DefaultComboBoxModel JCBX = new DefaultComboBoxModel();
        
    JCBX.addElement("CB1");
    JCBX.addElement("CB2");
    JCBX.addElement("CB3");
    JCBX.addElement("CB4");
    JCBX.addElement("CB5");
    
    final JComboBox JCBX1 = new JComboBox(JCBX);
    JCBX1.setSelectedIndex(0);
    final JScrollPane JSP2 = new JScrollPane(JCBX1);
    
    final DefaultListModel JLM1 = new DefaultListModel();
        
	JLM1.addElement("White1");
	JLM1.addElement("White2");
	JLM1.addElement("White3");
	JLM1.addElement("White4");
	JLM1.addElement("White5");
	JLM1.addElement("White6");

	final JList JLI1 = new JList(JLM1);
		
	JLI1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	JLI1.setSelectedIndex(0);
	JLI1.setVisibleRowCount(3);
	
	JScrollPane JSP1 = new JScrollPane(JLI1);
	
	JCB1.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			JL2.setText("Status is: "+(e.getStateChange()==1?"Selected":"Not Selected"));
			
//			Color bc1 = JColorChooser.showDialog(JF, "Select Color", Color.white);
//			if(bc1 != null){
//				JB1.setBackground(bc1);
//			}
		}
			
	});
	
	JB1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
//			 Color bc = JColorChooser.showDialog(JF,
//		               "Choose background color", Color.red);
//		            if(bc != null){
//		            	
//		               JL2.setBackground(bc);
//		               JF.getContentPane().setBackground(bc);
//		            }
//
//			JL2.setText("OK Button Clicked");
			if(JLI1.getSelectedIndex() !=-1){
				String data = "";
				data = "Selected Value: "+JLI1.getSelectedValue();
				JL1.setText(data);
			}
		}
	});
	
	JB2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JL2.setText("NOTOK Button Clicked");
		}
	});
	
	JB3.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
		
			JL2.setText("CANCEL Button Clicked");
		}
	});
	JL1.setText("HEADER DETAILS");
	JL2.setText("STATUS DETAILS");
	
	JF.add(JL1);
	JF.add(JP);
	JF.add(JL2);
	
	JP.add(JSP1);
	
	JP.add(JSP2);
	
	JP.add(JB1);
	JP.add(JB2);
	JP.add(JB3);
	
	JP.add(JCB1);
	
	JF.setVisible(true);
	
}
	
}