package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

/**
 * A pacman game for two players created as a school project.
 *
 * @author Elias Görlitz
 * @author Luis Korda
 */

/**
 * The Main class.
 */
public class Main extends Frame {


    /**
     * The Game width.
     */
    static int GAME_WIDTH = 1350;
    /**
     * The Game height.
     */
    static int GAME_HEIGHT = 800;

    /**
     * The Window width.
     */
    static int WINDOW_WIDTH = 1920;
    /**
     * The Window height.
     */
    static int WINDOW_HEIGHT = 1080;

    /**
     * The gamestatus.
     */

  /*gamestatus 0 = game over
    gamestatus 1 = game running
    gamestatus 2 = startscreen
    gamestatus 3 = rule explanation
     */
    static int gamestatus = 2;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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