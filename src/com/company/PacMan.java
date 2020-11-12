package com.company;

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

        if ((this.x >= (0 - size) && this.x <= 800) && (this.y >= (0 - size) && this.y <= 600)) {
            switch (this.dir) {
                case "up" -> y -= 10;
                case "down" -> y += 10;
                case "left" -> x -= 10;
                case "right" -> x += 10;
            }
        }

//        System.out.println("this.x = " + this.x);
//        System.out.println("this.y = " + this.y);

        if (this.x < 0 - size) this.x = 800;
        if (this.x > 800) this.x = 0 - size;
        if (this.y < 0 - size) this.y = 600;
        if (this.y > 600) this.y = 0 - size;

    }

    void drawPlayer (Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(x, y, size, size);
    }
}