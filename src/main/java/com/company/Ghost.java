package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * The class Ghost, which creates 4 ghosts which are movable by the second player.
 */
public class Ghost {
    /**
     * The size of the Ghosts.
     */
    int size = 50, /**
     * The movement velocity of the ghosts.
     */
    vel = 5;
    /**
     * The starting x position of the ghosts.
     */
    int startPosX, /**
     * The starting y position of the ghosts.
     */
    startPosY;
    /**
     * The x position.
     */
    int posx = startPosX, /**
     * The y position of the ghosts.
     */
    posy = startPosY;
    /**
     * The movement direction of the gosts.
     */
    String dir = "";
    /**
     * The next direction which is going to be set to the current direction as soon as the x or y pos % 50 is 0.
     */
    String nextdir = "";
    /**
     * The color of the ghosts.
     */
    String color;
    /**
     * The boolean which states if the ghosts are movable or not.
     */
    boolean movable = true;
    /**
     * A counter variable to set random movement variables, because otherwise the random moves would be generated every frame.
     */
    int counter = 0;

    /**
     * Loading the images.
     */
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


    /**
     * Instantiates a new ghost and sets the starting position depending on the color.
     *
     * @param color the color of the ghost.
     */
    public Ghost(String color) {
        this.color = color;
        switch (color) {
            case "blue" -> {
                this.startPosX = 550;
                this.startPosY = 450;
            }
            case "red" -> {
                this.startPosX = 550;
                this.startPosY = 500;
            }
            case "orange" -> {
                this.startPosX = 750;
                this.startPosY = 450;
            }
            case "green" -> {
                this.startPosX = 750;
                this.startPosY = 500;
            }
        }
    }

    /**
     * Movement method for the by the user selected ghost. The other ghosts are moved randomly.
     * The method checks for borders and obstacles, ignoring the grey obstacle.
     *
     * @param c the counting variable of the for loop
     */
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

    /**
     * Drawing the ghost, selecting the color and the appropriate position.
     *
     * @param g     the Graphics object
     * @param color the color
     */
    void draw(Graphics g, String color) {
        Graphics2D g2d = (Graphics2D) g;
        String dir = this.dir;
        if (this.dir.isEmpty()) dir = "up";
            g.drawImage(images.get(color + Character.toUpperCase(dir.charAt(0)) + dir.substring(1)), posx, posy, size, size, null);
        g.setColor(Color.black);
        g2d.drawString(Arrays.asList("blue", "red", "orange", "green").indexOf(color) + 1 + "", ((this.posx + this.size / 2) - 3), (this.posy + this.size / 2) + 14);
    }
}
