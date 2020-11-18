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

        if ((this.x >= (- size) && this.x <= Main.GAME_WIDTH) && (this.y >= (- size) && this.y <= Main.GAME_HEIGHT)) {
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


        if (this.x < -size) this.x = Main.GAME_WIDTH;
        if (this.x > Main.GAME_WIDTH) this.x = - size;
        if (this.y < - size) this.y = Main.GAME_HEIGHT;
        if (this.y > Main.GAME_HEIGHT) this.y = - size;

        for (int i = 0; i < Window.Ghosts.length; i++){
            if ((((this.x + size) > Window.Ghosts[i].posx) && (this.x < (Window.Ghosts[i].posx + Window.Ghosts[i].size))) && ((this.y < (Window.Ghosts[i].posy + Window.Ghosts[i].size)) && ((this.y + this.size) > Window.Ghosts[i].posy))){
                System.out.println("Game lost!");
                Main.run = false;
            }

            /*Color c = new Color(Window.scaledImage.getRGB(this.x, this.y));
            if (c.getRed() < 30 && c.getGreen() > 225 && c.getBlue() > 225) {

            }*/
        }

    }

    void drawPlayer (Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(x, y, size, size);
    }
}