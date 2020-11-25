package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class Main extends Frame {

    static int GAME_WIDTH = 1350;
    static int GAME_HEIGHT = 800;

    static int WINDOW_WIDTH = 1920;
    static int WINDOW_HEIGHT = 1080;

    /*
    gamestatus 0 = game over
    gamestatus 1 = game running
    gamestatus 2 = startscreen
    gamestatus 3 = rule explanation
     */
    static int gamestatus = 2;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Pacman");
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.getContentPane().setBackground(Color.black);

        Window panel = new Window();
        frame.add(panel);

        panel.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 40,(WINDOW_HEIGHT - GAME_HEIGHT) / 2));

        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);

        Music musicObject = new Music();
        //musicObject.playMusic();
    }


}