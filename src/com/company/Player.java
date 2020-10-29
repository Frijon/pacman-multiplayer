package com.company;

import java.awt.*;
import java.awt.Graphics;

public class Player {
    int x = 50, y = 50, size = 25;
    public Player(){

    }
    void Movement (){
        if (Window.Keys[0]) {
            y -= 5;
        }
        if (Window.Keys[1]) {
            x -= 5;
        }
        if (Window.Keys[2]) {
            x += 5;
        }
        if (Window.Keys[3]) {
            y += 5;
        }
    }
    void drawPlayer (Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(x, y, size, size);
    }
}