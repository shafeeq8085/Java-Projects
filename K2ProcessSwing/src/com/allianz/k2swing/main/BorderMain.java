package com.allianz.k2swing.main;

import java.awt.Color;
import java.awt.FlowLayout;
/*  w w  w.j  av  a2 s . c  om*/
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalIconFactory;

public class BorderMain extends JFrame {
  public BorderMain(String name) {
    getContentPane().setLayout(new FlowLayout());
    JLabel labelTwo = new JLabel("www.java2s.com");
    labelTwo.setBorder(BorderFactory.createEtchedBorder());
    
    add(labelTwo);
    
    
    JLabel labelThree = new JLabel("MatteBorder");
    labelThree.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.pink));
    add(labelThree);
    
    
    JLabel labelFour = new JLabel("TitledBorder");
    labelFour.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(10, 10,
        10, 10, MetalIconFactory.getFileChooserHomeFolderIcon()), "Title", TitledBorder.RIGHT, TitledBorder.BOTTOM));
    add(labelFour);
    
    JLabel labelSix = new JLabel("CompoundBorder");
    Border one = BorderFactory.createEtchedBorder();
    Border two = BorderFactory.createMatteBorder(4, 4, 4, 4, Color.blue);
    labelSix.setBorder(BorderFactory.createCompoundBorder(one, two));
    add(labelSix);
    
  }

  public static void main(String[] args) {
    JFrame frame = new BorderMain("javax.swing.JButton");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

  }
}
