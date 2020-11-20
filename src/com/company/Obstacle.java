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
        g.fillRect(this.posx, this.posy, this.width, this.height);
    }
}
