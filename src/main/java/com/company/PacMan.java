package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Graphics;
import java.io.IOException;

/**
 * The class pacman, which is controlled by one player.
 */
public class PacMan {
    /**
     * The starting x position.
     */
    int startx = 650, /**
     * The starting y position.
     */
    starty = 150;
    /**
     * The movement velocity of the pacman.
     */
    int vel = 5;
    /**
     * The x position of the pacman.
     */
    int x = startx, /**
     * The y position.
     */
    y = starty;
    /**
     * The size of the pacman.
     */
    int size = 50;

    /**
     * A frame counter variable for the animation.
     */
    int frame = 1;

    /**
     * The direction of the pacman.
     */
    String dir = "";
    /**
     * The next direction of the pacman which is going to be set to the current direction as soon as the x or y pos % 50 is 0.
     */
    String nextDir = "";

    /**
     * The variable "movable" which indicates if the pacman is moving.
     */
    boolean movable = true;
    /**
     * The score which is calculated by the time alive of the pacman.
     */
    int score;

    /**
     * Initialization of the variables for the images.
     */
    static Image up1;
    static Image up2;
    static Image up3;
    static Image right1;
    static Image right2;
    static Image down1;
    static Image down2;
    static Image left1;
    static Image left2;

    /**
     * Loading all the pacman images.
     */
    static {
        try {
            up1 = ImageIO.read(Ghost.class.getResource("/Up1.png"));
            up2 = ImageIO.read(Ghost.class.getResource("/Up2.png"));
            up3 = ImageIO.read(Ghost.class.getResource("/3.png"));

            right1 = ImageIO.read(Ghost.class.getResource("/Right1.png"));
            right2 = ImageIO.read(Ghost.class.getResource("/Right2.png"));

            down1 = ImageIO.read(Ghost.class.getResource("/Down1.png"));
            down2 = ImageIO.read(Ghost.class.getResource("/Down2.png"));

            left1 = ImageIO.read(Ghost.class.getResource("/Left1.png"));
            left2 = ImageIO.read(Ghost.class.getResource("/Left2.png"));

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Instantiates a new pacman.
     */
    public PacMan() {
    }

    /**
     * Movement for the pacman, it checks for borders, obstacles and for collision with the ghosts.
     */
    void movement() {

        if (this.movable) {
            if ((this.x >= (-size) && this.x <= Main.GAME_WIDTH) && (this.y >= (-size) && this.y <= Main.GAME_HEIGHT)) {
                if (this.x % 50 == 0 && this.y % 50 == 0) this.dir = this.nextDir;
                switch (this.dir) {
                    case "up" -> y -= vel;
                    case "down" -> y += vel;
                    case "left" -> x -= vel;
                    case "right" -> x += vel;
                }
            }
        }

        for (int i = 0; i < Window.obstacles.length; i++){
            if ((this.x < Window.obstacles[i].posX + Window.obstacles[i].width) && (this.x + this.size > Window.obstacles[i].posX) &&(this.y < Window.obstacles[i].posY + Window.obstacles[i].height) && (this.y + this.size > Window.obstacles[i].posY)) this.movable = false;
        }

        if (!this.movable) {
            switch (this.dir) {
                case "down" -> y -= vel;
                case "up" -> y += vel;
                case "right" -> x -= vel;
                case "left" -> x += vel;
            }
            this.movable = true;
            this.dir = "";
            this.nextDir = "";
        }

        if (this.x < -size) this.x = Main.GAME_WIDTH;
        if (this.x > Main.GAME_WIDTH) this.x = -size;
        if (this.y < -size) this.y = Main.GAME_HEIGHT;
        if (this.y > Main.GAME_HEIGHT) this.y = -size;

        for (int i = 0; i < Window.ghosts.length; i++) {
            if ((((this.x + size) > Window.ghosts[i].posx) && (this.x < (Window.ghosts[i].posx + Window.ghosts[i].size))) && ((this.y < (Window.ghosts[i].posy + Window.ghosts[i].size)) && ((this.y + this.size) > Window.ghosts[i].posy))) {
                System.out.println("Game lost!");
                Main.gamestatus = 0;
            }
        }
    }

    /**
     * Drawing the player, depending on the movement direction.
     * @param g the Graphics to be able to draw.
     */
    void drawPlayer(Graphics g) {
        switch (this.dir) {
            case "up" -> {
                if (frame == 1) {
                    g.drawImage(up1, x, y, size, size, null);
                } else if (frame == 2) {
                    g.drawImage(up2, x, y, size, size, null);
                } else {
                    g.drawImage(up3, x, y, size, size, null);
                    frame = 1;
                    return;
                }
                frame++;
            }
            case "right" -> {
                if (frame == 1) {
                    g.drawImage(right1, x, y, size, size, null);
                } else if (frame == 2) {
                    g.drawImage(right2, x, y, size, size, null);
                } else {
                    g.drawImage(up3, x, y, size, size, null);
                    frame = 1;
                    return;
                }
                frame++;
            }
            case "down" -> {
                if (frame == 1) {
                    g.drawImage(down1, x, y, size, size, null);
                } else if (frame == 2) {
                    g.drawImage(down2, x, y, size, size, null);
                } else {
                    g.drawImage(up3, x, y, size, size, null);
                    frame = 1;
                    return;
                }
                frame++;
            }
            case "left" -> {
                if (frame == 1) {
                    g.drawImage(left1, x, y, size, size, null);
                } else if (frame == 2) {
                    g.drawImage(left2, x, y, size, size, null);
                } else {
                    g.drawImage(up3, x, y, size, size, null);
                    frame = 1;
                    return;
                }
                frame++;
            }
            default -> g.drawImage(right2, x, y, size, size, null);
        }
    }

    /**
     * Drawing the score in the middle of the screen.
     * @param g the Graphics to be able to draw.
     */
    void drawScore(Graphics g) {
        g.setColor(Color.white);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawString("score: " + this.score, 650, 500);
    }
}