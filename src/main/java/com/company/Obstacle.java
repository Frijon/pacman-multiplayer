package com.company;

import java.awt.*;

public class Obstacle {
    int posX, posY, width, height;

    public Obstacle(int xpos,int ypos, int widthx, int heighty){
        this.posX = xpos;
        this.posY = ypos;
        this.width = widthx;
        this.height = heighty;
    }

    void draw(Graphics g){
        g.setColor(Color.blue);
        g.fillRoundRect(this.posX, this.posY, this.width, this.height, 30, 30);
        if (this == Window.obstacles[55]){
            g.setColor(Color.gray);
            g.fillRoundRect(this.posX, this.posY, this.width, this.height, 30, 30);
        }
    }
}
