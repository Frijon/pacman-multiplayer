package com.company;

import java.awt.*;

/**
 * The Obstacle class.
 */
public class Obstacle {
    /**
     * The Pos x.
     */
    int posX, /**
     * The Pos y.
     */
    posY, /**
     * The Width.
     */
    width, /**
     * The Height.
     */
    height;

    /**
     * Instantiates a new Obstacle.
     *
     * @param xpos    the xpos
     * @param ypos    the ypos
     * @param widthx  the widthx
     * @param heighty the heighty
     */
    public Obstacle(int xpos,int ypos, int widthx, int heighty){
        this.posX = xpos;
        this.posY = ypos;
        this.width = widthx;
        this.height = heighty;
    }

    /**
     * Draw.
     *
     * @param g the Graphics object.
     */
    void draw(Graphics g){
        g.setColor(Color.blue);
        g.fillRoundRect(this.posX, this.posY, this.width, this.height, 30, 30);
        if (this == Window.obstacles[55]){
            g.setColor(Color.gray);
            g.fillRoundRect(this.posX, this.posY, this.width, this.height, 30, 30);
        }
    }
}
