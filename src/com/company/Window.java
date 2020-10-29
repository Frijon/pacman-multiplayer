package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JPanel implements KeyListener {

    Player Player0 = new Player();
    static boolean[] Keys = new boolean[4];

    Image backgroundimg = Toolkit.getDefaultToolkit().createImage("D://github/Pacman multiplayer/src/com/company/index.png");
    Image scaledImage = backgroundimg.getScaledInstance(800, 600, 0);

    public Window() {
        this.addKeyListener(this);
        setFocusable(true);
        //setBackground(Color.cyan);
       /* ImageIcon icon = new ImageIcon("com/company/index.png");
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);*/
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaledImage, 0, 0, this);
        Player0.Movement();
        SleepRefresh();
        Player0.drawPlayer(g);
    }

    void SleepRefresh(){
        try{
            Thread.sleep(1000/30);
        }catch (Exception e) {

        }
        repaint();
    }

    public void keyPressed(KeyEvent arg0){
        if (arg0.getKeyCode() == KeyEvent.VK_UP) {
            Keys[0] = true;
        }
        if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
            Keys[1] = true;
        }
        if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
            Keys[2] = true;
        }
        if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
            Keys[3] = true;
        }
    }

    public void keyReleased(KeyEvent arg0){
        if (arg0.getKeyCode() == KeyEvent.VK_UP) {
            Keys[0] = false;
        }
        if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
            Keys[1] = false;
        }
        if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
            Keys[2] = false;
        }
        if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
            Keys[3] = false;
        }
    }

    public void keyTyped(KeyEvent arg0){

    }
}