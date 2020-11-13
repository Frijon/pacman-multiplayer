package com.company;

import sun.awt.WindowIDProvider;

import java.awt.*;
import java.awt.Graphics;

public class PacMan {
    int x = 50, y = 50, size = 50;
    String dir = "";

    public PacMan(){

    }

    void Movement (){

       /* if (Window.Keys[0]) y -= 10;
        if (Window.Keys[1]) x -= 10;
        if (Window.Keys[2]) x += 10;
        if (Window.Keys[3]) y += 10;*/

        if ((this.x >= (0 - size) && this.x <= Main.GAME_WIDTH) && (this.y >= (0 - size) && this.y <= Main.GAME_HEIGHT)) {
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

//        System.out.println("this.x = " + this.x);
//        System.out.println("this.y = " + this.y);

        if (this.x < 0 - size) this.x = Main.GAME_WIDTH;
        if (this.x > Main.GAME_WIDTH) this.x = 0 - size;
        if (this.y < 0 - size) this.y = Main.GAME_HEIGHT;
        if (this.y > Main.GAME_HEIGHT) this.y = 0 - size;

        for (int i = 0; i < Window.Ghosts.length; i++){
            if ((((this.x + size) > Window.Ghosts[i].posx) && (this.x < (Window.Ghosts[i].posx + Window.Ghosts[i].size))) && ((this.y < (Window.Ghosts[i].posy + Window.Ghosts[i].posy)) && ((this.y + this.size) > Window.Ghosts[i].posy))){
                System.out.println("Game lost!");
            }
        }

    }

    void drawPlayer (Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(x, y, size, size);
    }
}