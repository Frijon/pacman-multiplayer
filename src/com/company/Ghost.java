package com.company;

import java.awt.*;

public class Ghost {
    int size = 50, vel = 5;
    int startposx, startposy;
    int posx = startposx, posy = startposy;
    String dir = "";
    String nextdir = "";
    String color;
    boolean movable = true;


    public Ghost(String color) {
        switch (color) {
            case "blue":
                this.color = "blue";
                this.startposx = 550;
                this.startposy = 450;
                break;
            case "red":
                this.color = "red";
                this.startposx = 550;
                this.startposy = 500;
                break;
            case "pink":
                this.color = "pink";
                this.startposx = 750;
                this.startposy = 450;
                break;
            case "green":
                this.color = "green";
                this.startposx = 750;
                this.startposy = 500;
                break;
        }
    }


    void Movement(){

        if (this.movable) {
            if ((this.posx >= (-this.size) && this.posx <= Main.GAME_WIDTH) && (this.posy >= (-this.size) && this.posy <= Main.GAME_HEIGHT)) {
                if (this.posx % 50 == 0 && this.posy % 50 == 0) this.dir = this.nextdir;
                switch (this.dir) {
                    case "up":
                        this.posy -= vel;
                        break;
                    case "down":
                        this.posy += vel;
                        break;
                    case "left":
                        this.posx -= vel;
                        break;
                    case "right":
                        this.posx += vel;
                        break;
                }
            }
        }

        for (int i = 0; i < Window.obstacles.length; i++){
            if ((this.posx < Window.obstacles[i].posx + Window.obstacles[i].width) && (this.posx + this.size > Window.obstacles[i].posx) && (this.posy < Window.obstacles[i].posy + Window.obstacles[i].height) && (this.posy + this.size > Window.obstacles[i].posy)) this.movable = false;
            if ((this.posx + this.size <= Window.obstacles[55].posx + Window.obstacles[55].width) && (this.posx >= Window.obstacles[55].posx) && (this.posy <= Window.obstacles[55].posy + Window.obstacles[55].height) && (this.posy + this.size >= Window.obstacles[55].posy)) this.movable = true;
        }

        for (int i = 0; i < Window.Ghosts.length; i++){
            if (Window.Ghosts[i] == this) continue;
            if ((this.posx < Window.Ghosts[i].posx + Window.Ghosts[i].size) && (this.posx + this.size > Window.Ghosts[i].posx) && (this.posy < Window.Ghosts[i].posy + Window.Ghosts[i].size) && (this.posy + this.size > Window.Ghosts[i].posy)) this.movable = false;

        }

        if (this.posx < 0) this.movable = false;
        if (this.posx + this.size > Main.GAME_WIDTH) this.movable = false;
        if (this.posy < 0) this.movable = false;
        if (this.posy + this.size> Main.GAME_HEIGHT) this.movable = false;

        if (!this.movable) {
            switch (this.dir){
                case "down":
                    this.posy -= vel;
                    break;
                case "up":
                    this.posy += vel;
                    break;
                case "right":
                    this.posx -= vel;
                    break;
                case "left":
                    this.posx += vel;
                    break;
            }
            this.movable = true;
            this.dir = "";
            this.nextdir = "";
        }
    }

    void draw (Graphics g, String color){
        Graphics2D g2d = (Graphics2D)g;
        switch (color) {
            case "blue":
                g.setColor(Color.cyan);
                g.fillRect(posx, posy, size, size);
                g.setColor(Color.black);
                g2d.drawString("1", ((this.posx + this.size / 2) -3),  (this.posy + this.size / 2) +3);
                break;
            case "red":
                g.setColor(Color.red);
                g.fillRect(posx, posy, size, size);
                g.setColor(Color.black);
                g2d.drawString("2", ((this.posx + this.size / 2) -3),  (this.posy + this.size / 2) +3);
                break;
            case "pink":
                g.setColor(Color.pink);
                g.fillRect(posx, posy, size, size);
                g.setColor(Color.black);
                g2d.drawString("3", ((this.posx + this.size / 2) -3),  (this.posy + this.size / 2) +3);
                break;
            case "green":
                g.setColor(Color.green);
                g.fillRect(posx, posy, size, size);
                g.setColor(Color.black);
                g2d.drawString("4", ((this.posx + this.size / 2) -3),  (this.posy + this.size / 2) +3);
                break;
        }


    }

}
