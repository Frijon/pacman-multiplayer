package com.company;

import java.awt.*;

public class Ghost {
    int size = 20;
    int posx = 100, posy = 100;
    String dir = "";
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

        if ((this.posx >= 0 && this.posx <= (Main.GAME_WIDTH - size)) && (this.posy >= 0 && this.posy <= (Main.GAME_HEIGHT - size))) {
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

//        System.out.println("this.posx = " + this.posx);
//        System.out.println("this.posy = " + this.posy);

        if (this.posx < 0) this.posx = 0;
        if (this.posx > (Main.GAME_WIDTH - size)) this.posx = Main.GAME_WIDTH - size;
        if (this.posy < 0) this.posy = 0;
        if (this.posy > (Main.GAME_HEIGHT - size)) this.posy = Main.GAME_HEIGHT - size ;

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

        g.fillOval(posx, posy, size, size);
    }

}
