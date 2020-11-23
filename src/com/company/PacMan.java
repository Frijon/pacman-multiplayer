package com.company;

import java.awt.*;
import java.awt.Graphics;

public class PacMan {
    int startx = 100, starty = 100;
    int x = startx, y = starty, size = 100;
    String dir = "";
    String nextdir = "";
    boolean movable = true;

    public PacMan() {


    }

    void Movement() {
        /*for (int i = 0; i < Window.obstacles.length; i++) {
            if ((this.x < Window.obstacles[i].posx + Window.obstacles[i].width && this.x + this.size > Window.obstacles[i].posx)) {
                System.out.println("not movable!");
                this.movable = false;
            } else {
                System.out.println("movable!");
                this.movable = true;
            }
        }*/

        if (this.movable) {
            if ((this.x >= (-size) && this.x <= Main.WINDOW_WIDTH) && (this.y >= (-size) && this.y <= Main.WINODW_HEIGHT)) {
                if (this.x % 100 == 0 && this.y % 100 == 0) this.dir = this.nextdir;
                switch (this.dir) {
                    case "up":
                        y -= 10;
                        break;
                    case "down":
                        y += 10;
                        break;
                    case "left":
                        x -= 10;
                        break;
                    case "right":
                        x += 10;
                        break;
                }
            }
        }
        if ((this.x < Window.obstacles[0].posx + Window.obstacles[0].width) && (this.x + this.size > Window.obstacles[0].posx)) this.movable = false;
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

        if (this.x < -size) this.x = Main.WINDOW_WIDTH;
        if (this.x > Main.WINDOW_WIDTH) this.x = -size;
        if (this.y < -size) this.y = Main.WINODW_HEIGHT;
        if (this.y > Main.WINODW_HEIGHT) this.y = -size;

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