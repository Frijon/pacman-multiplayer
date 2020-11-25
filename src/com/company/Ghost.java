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

    Image blueUp = Toolkit.getDefaultToolkit().createImage("src/com/company/bUp.png");
    Image blueUpscaledImage = blueUp.getScaledInstance(50,50, 0);
    Image blueRight = Toolkit.getDefaultToolkit().createImage("src/com/company/bRight.png");
    Image blueRightscaledImage = blueRight.getScaledInstance(50,50, 0);
    Image blueDown = Toolkit.getDefaultToolkit().createImage("src/com/company/bDown.png");
    Image blueDownscaledImage = blueDown.getScaledInstance(50,50, 0);
    Image blueLeft = Toolkit.getDefaultToolkit().createImage("src/com/company/bLeft.png");
    Image blueLeftscaledImage = blueLeft.getScaledInstance(50,50, 0);

    Image greenUp = Toolkit.getDefaultToolkit().createImage("src/com/company/gUp.png");
    Image greenUpscaledImage = greenUp.getScaledInstance(50,50, 0);
    Image greenRight = Toolkit.getDefaultToolkit().createImage("src/com/company/gRight.png");
    Image greenRightscaledImage = greenRight.getScaledInstance(50,50, 0);
    Image greenDown = Toolkit.getDefaultToolkit().createImage("src/com/company/gDown.png");
    Image greenDownscaledImage = greenDown.getScaledInstance(50,50, 0);
    Image greenLeft = Toolkit.getDefaultToolkit().createImage("src/com/company/gLeft.png");
    Image greenLeftscaledImage = greenLeft.getScaledInstance(50,50, 0);

    Image redUp = Toolkit.getDefaultToolkit().createImage("src/com/company/rUp.png");
    Image redUpscaledImage = redUp.getScaledInstance(50,50, 0);
    Image redRight = Toolkit.getDefaultToolkit().createImage("src/com/company/rRight.png");
    Image redRightscaledImage = redRight.getScaledInstance(50,50, 0);
    Image redDown = Toolkit.getDefaultToolkit().createImage("src/com/company/rDown.png");
    Image redDownscaledImage = redDown.getScaledInstance(50,50, 0);
    Image redLeft = Toolkit.getDefaultToolkit().createImage("src/com/company/rLeft.png");
    Image redLeftscaledImage = redLeft.getScaledInstance(50,50, 0);

    Image orangeUp = Toolkit.getDefaultToolkit().createImage("src/com/company/oUp.png");
    Image orangeUpscaledImage = orangeUp.getScaledInstance(50,50, 0);
    Image orangeRight = Toolkit.getDefaultToolkit().createImage("src/com/company/oRight.png");
    Image orangeRightscaledImage = orangeRight.getScaledInstance(50,50, 0);
    Image orangeDown = Toolkit.getDefaultToolkit().createImage("src/com/company/oDown.png");
    Image orangeDownscaledImage = orangeDown.getScaledInstance(50,50, 0);
    Image orangeLeft = Toolkit.getDefaultToolkit().createImage("src/com/company/oLeft.png");
    Image orangeLeftscaledImage = orangeLeft.getScaledInstance(50,50, 0);





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
                switch (this.dir){
                    case "up":
                        g.drawImage(blueUpscaledImage, posx, posy, null );
                        break;
                    case "right":
                        g.drawImage(blueRightscaledImage, posx, posy, null );
                        break;
                    case "down":
                        g.drawImage(blueDownscaledImage, posx, posy, null );
                        break;
                    case "left":
                        g.drawImage(blueLeftscaledImage, posx, posy, null );
                        break;
                    default:
                        g.drawImage(blueUpscaledImage, posx, posy, null );
                }
               g.setColor(Color.black);
                g2d.drawString("1", ((this.posx + this.size / 2) -3),  (this.posy + this.size / 2) +14);
                break;
            case "red":
              //  g.setColor(Color.red);
              //  g.fillRect(posx, posy, size, size);
                switch (this.dir){
                    case "up":
                        g.drawImage(redUpscaledImage, posx, posy, null );
                        break;
                    case "right":
                        g.drawImage(redRightscaledImage, posx, posy, null );
                        break;
                    case "down":
                        g.drawImage(redDownscaledImage, posx, posy, null );
                        break;
                    case "left":
                        g.drawImage(redLeftscaledImage, posx, posy, null );
                        break;
                    default:
                        g.drawImage(redUpscaledImage, posx, posy, null );
                }
                g.setColor(Color.black);
                g2d.drawString("2", ((this.posx + this.size / 2) -3),  (this.posy + this.size / 2) +14);
                break;
            case "pink":
                switch (this.dir){
                    case "up":
                        g.drawImage(orangeUpscaledImage, posx, posy, null );
                        break;
                    case "right":
                        g.drawImage(orangeRightscaledImage, posx, posy, null );
                        break;
                    case "down":
                        g.drawImage(orangeDownscaledImage, posx, posy, null );
                        break;
                    case "left":
                        g.drawImage(orangeLeftscaledImage, posx, posy, null );
                        break;
                    default:
                        g.drawImage(orangeUpscaledImage, posx, posy, null );
                }
                g.setColor(Color.black);
                g2d.drawString("3", ((this.posx + this.size / 2) -3),  (this.posy + this.size / 2) +14);
                break;
            case "green":
                switch (this.dir){
                    case "up":
                        g.drawImage(greenUpscaledImage, posx, posy, null );
                        break;
                    case "right":
                        g.drawImage(greenRightscaledImage, posx, posy, null );
                        break;
                    case "down":
                        g.drawImage(greenDownscaledImage, posx, posy, null );
                        break;
                    case "left":
                        g.drawImage(greenLeftscaledImage, posx, posy, null );
                        break;
                    default:
                        g.drawImage(greenUpscaledImage, posx, posy, null );
                }
                g.setColor(Color.black);
                g2d.drawString("4", ((this.posx + this.size / 2) -3),  (this.posy + this.size / 2) +14);
                break;
        }

    }

}
