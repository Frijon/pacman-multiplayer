package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Ghost {
    int size = 50, vel = 5;
    int startposx, startposy;
    int posx = startposx, posy = startposy;
    String dir = "";
    String nextdir = "";
    String color;
    boolean movable = true;
    int counter = 0;

    static HashMap<String, Image> images = new HashMap<>();

    static {
        String[] colors = new String[]{"blue", "orange", "red", "green"};
        String[] directions = new String[]{"Up", "Down", "Right", "Left"};
        try {
            for (String color : colors) {
                for (String direction : directions) {
                    images.put(
                            color + direction,
                            ImageIO.read(
                                    Ghost.class.getResource("/" + color.charAt(0) + direction + ".png")
                            )
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Ghost(String color) {
        this.color = color;
        switch (color) {
            case "blue" -> {
                this.startposx = 550;
                this.startposy = 450;
            }
            case "red" -> {
                this.startposx = 550;
                this.startposy = 500;
            }
            case "orange" -> {
                this.startposx = 750;
                this.startposy = 450;
            }
            case "green" -> {
                this.startposx = 750;
                this.startposy = 500;
            }
        }
    }


    void movement(int c) {
        int randomGhost = 0;
        int randomInt = 0;

        if (Window.ghosts[Window.ghostnumber - 1] != this) {
            if (counter % 10 == 0) {
                if (counter % 3 == 0) {
                    randomGhost = ((int) (Math.random() * 4) + 1);
                    randomInt = ((int) (Math.random() * 4) + 1);
                }

                if (randomGhost == c + 1) {
                    switch (randomInt) {
                        case 1 -> this.nextdir = "up";
                        case 2 -> this.nextdir = "down";
                        case 3 -> this.nextdir = "right";
                        case 4 -> this.nextdir = "left";
                    }
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
            if ((this.posx < Window.obstacles[i].posX + Window.obstacles[i].width) && (this.posx + this.size > Window.obstacles[i].posX) && (this.posy < Window.obstacles[i].posY + Window.obstacles[i].height) && (this.posy + this.size > Window.obstacles[i].posY))
                this.movable = false;
            if ((this.posx + this.size <= Window.obstacles[55].posX + Window.obstacles[55].width) && (this.posx >= Window.obstacles[55].posX) && (this.posy <= Window.obstacles[55].posY + Window.obstacles[55].height) && (this.posy + this.size >= Window.obstacles[55].posY))
                this.movable = true;
        }

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
        String dir = this.dir;
        if (this.dir.isEmpty()) dir = "up";
            g.drawImage(images.get(color + Character.toUpperCase(dir.charAt(0)) + dir.substring(1)), posx, posy, size, size, null);
        g.setColor(Color.black);
        g2d.drawString(Arrays.asList("blue", "red", "orange", "green").indexOf(color) + 1 + "", ((this.posx + this.size / 2) - 3), (this.posy + this.size / 2) + 14);
    }

}
