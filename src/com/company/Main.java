package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends Frame {

    static int WINDOW_WIDTH = 1900;
    static int WINODW_HEIGHT = 1000;


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
        Frame.setSize(WINDOW_WIDTH, WINODW_HEIGHT);

        Window panel = new Window();

        Frame.add(panel,BorderLayout.CENTER);
        /*Frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        Frame.setUndecorated(true);*/
        Frame.setVisible(true);

        String filepath = "src/com/company/PacMan-ThemeSong.wav";
        Music musicObject = new Music();
        //musicObject.playMusic(filepath);
    }


}