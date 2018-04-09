package com.allianz.k2swing.main;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

class MyComponent extends JComponent {
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Customize after calling super.paintComponent(g)

    g.drawString("string",20,20);
  }

}

public class PaintingJComponentObjects {
  public static void main(String[] args) {
    JFrame aWindow = new JFrame();
    aWindow.setBounds(30, 30, 300, 300); // Size
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    MyComponent com = new MyComponent();

    aWindow.add(com);

    aWindow.setVisible(true); // Display the window
  }
}
