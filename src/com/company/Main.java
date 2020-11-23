package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends Frame {

    static int GAME_WIDTH = 1350;
    static int GAME_HEIGHT = 800;

    static int WINDOW_WIDTH = 1920;
    static int WINDOW_HEIGHT = 1080;

    /*
    gamestatus 0 = game over
    gamestatus 1 = game running
    gamestatus 2 = startscreen
     */
    static int gamestatus = 2;

    public static void main(String[] args) {
        JFrame Frame = new JFrame();
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setTitle("Pacman");
        Frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Frame.getContentPane().setBackground(Color.black);

        Window panel = new Window();
        Frame.add(panel, BorderLayout.CENTER);

        panel.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));

        Container contentPane = Frame.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 40,(WINDOW_HEIGHT - GAME_HEIGHT) / 2));

        Frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        Frame.setUndecorated(true);
        Frame.setVisible(true);

        String filepath = "src/com/company/PacMan-ThemeSong.wav";
        Music musicObject = new Music();
        //musicObject.playMusic(filepath);
    }


}