package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends Frame {

    public static void main(String[] args) {
        JFrame Frame = new JFrame();
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setTitle("Pacman");
        Frame.setSize(800,600);
        Image background = Toolkit.getDefaultToolkit().createImage("com/company/index.png");

        Window panel = new Window();


        /*JButton button1 = new JButton("Click!");
        JButton button2 = new JButton("Me");
        ActionListener l = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button1){
                    System.out.println("CLICK!");
                }
                if(e.getSource() == button2){
                    System.out.println("Me!");
                }
            }
        };

        button1.addActionListener(l);
        button2.addActionListener(l);

        // Hier fügen wir unserem Dialog unser JPanel hinzu


        Frame.add(button1,BorderLayout.SOUTH);
        Frame.add(button2,BorderLayout.NORTH);  */

        Frame.add(panel,BorderLayout.CENTER);
        Frame.setVisible(true);
    }
}