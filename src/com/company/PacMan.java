package com.company;

import java.awt.*;

public class PacMan {
    int startx = 650, starty = 150, vel = 5;
    int x = startx, y = starty, size = 50;
    String dir = "";
    String nextdir = "";
    boolean movable = true;
    int score;
    int frame = 1;
    int animationCounter = 0;

    Image Up1 = Toolkit.getDefaultToolkit().createImage("src/com/company/Up1.png");
    Image Up1scaledImage = Up1.getScaledInstance(50,50, 0);
    Image Up2 = Toolkit.getDefaultToolkit().createImage("src/com/company/Up2.png");
    Image Up2scaledImage = Up2.getScaledInstance(50,50, 0);
    Image Up3 = Toolkit.getDefaultToolkit().createImage("src/com/company/3.png");
    Image Up3scaledImage = Up3.getScaledInstance(50,50, 0);

    Image Right1 = Toolkit.getDefaultToolkit().createImage("src/com/company/Right1.png");
    Image Right1scaledImage = Right1.getScaledInstance(50,50, 0);
    Image Right2 = Toolkit.getDefaultToolkit().createImage("src/com/company/Right2.png");
    Image Right2scaledImage = Right2.getScaledInstance(50,50, 0);
    Image Right3 = Toolkit.getDefaultToolkit().createImage("src/com/company/3.png");
    Image Right3scaledImage = Right3.getScaledInstance(50,50, 0);

    Image Down1 = Toolkit.getDefaultToolkit().createImage("src/com/company/Down1.png");
    Image Down1scaledImage = Down1.getScaledInstance(50,50, 0);
    Image Down2 = Toolkit.getDefaultToolkit().createImage("src/com/company/Down2.png");
    Image Down2scaledImage = Down2.getScaledInstance(50,50, 0);
    Image Down3 = Toolkit.getDefaultToolkit().createImage("src/com/company/3.png");
    Image Down3scaledImage = Down3.getScaledInstance(50,50, 0);

    Image Left1 = Toolkit.getDefaultToolkit().createImage("src/com/company/Left1.png");
    Image Left1scaledImage = Left1.getScaledInstance(50,50, 0);
    Image Left2 = Toolkit.getDefaultToolkit().createImage("src/com/company/Left2.png");
    Image Left2scaledImage = Left2.getScaledInstance(50,50, 0);
    Image Left3 = Toolkit.getDefaultToolkit().createImage("src/com/company/3.png");
    Image Left3scaledImage = Left3.getScaledInstance(50,50, 0);

    public PacMan() {


    }

    void Movement() {

        if (this.movable) {
            if ((this.x >= (-size) && this.x <= Main.GAME_WIDTH) && (this.y >= (-size) && this.y <= Main.GAME_HEIGHT)) {
                if (this.x % 50 == 0 && this.y % 50 == 0) this.dir = this.nextdir;
                switch (this.dir) {
                    case "up":
                        y -= vel;

                        break;
                    case "down":
                        y += vel;
                        break;
                    case "left":
                        x -= vel;
                        break;
                    case "right":
                        x += vel;
                        break;
                }
            }
        }
        for (int i = 0; i < Window.obstacles.length; i++){
            if ((this.x < Window.obstacles[i].posx + Window.obstacles[i].width) && (this.x + this.size > Window.obstacles[i].posx) &&(this.y < Window.obstacles[i].posy + Window.obstacles[i].height) && (this.y + this.size > Window.obstacles[i].posy)) this.movable = false;
        }

        if (!this.movable) {
            switch (this.dir){
                case "down":
                    y -= vel;

                    break;
                case "up":
                    y += vel;
                    break;
                case "right":
                    x -= vel;
                    break;
                case "left":
                    x += vel;
                    break;
            }
            this.movable = true;
            this.dir = "";
            this.nextdir = "";
        }

        if (this.x < -size) this.x = Main.GAME_WIDTH;
        if (this.x > Main.GAME_WIDTH) this.x = -size;
        if (this.y < -size) this.y = Main.GAME_HEIGHT;
        if (this.y > Main.GAME_HEIGHT) this.y = -size;

        for (int i = 0; i < Window.Ghosts.length; i++) {
            if ((((this.x + size) > Window.Ghosts[i].posx) && (this.x < (Window.Ghosts[i].posx + Window.Ghosts[i].size))) && ((this.y < (Window.Ghosts[i].posy + Window.Ghosts[i].size)) && ((this.y + this.size) > Window.Ghosts[i].posy))) {
                System.out.println("Game lost!");
                Main.gamestatus = 0;
            }
        }

    }

    void drawPlayer(Graphics g) {
       // g.setColor(Color.yellow);
       // g.fillOval(x, y, size, size);

    switch (this.dir) {
        case "up":

                if (frame == 1) {
                    g.drawImage(Up1scaledImage, x, y, null);
                } else if (frame == 2) {
                    g.drawImage(Up2scaledImage, x, y, null);
                } else {
                    g.drawImage(Up3scaledImage, x, y, null);
                    frame = 1;
                    return;
                }
                frame++;

            break;

        case "right":
            if (frame == 1) {
                g.drawImage(Right1scaledImage, x, y, null);
            } else if (frame == 2) {
                g.drawImage(Right2scaledImage, x, y, null);
            } else {
                g.drawImage(Right3scaledImage, x, y, null);
                frame = 1;
                return;
            }
            frame++;
            break;

        case "down":
            if (frame == 1) {
                g.drawImage(Down1scaledImage, x, y, null);
            } else if (frame == 2) {
                g.drawImage(Down2scaledImage, x, y, null);
            } else {
                g.drawImage(Down3scaledImage, x, y, null);
                frame = 1;
                return;
            }
            frame++;
            break;

        case "left":
            if (frame == 1) {
                g.drawImage(Left1scaledImage, x, y, null);
            } else if (frame == 2) {
                g.drawImage(Left2scaledImage, x, y, null);
            } else {
                g.drawImage(Left3scaledImage, x, y, null);
                frame = 1;
                return;
            }
            frame++;
            break;

        default:
            g.drawImage(Up3scaledImage, x, y, null);
    }

}



    void drawScore(Graphics g) {
        g.setColor(Color.white);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawString("score: " + this.score, 650, 500);
    }


}