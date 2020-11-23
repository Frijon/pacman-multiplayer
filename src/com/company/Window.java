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
    static Image scaledImage = backgroundimg.getScaledInstance(Main.WINDOW_WIDTH, Main.WINODW_HEIGHT, 0);

    static Image gameOverImg = Toolkit.getDefaultToolkit().createImage("src/com/company/GameOver.png");
    static Image scaledGameOverImg = gameOverImg.getScaledInstance(Main.WINDOW_WIDTH, Main.WINODW_HEIGHT, 0);

    static Image startscreen = Toolkit.getDefaultToolkit().createImage("src/com/company/PacMan-Start _Screen.png");
    static Image scaledStartscreen = startscreen.getScaledInstance(Main.WINDOW_WIDTH, Main.WINODW_HEIGHT, 0);

    static Image startscreenSpace = Toolkit.getDefaultToolkit().createImage("src/com/company/PacMan-Start _Screen-Space.png");
    static Image scaledStartscreenSpace = startscreenSpace.getScaledInstance(Main.WINDOW_WIDTH, Main.WINODW_HEIGHT, 0);


    static Obstacle[] obstacles = new Obstacle[10];

    static int frame = 0;

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
        obstacles[0].width = 100;
        obstacles[0].height = 300;

        obstacles[1].posx = 0;
        obstacles[1].posy = 200;
        obstacles[1].width = 400;
        obstacles[1].height = 200;

        obstacles[2].posx = 200;
        obstacles[2].posy = 0;
        obstacles[2].width = 400;
        obstacles[2].height = 100;

        obstacles[3].posx = 500;
        obstacles[3].posy = 200;
        obstacles[3].width = 100;
        obstacles[3].height = 200;

        obstacles[4].posx = 0;
        obstacles[4].posy = 500;
        obstacles[4].width = 400;
        obstacles[4].height = 100;

        obstacles[5].posx = 0;
        obstacles[5].posy = 600;
        obstacles[5].width = 100;
        obstacles[5].height = 400;

        obstacles[6].posx = 200;
        obstacles[6].posy = 900;
        obstacles[6].width = 400;
        obstacles[6].height = 100;

        obstacles[7].posx = 200;
        obstacles[7].posy = 700;
        obstacles[7].width = 400;
        obstacles[7].height = 100;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        SleepRefresh();

        if (Main.gamestatus == 1) {
            //g.drawImage(scaledImage, 0, 0, this);

            //background
            g.setColor(Color.black);
            g.fillRect(0, 0, Main.WINDOW_WIDTH, Main.WINODW_HEIGHT);

            for (int i = 0; i < obstacles.length; i++) obstacles[i].draw(g);
            for (int i = 0; i < Ghosts.length; i++) {
                Ghosts[i].Movement();
                Ghosts[i].draw(g, Ghosts[i].color);
            }

            Pacman.Movement();
            Pacman.drawPlayer(g);
            //System.out.println("Pacman pos x=" + Pacman.x + ";pos y=" + Pacman.y);

        } else if (Main.gamestatus == 0){
            g.drawImage(scaledGameOverImg, 0, 0, this);
        } else if (Main.gamestatus == 2){
            if (frame <= 5) g.drawImage(scaledStartscreen, 0,0, this);
            else if (frame > 5) g.drawImage(scaledStartscreenSpace, 0,0, this);
        } else {
            System.out.println("Something is very wrong!!");
        }

        frame %= 10;
        frame++;

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

        if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
            Main.gamestatus = 1;
            System.out.println("Restart");
            Pacman.x = Pacman.startx;
            Pacman.y = Pacman.starty;
            Pacman.dir = "";
            Pacman.nextdir = "";
            for (int i = 0; i < Ghosts.length; i++){
                Ghosts[i].posx = 500;
                Ghosts[i].posy = 100;
                Ghosts[i].dir = "";
                Ghosts[i].nextdir = "";
            }

        }
    }

    public void keyReleased(KeyEvent arg0) {

    }

    public void keyTyped(KeyEvent arg0) {


    }


}