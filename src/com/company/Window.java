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

    static Image backgroundimg = Toolkit.getDefaultToolkit().createImage("src/com/company/index.png");
    static Image scaledImage = backgroundimg.getScaledInstance(Main.GAME_WIDTH, Main.GAME_HEIGHT, 0);

    static Image gameOverImg = Toolkit.getDefaultToolkit().createImage("src/com/company/GameOver.png");
    static Image scaledGameOverImg = gameOverImg.getScaledInstance(Main.GAME_WIDTH, Main.GAME_HEIGHT, 0);

    static Image startscreen = Toolkit.getDefaultToolkit().createImage("src/com/company/PacMan-Start _Screen.png");
    static Image scaledStartscreen = startscreen.getScaledInstance(Main.GAME_WIDTH, Main.GAME_HEIGHT, 0);

    static Image startscreenSpace = Toolkit.getDefaultToolkit().createImage("src/com/company/PacMan-Start _Screen-Space.png");
    static Image scaledStartscreenSpace = startscreenSpace.getScaledInstance(Main.GAME_WIDTH, Main.GAME_HEIGHT, 0);


    static Obstacle[] obstacles = new Obstacle[56];

    static int frame = 0;

    public Window() {
        this.addKeyListener(this);
        setFocusable(true);
        Ghosts[0] = Blueghost;
        Ghosts[1] = Redghost;
        Ghosts[2] = Pinkghost;
        Ghosts[3] = Greenghost;

        for (int i = 0; i < obstacles.length; i++) {
            Obstacle obstacle = new Obstacle(0, 0, 0, 0);
            obstacles[i] = obstacle;
        }

        obstacles[0].posx = 0;
        obstacles[0].posy = 0;
        obstacles[0].width = 50;
        obstacles[0].height = 150;

        obstacles[1].posx = 0;
        obstacles[1].posy = 100;
        obstacles[1].width = 200;
        obstacles[1].height = 100;

        obstacles[2].posx = 100;
        obstacles[2].posy = 0;
        obstacles[2].width = 200;
        obstacles[2].height = 50;

        obstacles[3].posx = 250;
        obstacles[3].posy = 100;
        obstacles[3].width = 50;
        obstacles[3].height = 200;

        obstacles[4].posx = 0;
        obstacles[4].posy = 250;
        obstacles[4].width = 200;
        obstacles[4].height = 50;

        obstacles[5].posx = 0;
        obstacles[5].posy = 250;
        obstacles[5].width = 50;
        obstacles[5].height = 250;

        obstacles[6].posx = 100;
        obstacles[6].posy = 450;
        obstacles[6].width = 250;
        obstacles[6].height = 50;

        obstacles[7].posx = 100;
        obstacles[7].posy = 350;
        obstacles[7].width = 200;
        obstacles[7].height = 50;

        obstacles[8].posx = 1300;
        obstacles[8].posy = 0;
        obstacles[8].width = 50;
        obstacles[8].height = 150;

        obstacles[9].posx = 1150;
        obstacles[9].posy = 100;
        obstacles[9].width = 200;
        obstacles[9].height = 100;

        obstacles[10].posx = 1050;
        obstacles[10].posy = 0;
        obstacles[10].width = 200;
        obstacles[10].height = 50;

        obstacles[11].posx = 1050;
        obstacles[11].posy = 100;
        obstacles[11].width = 50;
        obstacles[11].height = 200;

        obstacles[12].posx = 1150;
        obstacles[12].posy = 250;
        obstacles[12].width = 200;
        obstacles[12].height = 50;

        obstacles[13].posx = 1300;
        obstacles[13].posy = 250;
        obstacles[13].width = 50;
        obstacles[13].height = 250;

        obstacles[14].posx = 1000;
        obstacles[14].posy = 450;
        obstacles[14].width = 250;
        obstacles[14].height = 50;

        obstacles[15].posx = 1050;
        obstacles[15].posy = 350;
        obstacles[15].width = 200;
        obstacles[15].height = 50;

        obstacles[16].posx = 350;
        obstacles[16].posy = 0;
        obstacles[16].width = 300;
        obstacles[16].height = 50;

        obstacles[17].posx = 700;
        obstacles[17].posy = 0;
        obstacles[17].width = 300;
        obstacles[17].height = 50;

        obstacles[18].posx = 1100;
        obstacles[18].posy = 350;
        obstacles[18].width = 150;
        obstacles[18].height = 50;

        obstacles[19].posx = 550;
        obstacles[19].posy = 100;
        obstacles[19].width = 250;
        obstacles[19].height = 50;

        obstacles[20].posx = 250;
        obstacles[20].posy = 100;
        obstacles[20].width = 150;
        obstacles[20].height = 50;

        obstacles[21].posx = 450;
        obstacles[21].posy = 100;
        obstacles[21].width = 50;
        obstacles[21].height = 50;

        obstacles[22].posx = 850;
        obstacles[22].posy = 100;
        obstacles[22].width = 50;
        obstacles[22].height = 50;

        obstacles[23].posx = 950;
        obstacles[23].posy = 100;
        obstacles[23].width = 150;
        obstacles[23].height = 50;

        obstacles[24].posx = 350;
        obstacles[24].posy = 200;
        obstacles[24].width = 300;
        obstacles[24].height = 50;

        obstacles[25].posx = 700;
        obstacles[25].posy = 200;
        obstacles[25].width = 300;
        obstacles[25].height = 50;

        obstacles[26].posx = 0;
        obstacles[26].posy = 550;
        obstacles[26].width = 50;
        obstacles[26].height = 250;

        obstacles[27].posx = 100;
        obstacles[27].posy = 750;
        obstacles[27].width = 200;
        obstacles[27].height = 50;

        obstacles[28].posx = 100;
        obstacles[28].posy = 550;
        obstacles[28].width = 50;
        obstacles[28].height = 50;

        obstacles[29].posx = 100;
        obstacles[29].posy = 650;
        obstacles[29].width = 50;
        obstacles[29].height = 50;

        obstacles[30].posx = 200;
        obstacles[30].posy = 550;
        obstacles[30].width = 50;
        obstacles[30].height = 50;

        obstacles[31].posx = 200;
        obstacles[31].posy = 650;
        obstacles[31].width = 50;
        obstacles[31].height = 50;

        obstacles[32].posx = 300;
        obstacles[32].posy = 450;
        obstacles[32].width = 50;
        obstacles[32].height = 250;

        obstacles[33].posx = 1100;
        obstacles[33].posy = 550;
        obstacles[33].width = 50;
        obstacles[33].height = 50;

        obstacles[34].posx = 1200;
        obstacles[34].posy = 550;
        obstacles[34].width = 50;
        obstacles[34].height = 50;

        obstacles[35].posx = 1300;
        obstacles[35].posy = 550;
        obstacles[35].width = 50;
        obstacles[35].height = 250;

        obstacles[36].posx = 1100;
        obstacles[36].posy = 650;
        obstacles[36].width = 50;
        obstacles[36].height = 50;

        obstacles[37].posx = 1200;
        obstacles[37].posy = 650;
        obstacles[37].width = 50;
        obstacles[37].height = 50;

        obstacles[38].posx = 1050;
        obstacles[38].posy = 750;
        obstacles[38].width = 200;
        obstacles[38].height = 50;

        obstacles[39].posx = 1000;
        obstacles[39].posy = 450;
        obstacles[39].width = 50;
        obstacles[39].height = 250;

        obstacles[40].posx = 350;
        obstacles[40].posy = 750;
        obstacles[40].width = 300;
        obstacles[40].height = 50;

        obstacles[41].posx = 700;
        obstacles[41].posy = 750;
        obstacles[41].width = 300;
        obstacles[41].height = 50;

        obstacles[42].posx = 500;
        obstacles[42].posy = 550;
        obstacles[42].width = 350;
        obstacles[42].height = 50;

        obstacles[43].posx = 500;
        obstacles[43].posy = 400;
        obstacles[43].width = 50;
        obstacles[43].height = 200;

        obstacles[44].posx = 800;
        obstacles[44].posy = 400;
        obstacles[44].width = 50;
        obstacles[44].height = 200;

        obstacles[45].posx = 500;
        obstacles[45].posy = 400;
        obstacles[45].width = 100;
        obstacles[45].height = 50;

        obstacles[46].posx = 750;
        obstacles[46].posy = 400;
        obstacles[46].width = 100;
        obstacles[46].height = 50;

        obstacles[47].posx = 550;
        obstacles[47].posy = 300;
        obstacles[47].width = 250;
        obstacles[47].height = 50;

        obstacles[48].posx = 550;
        obstacles[48].posy = 650;
        obstacles[48].width = 250;
        obstacles[48].height = 50;

        obstacles[49].posx = 900;
        obstacles[49].posy = 400;
        obstacles[49].width = 50;
        obstacles[49].height = 300;

        obstacles[50].posx = 850;
        obstacles[50].posy = 650;
        obstacles[50].width = 100;
        obstacles[50].height = 50;

        obstacles[51].posx = 400;
        obstacles[51].posy = 650;
        obstacles[51].width = 100;
        obstacles[51].height = 50;

        obstacles[52].posx = 400;
        obstacles[52].posy = 400;
        obstacles[52].width = 50;
        obstacles[52].height = 300;

        obstacles[53].posx = 850;
        obstacles[53].posy = 300;
        obstacles[53].width = 150;
        obstacles[53].height = 50;

        obstacles[54].posx = 350;
        obstacles[54].posy = 300;
        obstacles[54].width = 150;
        obstacles[54].height = 50;

        obstacles[55].posx = 600;
        obstacles[55].posy = 400;
        obstacles[55].width = 150;
        obstacles[55].height = 50;

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (Main.gamestatus == 1) {

            //background
            g.setColor(Color.black);
            g.fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
            g.setColor(new Color(7, 7, 7));
            g.fillRoundRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT, 30, 30);

            for (int i = 0; i < obstacles.length; i++) obstacles[i].draw(g);
            for (int i = 0; i < Ghosts.length; i++) {
                Ghosts[i].movement();
                Ghosts[i].draw(g, Ghosts[i].color);
            }

            Pacman.Movement();
            Pacman.drawPlayer(g);
            Pacman.drawScore(g);
            Pacman.score++;

        } else if (Main.gamestatus == 0) {
            g.drawImage(scaledGameOverImg, 0, 0, this);
        } else if (Main.gamestatus == 2) {
            if (frame <= 10) g.drawImage(scaledStartscreen, 0, 0, this);
            else g.drawImage(scaledStartscreenSpace, 0, 0, this);
        } else if (Main.gamestatus == 3) {
            g.setColor(Color.black);
            g.fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
            g.setColor(Color.red);
            g.fillRoundRect(100, 100, 100, 100, 30, 30);
        } else {
            System.out.println("Something is very wrong!!");
        }

        frame %= 20;
        frame++;

        g.setColor(Color.white);
        g.drawRoundRect(0, 0, Main.GAME_WIDTH - 1, Main.GAME_HEIGHT - 1, 30, 30);

        SleepRefresh();
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
            //Keys[0] = true;
            Pacman.nextdir = "up";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
            //Keys[1] = true;
            Pacman.nextdir = "left";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
            //Keys[2] = true;
            Pacman.nextdir = "right";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
            //Keys[3] = true;
            Pacman.nextdir = "down";
        }

        if (arg0.getKeyCode() == KeyEvent.VK_1) ghostnumber = 1;
        if (arg0.getKeyCode() == KeyEvent.VK_2) ghostnumber = 2;
        if (arg0.getKeyCode() == KeyEvent.VK_3) ghostnumber = 3;
        if (arg0.getKeyCode() == KeyEvent.VK_4) ghostnumber = 4;


        if (arg0.getKeyCode() == KeyEvent.VK_W) {
            //Keys[0] = true;
            Ghosts[ghostnumber - 1].nextdir = "up";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_A) {
            //Keys[1] = true;
            Ghosts[ghostnumber - 1].nextdir = "left";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_D) {
            //Keys[2] = true;
            Ghosts[ghostnumber - 1].nextdir = "right";
        }
        if (arg0.getKeyCode() == KeyEvent.VK_S) {
            //Keys[3] = true;
            Ghosts[ghostnumber - 1].nextdir = "down";
        }

        if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
            if (Main.gamestatus == 3) {
                Main.gamestatus = 1;
                System.out.println("Restart");
                Pacman.x = Pacman.startx;
                Pacman.y = Pacman.starty;
                Pacman.dir = "";
                Pacman.nextdir = "";
                Pacman.score = 0;
                for (int i = 0; i < Ghosts.length; i++) {
                    Ghosts[i].posx = Ghosts[i].startposx;
                    Ghosts[i].posy = Ghosts[i].startposy;
                    Ghosts[i].dir = "";
                    Ghosts[i].nextdir = "";
                }
            } else if (Main.gamestatus == 2) {
                Main.gamestatus = 3;
            }
        }

        if (arg0.getKeyCode() == KeyEvent.VK_B) {
            System.exit(0);
        }

    }

    public void keyReleased(KeyEvent arg0) {

    }

    public void keyTyped(KeyEvent arg0) {


    }


}