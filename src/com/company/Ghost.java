package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Ghost {
    int size = 50, vel = 5;
    int startposx, startposy;
    int posx = startposx, posy = startposy;
    String dir = "";
    String nextdir = "";
    String color;
    boolean movable = true;
    int counter = 0;


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


    void movement(int c) {
        int randomGhost = 0;
        int randomInt = 0;

        if (Window.Ghosts[Window.ghostnumber - 1] != this) {
            if (counter % 25 == 0) {
                if (counter % 3 == 0) {
                    randomGhost = ((int) (Math.random() * 4) + 1);
                    randomInt = ((int) (Math.random() * 4) + 1);
                    System.out.println("set random ghost to " + randomGhost + " and random int to " + randomInt);
                }

                if (randomGhost == c + 1) {
                    switch (randomInt) {
                        case 1 -> this.nextdir = "up";
                        case 2 -> this.nextdir = "down";
                        case 3 -> this.nextdir = "right";
                        case 4 -> this.nextdir = "left";
                    }
                    System.out.println("movement updated");
                }
            }

            counter++;
            counter %= 200;
        }


        if (this.movable) {
            if ((this.posx >= (-this.size) && this.posx <= Main.GAME_WIDTH) && (this.posy >= (-this.size) && this.posy <= Main.GAME_HEIGHT)) {
                if (this.posx % 50 == 0 && this.posy % 50 == 0) this.dir = this.nextdir;
                switch (this.dir) {
                    case "up" -> this.posy -= vel;
                    case "down" -> this.posy += vel;
                    case "left" -> this.posx -= vel;
                    case "right" -> this.posx += vel;
                }
            }
        }

        for (int i = 0; i < Window.obstacles.length; i++) {
            if ((this.posx < Window.obstacles[i].posx + Window.obstacles[i].width) && (this.posx + this.size > Window.obstacles[i].posx) && (this.posy < Window.obstacles[i].posy + Window.obstacles[i].height) && (this.posy + this.size > Window.obstacles[i].posy))
                this.movable = false;
            if ((this.posx + this.size <= Window.obstacles[55].posx + Window.obstacles[55].width) && (this.posx >= Window.obstacles[55].posx) && (this.posy <= Window.obstacles[55].posy + Window.obstacles[55].height) && (this.posy + this.size >= Window.obstacles[55].posy))
                this.movable = true;
        }

       /* for (int i = 0; i < Window.Ghosts.length; i++){
            if (Window.Ghosts[i] == this) continue;
            if ((this.posx < Window.Ghosts[i].posx + Window.Ghosts[i].size) && (this.posx + this.size > Window.Ghosts[i].posx) && (this.posy < Window.Ghosts[i].posy + Window.Ghosts[i].size) && (this.posy + this.size > Window.Ghosts[i].posy)) this.movable = false;
        }*/

        if (this.posx < 0) this.movable = false;
        if (this.posx + this.size > Main.GAME_WIDTH) this.movable = false;
        if (this.posy < 0) this.movable = false;
        if (this.posy + this.size > Main.GAME_HEIGHT) this.movable = false;

        if (!this.movable) {
            switch (this.dir) {
                case "down" -> this.posy -= vel;
                case "up" -> this.posy += vel;
                case "right" -> this.posx -= vel;
                case "left" -> this.posx += vel;
            }
            this.movable = true;
            this.dir = "";
            this.nextdir = "";
        }
    }

    void draw(Graphics g, String color) {
        Graphics2D g2d = (Graphics2D) g;
        switch (color) {
            case "blue" -> {
                g.setColor(Color.cyan);
                g.fillRect(posx, posy, size, size);
                g.setColor(Color.black);
                g2d.drawString("1", ((this.posx + this.size / 2) - 3), (this.posy + this.size / 2) + 3);
            }
            case "red" -> {
                g.setColor(Color.red);
                g.fillRect(posx, posy, size, size);
                g.setColor(Color.black);
                g2d.drawString("2", ((this.posx + this.size / 2) - 3), (this.posy + this.size / 2) + 3);
            }
            case "pink" -> {
                g.setColor(Color.pink);
                g.fillRect(posx, posy, size, size);
                g.setColor(Color.black);
                g2d.drawString("3", ((this.posx + this.size / 2) - 3), (this.posy + this.size / 2) + 3);
            }
            case "green" -> {
                g.setColor(Color.green);
                g.fillRect(posx, posy, size, size);
                g.setColor(Color.black);
                g2d.drawString("4", ((this.posx + this.size / 2) - 3), (this.posy + this.size / 2) + 3);
            }
        }


    }

}
