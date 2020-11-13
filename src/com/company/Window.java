package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JPanel implements KeyListener {

    PacMan Pacman = new PacMan();
    static int ghostnumber = 1;
    static Ghost[] Ghosts = new Ghost[4];
    Ghost Blueghost = new Ghost("blue");
    Ghost Redghost = new Ghost("red");
    Ghost Pinkghost = new Ghost("pink");
    Ghost Greenghost = new Ghost("green");

    static boolean[] Keys = new boolean[4];

    Image backgroundimg = Toolkit.getDefaultToolkit().createImage("src/com/company/index.png");
    Image scaledImage = backgroundimg.getScaledInstance(800, 600, 0);

    public Window() {
        this.addKeyListener(this);
        setFocusable(true);
        Ghosts[0] = Blueghost;
        Ghosts[1] = Redghost;
        Ghosts[2] = Pinkghost;
        Ghosts[3] = Greenghost;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaledImage, 0, 0, this);

        for (int i = 0; i < Ghosts.length; i++){
            Ghosts[i].Movement();
        }
        Pacman.Movement();
        SleepRefresh();

        Pacman.drawPlayer(g);

        for (int i = 0; i < Ghosts.length; i++){
            Ghosts[i].draw(g, Ghosts[i].color);
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
            Pacman.dir = "up";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
            Keys[1] = true;
            Pacman.dir = "left";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
            Keys[2] = true;
            Pacman.dir = "right";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
            Keys[3] = true;
            Pacman.dir = "down";
        }

        if (arg0.getKeyCode() == KeyEvent.VK_1) ghostnumber = 1;
        if (arg0.getKeyCode() == KeyEvent.VK_2) ghostnumber = 2;
        if (arg0.getKeyCode() == KeyEvent.VK_3) ghostnumber = 3;
        if (arg0.getKeyCode() == KeyEvent.VK_4) ghostnumber = 4;

        System.out.println("ghostnumber = " + ghostnumber);

        //blue ghost
        if (arg0.getKeyCode() == KeyEvent.VK_W) {
            Keys[0] = true;
            Ghosts[ghostnumber - 1].dir = "up";
            System.out.println("ghost[2].dir = " + Ghosts[2].dir);
            System.out.println("ghost[1].dir = " + Ghosts[1].dir);

            //System.out.println("ghost 1 posx = " + Ghosts[1].posx);
            //System.out.println("ghost 1 posy = " + Ghosts[1].posy);
        }
        if (arg0.getKeyCode() == KeyEvent.VK_A) {
            Keys[1] = true;
            Ghosts[ghostnumber - 1].dir = "left";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_D) {
            Keys[2] = true;
            Ghosts[ghostnumber - 1].dir = "right";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_S) {
            Keys[3] = true;
            Ghosts[ghostnumber - 1].dir = "down";
        }
        //break;

        //red ghost
            /*case 2:
                if (arg0.getKeyCode() == KeyEvent.VK_W) {
                    Keys[0] = true;
                    Ghosts[1].dir = "up";
                }
                if (arg0.getKeyCode() == KeyEvent.VK_A) {
                    Keys[1] = true;
                    Ghosts[1].dir = "left";
                }
                if (arg0.getKeyCode() == KeyEvent.VK_D) {
                    Keys[2] = true;
                    Ghosts[1].dir = "right";
                }
                if (arg0.getKeyCode() == KeyEvent.VK_S) {
                    Keys[3] = true;
                    Ghosts[1].dir = "down";
                }
                break;

            //pink ghost
            case 3:
                if (arg0.getKeyCode() == KeyEvent.VK_W) {
                    Keys[0] = true;
                    Ghosts[2].dir = "up";
                }
                if (arg0.getKeyCode() == KeyEvent.VK_A) {
                    Keys[1] = true;
                    Ghosts[2].dir = "left";
                }
                if (arg0.getKeyCode() == KeyEvent.VK_D) {
                    Keys[2] = true;
                    Ghosts[2].dir = "right";
                }
                if (arg0.getKeyCode() == KeyEvent.VK_S) {
                    Keys[3] = true;
                    Ghosts[2].dir = "down";
                }
                break;

            //yellow ghost
            case 4:
                if (arg0.getKeyCode() == KeyEvent.VK_W) {
                    Keys[0] = true;
                    Ghosts[3].dir = "up";
                }
                if (arg0.getKeyCode() == KeyEvent.VK_A) {
                    Keys[1] = true;
                    Ghosts[3].dir = "left";
                }
                if (arg0.getKeyCode() == KeyEvent.VK_D) {
                    Keys[2] = true;
                    Ghosts[3].dir = "right";
                }
                if (arg0.getKeyCode() == KeyEvent.VK_S) {
                    Keys[3] = true;
                    Ghosts[3].dir = "down";
                }
                break;*/
    }

    public void keyReleased(KeyEvent arg0) {
        if (arg0.getKeyCode() == KeyEvent.VK_UP) {
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
        }
    }

    public void keyTyped(KeyEvent arg0) {


    }


}