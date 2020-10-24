package com.company;

import javax.swing.*;
import java.awt.*;
//class BackgroundImageJFrame extends JFrame

public class Window {

    public  Window(){
        JFrame window = new JFrame();
        window.setSize(1920, 1080);
        //window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.cyan);
        window.setTitle("PacMan");
        window.setVisible(true);
        //window.setContentPane(new JLabel(new ImageIcon("C:\\Users\\barin\\Downloads")));
    }
}