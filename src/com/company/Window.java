package com.company;

import java.awt.*;
import javax.swing.*;

public class Window extends JPanel {

    Image backgroundimg = Toolkit.getDefaultToolkit().createImage("D://github/Pacman multiplayer/src/com/company/index.png");
    Image scaledImage = backgroundimg.getScaledInstance(800, 600, 0);

    public Window() {
        setBackground(Color.cyan);
       /* ImageIcon icon = new ImageIcon("com/company/index.png");
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);*/
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaledImage, 0, 0, this);
        System.out.println("test");
    }
}