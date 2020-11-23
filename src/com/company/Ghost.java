package com.company;

import java.awt.*;

public class Ghost {
    int size = 50;
    int startposx = 500, startposy = 500;
    int posx = startposx, posy = startposy;
    String dir = "";
    String nextdir = "";
    String color;
    boolean movable = true;


    public Ghost(String color) {
        switch (color) {
            case "blue":
                this.color = "blue";
                break;
            case "red":
                this.color = "red";
                break;
            case "pink":
                this.color = "pink";
                break;
            case "green":
                this.color = "green";
                break;
        }
    }


    void Movement(){

        if (this.movable) {
            if ((this.posx >= (-this.size) && this.posx <= Main.GAME_WIDTH) && (this.posy >= (-this.size) && this.posy <= Main.GAME_HEIGHT)) {
                if (this.posx % 50 == 0 && this.posy % 50 == 0) this.dir = this.nextdir;
                switch (this.dir) {
                    case "up":
                        this.posy -= 10;
                        break;
                    case "down":
                        this.posy += 10;
                        break;
                    case "left":
                        this.posx -= 10;
                        break;
                    case "right":
                        this.posx += 10;
                        break;
                }
            }
        }

        for (int i = 0; i < Window.obstacles.length; i++){
            if ((this.posx < Window.obstacles[i].posx + Window.obstacles[i].width) && (this.posx + this.size > Window.obstacles[i].posx) &&(this.posy < Window.obstacles[i].posy + Window.obstacles[i].height) && (this.posy + this.size > Window.obstacles[i].posy)) this.movable = false;
        }

        if (this.posx < 0) this.movable = false;
        if (this.posx + this.size > Main.GAME_WIDTH) this.movable = false;
        if (this.posy < 0) this.movable = false;
        if (this.posy + this.size> Main.GAME_HEIGHT) this.movable = false;

        if (!this.movable) {
            switch (this.dir){
                case "down":
                    this.posy -= 10;
                    break;
                case "up":
                    this.posy += 10;
                    break;
                case "right":
                    this.posx -= 10;
                    break;
                case "left":
                    this.posx += 10;
                    break;
            }
            this.movable = true;
            this.dir = "";
            this.nextdir = "";
        }
    }

    void draw (Graphics g, String color){
        switch (color) {
            case "blue":
                g.setColor(Color.cyan);
                break;
            case "red":
                g.setColor(Color.red);
                break;
            case "pink":
                g.setColor(Color.pink);
                break;
            case "green":
                g.setColor(Color.green);
                break;
        }

        g.fillRect(posx, posy, size, size);
    }

}
