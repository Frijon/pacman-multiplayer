package com.company;

import java.awt.*;
import java.awt.Graphics;

public class PacMan {
    int startx = 650, starty = 150;
    int vel = 5;
    int x = startx, y = starty;
    int size = 50;

    String dir = "";
    String nextDir = "";

    boolean movable = true;
    int score;

    public PacMan() {
    }

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

    void drawPlayer(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, size, size);
    }

    void drawScore(Graphics g) {
        g.setColor(Color.white);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawString("score: " + this.score, 650, 500);
    }
}