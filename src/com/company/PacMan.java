package com.company;

import java.awt.*;
import java.awt.Graphics;

public class PacMan {
    int startx = 50, starty = 50, vel = 10;
    int x = startx, y = starty, size = 50;
    String dir = "";
    String nextdir = "";
    boolean movable = true;

    public PacMan() {


    }

    void Movement() {

        if (this.movable) {
            if ((this.x >= (-size) && this.x <= Main.GAME_WIDTH) && (this.y >= (-size) && this.y <= Main.GAME_HEIGHT)) {
                if (this.x % 50 == 0 && this.y % 50 == 0) this.dir = this.nextdir;
                switch (this.dir) {
                    case "up":
                        y -= vel;
                        break;
                    case "down":
                        y += vel;
                        break;
                    case "left":
                        x -= vel;
                        break;
                    case "right":
                        x += vel;
                        break;
                }
            }
        }
        for (int i = 0; i < Window.obstacles.length; i++){
            if ((this.x < Window.obstacles[i].posx + Window.obstacles[i].width) && (this.x + this.size > Window.obstacles[i].posx) &&(this.y < Window.obstacles[i].posy + Window.obstacles[i].height) && (this.y + this.size > Window.obstacles[i].posy)) this.movable = false;
        }

        if (!this.movable) {
            switch (this.dir){
                case "down":
                    y -= 10;
                    break;
                case "up":
                    y += 10;
                    break;
                case "right":
                    x -= 10;
                    break;
                case "left":
                    x += 10;
                    break;
            }
            this.movable = true;
            this.dir = "";
            this.nextdir = "";
        }

        if (this.x < -size) this.x = Main.GAME_WIDTH;
        if (this.x > Main.GAME_WIDTH) this.x = -size;
        if (this.y < -size) this.y = Main.GAME_HEIGHT;
        if (this.y > Main.GAME_HEIGHT) this.y = -size;

        for (int i = 0; i < Window.Ghosts.length; i++) {
            if ((((this.x + size) > Window.Ghosts[i].posx) && (this.x < (Window.Ghosts[i].posx + Window.Ghosts[i].size))) && ((this.y < (Window.Ghosts[i].posy + Window.Ghosts[i].size)) && ((this.y + this.size) > Window.Ghosts[i].posy))) {
                System.out.println("Game lost!");
                Main.gamestatus = 0;
            }
        }

    }

    void drawPlayer(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, size, size);
    }
}