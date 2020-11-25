package com.company;

import java.awt.*;

public class Obstacle {
    int posx, posy, width, height;

    public Obstacle(int xpos,int ypos, int widthx, int heighty){
        this.posx = xpos;
        this.posy = ypos;
        this.width = widthx;
        this.height = heighty;

    }

    void draw(Graphics g){
        g.setColor(Color.blue);
        g.fillRoundRect(this.posx, this.posy, this.width, this.height, 30, 30);
        if (this == Window.obstacles[55]){
            g.setColor(Color.gray);
            g.fillRoundRect(this.posx, this.posy, this.width, this.height, 30, 30);
        }
    }
}
