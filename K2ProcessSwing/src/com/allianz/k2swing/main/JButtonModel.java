package com.allianz.k2swing.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JButtonModel {
  public static void main(String[] args) {
    final JButton ok = new JButton("ok");

    JCheckBox cb = new JCheckBox("Enabled", true);

    ok.setBounds(40, 30, 80, 25);
    ok.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        DefaultButtonModel model = (DefaultButtonModel) ok.getModel();
        if (model.isEnabled())
          System.out.println("Enabled: true");
        else
          System.out.println("Enabled: false");

        if (model.isArmed())
          System.out.println("Armed: true");
        else
          System.out.println("Armed: false");

        if (model.isPressed())
          System.out.println("Pressed: true");
        else
          System.out.println("Pressed: false");
      }

    });

    cb.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        if (ok.isEnabled())
          ok.setEnabled(false);
        else
          ok.setEnabled(true);
      }
    });

    JFrame f = new JFrame();
    f.setLayout(new FlowLayout());
    f.add(ok);
    f.add(cb);
    f.setSize(350, 250);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }
}
