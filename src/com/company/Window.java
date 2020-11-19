package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JPanel implements KeyListener {

    static PacMan Pacman = new PacMan();
    static int ghostnumber = 1;
    static Ghost[] Ghosts = new Ghost[4];
    static Ghost Blueghost = new Ghost("blue");
    static Ghost Redghost = new Ghost("red");
    static Ghost Pinkghost = new Ghost("pink");
    static Ghost Greenghost = new Ghost("green");

    static boolean[] Keys = new boolean[4];

    static Image backgroundimg = Toolkit.getDefaultToolkit().createImage("src/com/company/index.png");
    static Image scaledImage = backgroundimg.getScaledInstance(Main.GAME_WIDTH, Main.GAME_HEIGHT, 0);

    static Image gameOverImg = Toolkit.getDefaultToolkit().createImage("src/com/company/GameOver.png");
    static Image scaledGameOverImg = gameOverImg.getScaledInstance(Main.GAME_WIDTH, Main.GAME_HEIGHT, 0);

    static Obstacle[] obstacles = new Obstacle[10];


    public Window() {
        this.addKeyListener(this);
        setFocusable(true);
        Ghosts[0] = Blueghost;
        Ghosts[1] = Redghost;
        Ghosts[2] = Pinkghost;
        Ghosts[3] = Greenghost;

        for (int i = 0; i < obstacles.length; i++){
            Obstacle obstacle = new Obstacle(0, 0, 0, 0);
            obstacles[i] = obstacle;
        }

        obstacles[0].posx = 0;
        obstacles[0].posy = 0;
        obstacles[0].width = 50;
        obstacles[0].height = 150;

        obstacles[1].posx = 50;
        obstacles[1].posy = 100;
        obstacles[1].width = 100;
        obstacles[1].height = 50;

        obstacles[2].posx = 0;
        obstacles[2].posy = 200;
        obstacles[2].width = 150;
        obstacles[2].height = 50;

        obstacles[3].posx = 150;
        obstacles[3].posy = 100;
        obstacles[3].width = 50;
        obstacles[3].height = 150;

        obstacles[4].posx = 100;
        obstacles[4].posy = 0;
        obstacles[4].width = 100;
        obstacles[4].height = 50;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (Main.run) {
            //g.drawImage(scaledImage, 0, 0, this);

            g.setColor(Color.black);
            g.fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);

            //drawing the map
            /*g.setColor(Color.blue);
            g.fillRect(0, 0, 100, 200);
            g.fillRect(100, 100, 200, 100);
            g.fillRect(400, 0, 100, 200);*/

            for (int i = 0; i < obstacles.length; i++) obstacles[i].draw(g);

            for (int i = 0; i < Ghosts.length; i++) {
                Ghosts[i].Movement();
            }

            Pacman.Movement();
            SleepRefresh();

            Pacman.drawPlayer(g);

            for (int i = 0; i < Ghosts.length; i++) {
                Ghosts[i].draw(g, Ghosts[i].color);
            }
        } else {
            g.drawImage(scaledGameOverImg, 0, 0, this);
        }
       
    }

    void SleepRefresh() {
        try {
            Thread.sleep(1000 / 30);
        } catch (Exception e) {

        }
        repaint();
    }

    public void keyPressed(KeyEvent arg0) {

        if (arg0.getKeyCode() == KeyEvent.VK_UP) {
            Keys[0] = true;
            Pacman.nextdir = "up";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
            Keys[1] = true;
            Pacman.nextdir = "left";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
            Keys[2] = true;
            Pacman.nextdir = "right";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
            Keys[3] = true;
            Pacman.nextdir = "down";
        }

        if (arg0.getKeyCode() == KeyEvent.VK_1) ghostnumber = 1;
        if (arg0.getKeyCode() == KeyEvent.VK_2) ghostnumber = 2;
        if (arg0.getKeyCode() == KeyEvent.VK_3) ghostnumber = 3;
        if (arg0.getKeyCode() == KeyEvent.VK_4) ghostnumber = 4;


        if (arg0.getKeyCode() == KeyEvent.VK_W) {
            Keys[0] = true;
            Ghosts[ghostnumber - 1].nextdir = "up";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_A) {
            Keys[1] = true;
            Ghosts[ghostnumber - 1].nextdir = "left";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_D) {
            Keys[2] = true;
            Ghosts[ghostnumber - 1].nextdir = "right";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_S) {
            Keys[3] = true;
            Ghosts[ghostnumber - 1].nextdir = "down";
        }
    }

    public void keyReleased(KeyEvent arg0) {
        /*if (arg0.getKeyCode() == KeyEvent.VK_UP) {
            Keys[0] = false;
            Pacman.dir = "";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
            Keys[1] = false;
            Pacman.dir = "";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
            Keys[2] = false;
            Pacman.dir = "";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
            Keys[3] = false;
            Pacman.dir = "";
        }

        if (arg0.getKeyCode() == KeyEvent.VK_W) {
            Keys[0] = false;
            Ghosts[ghostnumber - 1].dir = "";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_A) {
            Keys[1] = false;
            Ghosts[ghostnumber - 1].dir = "";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_D) {
            Keys[2] = false;
            Ghosts[ghostnumber - 1].dir = "";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_S) {
            Keys[3] = false;
            Ghosts[ghostnumber - 1].dir = "";
        }*/
    }

    public void keyTyped(KeyEvent arg0) {


    }


}