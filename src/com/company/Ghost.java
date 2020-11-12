package com.company;

import java.awt.*;

public class Ghost {
    int size = 20;
    int posx = 100, posy = 100;
    String dir = "";
    String color;


    public Ghost(String color) {
        switch (color) {
            case "blue" -> this.color = "blue";
            case "red" -> this.color = "red";
            case "pink" -> this.color = "pink";
            case "yellow" -> this.color = "yellow";
        }
    }


    void Movement(){

        if ((this.posx >= 0 && this.posx <= (800 - size)) && (this.posy >= 0 && this.posy <= (600 - size))) {
            switch (this.dir) {
                case "up" -> this.posy -= 10;
                case "down" -> this.posy += 10;
                case "left" -> this.posx -= 10;
                case "right" -> this.posx += 10;
            }
        }

//        System.out.println("this.posx = " + this.posx);
//        System.out.println("this.posy = " + this.posy);

        if (this.posx < 0) this.posx = 0;
        if (this.posx > (800 - size)) this.posx = 800 - size;
        if (this.posy < 0) this.posy = 0;
        if (this.posy > (600 - size)) this.posy = 600 - size ;

    }

    void draw (Graphics g, String color){
        switch (color) {
            case "blue" -> g.setColor(Color.cyan);
            case "red" -> g.setColor(Color.red);
            case "pink" -> g.setColor(Color.pink);
            case "yellow" -> g.setColor(Color.yellow);
        }

        g.fillOval(posx, posy, size, size);
    }

}
