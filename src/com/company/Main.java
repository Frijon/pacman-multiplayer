package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends Frame {

    static int GAME_WIDTH = 1920;
    static int GAME_HEIGHT = 1080;

    static boolean run = true;

    public static void main(String[] args) {
        JFrame Frame = new JFrame();
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setTitle("Pacman");
        Frame.setSize(GAME_WIDTH, GAME_HEIGHT);

        Window panel = new Window();

        Frame.add(panel,BorderLayout.CENTER);
        Frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        Frame.setUndecorated(true);
        Frame.setVisible(true);


        String filepath = "src/com/company/PacMan-ThemeSong.wav";
        Music musicObject = new Music();
        //musicObject.playMusic(filepath);

    }


}