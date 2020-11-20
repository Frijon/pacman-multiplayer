package com.company;

import java.awt.*;
import java.awt.Graphics;

public class PacMan {
    int x = 100, y = 50, size = 50;
    String dir = "";
    String nextdir = "";

    public PacMan() {

    }

    void Movement() {

        if ((this.x >= (0 - size) && this.x <= Main.GAME_WIDTH) && (this.y >= (0 - size) && this.y <= Main.GAME_HEIGHT)) {
            /*if ((this.x >= Window.obstacles[0].posx + Window.obstacles[0].width)&&
                    (this.y >= Window.obstacles[0].posy)) {*/
                if (this.x % 50 == 0 && this.y % 50 == 0) this.dir = this.nextdir;
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
                //}
            }
        }

//        System.out.println("this.x = " + this.x);
//        System.out.println("this.y = " + this.y);

        if (this.x < 0 - size) this.x = Main.GAME_WIDTH;
        if (this.x > Main.GAME_WIDTH) this.x = 0 - size;
        if (this.y < 0 - size) this.y = Main.GAME_HEIGHT;
        if (this.y > Main.GAME_HEIGHT) this.y = 0 - size;

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