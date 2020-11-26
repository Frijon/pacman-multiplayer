package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * The Window class which is drawing everything and listening for key inputs
 */
public class Window extends JPanel implements KeyListener {

    /**
     * The Pacman.
     */
    static PacMan pacman = new PacMan();
    /**
     * The Ghostnumber which is selected by the user.
     */
    static int ghostnumber = 1;
    /**
     * An Array of Ghosts.
     */
    static Ghost[] ghosts = new Ghost[4];
    /**
     * The Ghosts.
     */
    static Ghost blueghost = new Ghost("blue");
    /**
     * The Redghost.
     */
    static Ghost redghost = new Ghost("red");
    /**
     * The Pinkghost.
     */
    static Ghost pinkghost = new Ghost("orange");
    /**
     * The Greenghost.
     */
    static Ghost greenghost = new Ghost("green");

    /**
     * Array of Obstacles.
     */
    static Obstacle[] obstacles = new Obstacle[56];

    /**
     * Frame count for animated frames.
     */
    static int frame = 0;

    /**
     * Loading different images for the game over screen, startscreen with the space key sign and startscreen without the sign.
     */
    static Image gameOverImg;
    static Image gameOverSpaceImg;
    static Image startscreen;
    static Image startscreenSpace;

    static {
        try {
            gameOverImg = ImageIO.read(Ghost.class.getResource("/gameOver.png"));
            gameOverSpaceImg = ImageIO.read(Ghost.class.getResource("/gameOver-Space.png"));
            startscreenSpace = ImageIO.read(Ghost.class.getResource("/PacMan-Start _Screen-Space.png"));
            startscreen = ImageIO.read(Ghost.class.getResource("/PacMan-Start _Screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Instantiates a new Window, puts the ghosts into an array and generates all obstacles.
     */
    public Window() {
        this.addKeyListener(this);
        setFocusable(true);
        ghosts[0] = blueghost;
        ghosts[1] = redghost;
        ghosts[2] = pinkghost;
        ghosts[3] = greenghost;

        for (int i = 0; i < obstacles.length; i++) {
            Obstacle obstacle = new Obstacle(0, 0, 0, 0);
            obstacles[i] = obstacle;
        }

        obstacles[0].posX = 0;
        obstacles[0].posY = 0;
        obstacles[0].width = 50;
        obstacles[0].height = 150;

        obstacles[1].posX = 0;
        obstacles[1].posY = 100;
        obstacles[1].width = 200;
        obstacles[1].height = 100;

        obstacles[2].posX = 100;
        obstacles[2].posY = 0;
        obstacles[2].width = 200;
        obstacles[2].height = 50;

        obstacles[3].posX = 250;
        obstacles[3].posY = 100;
        obstacles[3].width = 50;
        obstacles[3].height = 200;

        obstacles[4].posX = 0;
        obstacles[4].posY = 250;
        obstacles[4].width = 200;
        obstacles[4].height = 50;

        obstacles[5].posX = 0;
        obstacles[5].posY = 250;
        obstacles[5].width = 50;
        obstacles[5].height = 250;

        obstacles[6].posX = 100;
        obstacles[6].posY = 450;
        obstacles[6].width = 250;
        obstacles[6].height = 50;

        obstacles[7].posX = 100;
        obstacles[7].posY = 350;
        obstacles[7].width = 200;
        obstacles[7].height = 50;

        obstacles[8].posX = 1300;
        obstacles[8].posY = 0;
        obstacles[8].width = 50;
        obstacles[8].height = 150;

        obstacles[9].posX = 1150;
        obstacles[9].posY = 100;
        obstacles[9].width = 200;
        obstacles[9].height = 100;

        obstacles[10].posX = 1050;
        obstacles[10].posY = 0;
        obstacles[10].width = 200;
        obstacles[10].height = 50;

        obstacles[11].posX = 1050;
        obstacles[11].posY = 100;
        obstacles[11].width = 50;
        obstacles[11].height = 200;

        obstacles[12].posX = 1150;
        obstacles[12].posY = 250;
        obstacles[12].width = 200;
        obstacles[12].height = 50;

        obstacles[13].posX = 1300;
        obstacles[13].posY = 250;
        obstacles[13].width = 50;
        obstacles[13].height = 250;

        obstacles[14].posX = 1000;
        obstacles[14].posY = 450;
        obstacles[14].width = 250;
        obstacles[14].height = 50;

        obstacles[15].posX = 1050;
        obstacles[15].posY = 350;
        obstacles[15].width = 200;
        obstacles[15].height = 50;

        obstacles[16].posX = 350;
        obstacles[16].posY = 0;
        obstacles[16].width = 300;
        obstacles[16].height = 50;

        obstacles[17].posX = 700;
        obstacles[17].posY = 0;
        obstacles[17].width = 300;
        obstacles[17].height = 50;

        obstacles[18].posX = 1100;
        obstacles[18].posY = 350;
        obstacles[18].width = 150;
        obstacles[18].height = 50;

        obstacles[19].posX = 550;
        obstacles[19].posY = 100;
        obstacles[19].width = 250;
        obstacles[19].height = 50;

        obstacles[20].posX = 250;
        obstacles[20].posY = 100;
        obstacles[20].width = 150;
        obstacles[20].height = 50;

        obstacles[21].posX = 450;
        obstacles[21].posY = 100;
        obstacles[21].width = 50;
        obstacles[21].height = 50;

        obstacles[22].posX = 850;
        obstacles[22].posY = 100;
        obstacles[22].width = 50;
        obstacles[22].height = 50;

        obstacles[23].posX = 950;
        obstacles[23].posY = 100;
        obstacles[23].width = 150;
        obstacles[23].height = 50;

        obstacles[24].posX = 350;
        obstacles[24].posY = 200;
        obstacles[24].width = 300;
        obstacles[24].height = 50;

        obstacles[25].posX = 700;
        obstacles[25].posY = 200;
        obstacles[25].width = 300;
        obstacles[25].height = 50;

        obstacles[26].posX = 0;
        obstacles[26].posY = 550;
        obstacles[26].width = 50;
        obstacles[26].height = 250;

        obstacles[27].posX = 100;
        obstacles[27].posY = 750;
        obstacles[27].width = 200;
        obstacles[27].height = 50;

        obstacles[28].posX = 100;
        obstacles[28].posY = 550;
        obstacles[28].width = 50;
        obstacles[28].height = 50;

        obstacles[29].posX = 100;
        obstacles[29].posY = 650;
        obstacles[29].width = 50;
        obstacles[29].height = 50;

        obstacles[30].posX = 200;
        obstacles[30].posY = 550;
        obstacles[30].width = 50;
        obstacles[30].height = 50;

        obstacles[31].posX = 200;
        obstacles[31].posY = 650;
        obstacles[31].width = 50;
        obstacles[31].height = 50;

        obstacles[32].posX = 300;
        obstacles[32].posY = 450;
        obstacles[32].width = 50;
        obstacles[32].height = 250;

        obstacles[33].posX = 1100;
        obstacles[33].posY = 550;
        obstacles[33].width = 50;
        obstacles[33].height = 50;

        obstacles[34].posX = 1200;
        obstacles[34].posY = 550;
        obstacles[34].width = 50;
        obstacles[34].height = 50;

        obstacles[35].posX = 1300;
        obstacles[35].posY = 550;
        obstacles[35].width = 50;
        obstacles[35].height = 250;

        obstacles[36].posX = 1100;
        obstacles[36].posY = 650;
        obstacles[36].width = 50;
        obstacles[36].height = 50;

        obstacles[37].posX = 1200;
        obstacles[37].posY = 650;
        obstacles[37].width = 50;
        obstacles[37].height = 50;

        obstacles[38].posX = 1050;
        obstacles[38].posY = 750;
        obstacles[38].width = 200;
        obstacles[38].height = 50;

        obstacles[39].posX = 1000;
        obstacles[39].posY = 450;
        obstacles[39].width = 50;
        obstacles[39].height = 250;

        obstacles[40].posX = 350;
        obstacles[40].posY = 750;
        obstacles[40].width = 300;
        obstacles[40].height = 50;

        obstacles[41].posX = 700;
        obstacles[41].posY = 750;
        obstacles[41].width = 300;
        obstacles[41].height = 50;

        obstacles[42].posX = 500;
        obstacles[42].posY = 550;
        obstacles[42].width = 350;
        obstacles[42].height = 50;

        obstacles[43].posX = 500;
        obstacles[43].posY = 400;
        obstacles[43].width = 50;
        obstacles[43].height = 200;

        obstacles[44].posX = 800;
        obstacles[44].posY = 400;
        obstacles[44].width = 50;
        obstacles[44].height = 200;

        obstacles[45].posX = 500;
        obstacles[45].posY = 400;
        obstacles[45].width = 100;
        obstacles[45].height = 50;

        obstacles[46].posX = 750;
        obstacles[46].posY = 400;
        obstacles[46].width = 100;
        obstacles[46].height = 50;

        obstacles[47].posX = 550;
        obstacles[47].posY = 300;
        obstacles[47].width = 250;
        obstacles[47].height = 50;

        obstacles[48].posX = 550;
        obstacles[48].posY = 650;
        obstacles[48].width = 250;
        obstacles[48].height = 50;

        obstacles[49].posX = 900;
        obstacles[49].posY = 400;
        obstacles[49].width = 50;
        obstacles[49].height = 300;

        obstacles[50].posX = 850;
        obstacles[50].posY = 650;
        obstacles[50].width = 100;
        obstacles[50].height = 50;

        obstacles[51].posX = 400;
        obstacles[51].posY = 650;
        obstacles[51].width = 100;
        obstacles[51].height = 50;

        obstacles[52].posX = 400;
        obstacles[52].posY = 400;
        obstacles[52].width = 50;
        obstacles[52].height = 300;

        obstacles[53].posX = 850;
        obstacles[53].posY = 300;
        obstacles[53].width = 150;
        obstacles[53].height = 50;

        obstacles[54].posX = 350;
        obstacles[54].posY = 300;
        obstacles[54].width = 150;
        obstacles[54].height = 50;

        obstacles[55].posX = 600;
        obstacles[55].posY = 400;
        obstacles[55].width = 150;
        obstacles[55].height = 50;
    }

    /**
     * overrides the paintComponent method from jframe and draws everything, depending on the game status.
     *
     * @param g containing the graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (Main.gamestatus == 1) {
            g.setColor(Color.black);
            g.fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
            g.setColor(new Color(7, 7, 7));
            g.fillRoundRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT, 30, 30);

            for (Obstacle obstacle : obstacles) obstacle.draw(g);
            for (int i = 0; i < ghosts.length; i++) {
                ghosts[i].movement(i);
                ghosts[i].draw(g, ghosts[i].color);
            }

            pacman.movement();
            pacman.drawPlayer(g);
            pacman.drawScore(g);
            if (frame % 5 == 0) pacman.score++;

        } else if (Main.gamestatus == 0) {
            if (frame <= 10) g.drawImage(gameOverImg, 0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT, this);
            else g.drawImage(gameOverSpaceImg, 0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT, this);
        }
        else if (Main.gamestatus == 2) {
            if (frame <= 10) g.drawImage(startscreen, 0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT, this);
            else g.drawImage(startscreenSpace, 0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT, this);
        } else {
            g.setColor(Color.black);
            g.fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
            g.setColor(Color.red);
            g.fillRoundRect(100, 100, 100, 100, 30, 30);
        }

        g.setColor(Color.white);
        g.drawRoundRect(0, 0, Main.GAME_WIDTH - 1, Main.GAME_HEIGHT - 1, 30, 30);

        frame %= 20;
        frame++;
        SleepRefresh();
    }


    /**
     * Redraw function.
     */
    void SleepRefresh() {
        try {
            Thread.sleep(1000 / 30);
        } catch (Exception e) {
            e.printStackTrace();
        }
        repaint();
    }

    /**
     * Detecting keypresses, automatically by the JFrame.
     *
     * @param e the keyboard event
     */
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) pacman.nextDir = "up";
        if (e.getKeyCode() == KeyEvent.VK_LEFT) pacman.nextDir = "left";
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) pacman.nextDir = "right";
        if (e.getKeyCode() == KeyEvent.VK_DOWN) pacman.nextDir = "down";

        if (e.getKeyCode() == KeyEvent.VK_1) ghostnumber = 1;
        if (e.getKeyCode() == KeyEvent.VK_2) ghostnumber = 2;
        if (e.getKeyCode() == KeyEvent.VK_3) ghostnumber = 3;
        if (e.getKeyCode() == KeyEvent.VK_4) ghostnumber = 4;

        if (e.getKeyCode() == KeyEvent.VK_W) ghosts[ghostnumber - 1].nextdir = "up";
        if (e.getKeyCode() == KeyEvent.VK_A) ghosts[ghostnumber - 1].nextdir = "left";
        if (e.getKeyCode() == KeyEvent.VK_D) ghosts[ghostnumber - 1].nextdir = "right";
        if (e.getKeyCode() == KeyEvent.VK_S) ghosts[ghostnumber - 1].nextdir = "down";

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (Main.gamestatus == 3 || Main.gamestatus == 0) {
                Main.gamestatus = 1;
                pacman.x = pacman.startx;
                pacman.y = pacman.starty;
                pacman.dir = "";
                pacman.nextDir = "";
                pacman.score = 0;
                for (int i = 0; i < ghosts.length; i++) {
                    ghosts[i].posx = ghosts[i].startPosX;
                    ghosts[i].posy = ghosts[i].startPosY;
                    ghosts[i].dir = "";
                    ghosts[i].nextdir = "";
                }
            } else if (Main.gamestatus == 2) Main.gamestatus = 3;
        }

        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_Q) System.exit(0);
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_R) {
            Main.gamestatus = 1;
            pacman.x = pacman.startx;
            pacman.y = pacman.starty;
            pacman.dir = "";
            pacman.nextDir = "";
            pacman.score = 0;
            for (Ghost ghost : ghosts) {
                ghost.posx = ghost.startPosX;
                ghost.posy = ghost.startPosY;
                ghost.dir = "";
                ghost.nextdir = "";
            }
        }
    }

    /**
     * Unused function detecting key releases.
     * @param arg0
     */
    public void keyReleased(KeyEvent arg0) {
    }

    /**
     * Unused function detecting typed keys.
     * @param arg0
     */
    public void keyTyped(KeyEvent arg0) {
    }

}

