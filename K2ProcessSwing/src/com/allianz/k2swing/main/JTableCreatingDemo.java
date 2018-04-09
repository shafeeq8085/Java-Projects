package com.allianz.k2swing.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableCreatingDemo {
  public static void main(String args[]) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//    Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
//        { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
//    Object columnNames[] = { "Column One", "Column Two", "Column Three" };
    Object rowData[][] = {{"","",""},{"","",""}};
    Object columnNames[] = {"","",""};
    rowData[0][0] = "R10";
    rowData[0][1] = "R11";
    rowData[0][2] = "R12";
    rowData[1][0] = "R20";
    rowData[1][1] = "R21";
    rowData[1][2] = "R22";
    
    columnNames[0] = "C1";
    columnNames[1] = "C2";
    columnNames[2] = "C3";
    JTable table = new JTable(rowData, columnNames);


    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(300, 150);
    frame.setVisible(true);

  }
}
