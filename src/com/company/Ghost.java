package com.company;

import java.awt.*;

public class Ghost {
    int size = 100;
    int startposx = 500, startposy = 500;
    int posx = startposx, posy = startposy;
    String dir = "";
    String nextdir = "";
    String color;


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

        if ((this.posx >= 0 && this.posx <= (Main.WINDOW_WIDTH - size)) && (this.posy >= 0 && this.posy <= (Main.WINODW_HEIGHT - size))) {
            if (this.posx % 100 == 0 && this.posy % 100 == 0) this.dir = this.nextdir;
            switch (this.dir) {
                case "up": this.posy -= 10;
                    break;
                case "down": this.posy += 10;
                    break;
                case "left": this.posx -= 10;
                    break;
                case "right": this.posx += 10;
                    break;
            }
        }

        if (this.posx < 0) this.posx = 0;
        if (this.posx > (Main.WINDOW_WIDTH - size)) this.posx = Main.WINDOW_WIDTH - size;
        if (this.posy < 0) this.posy = 0;
        if (this.posy > (Main.WINODW_HEIGHT - size)) this.posy = Main.WINODW_HEIGHT - size ;

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
