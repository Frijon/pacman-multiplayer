package com.company;

import javax.swing.*;
import java.awt.*;

public class Bgpanel extends JPanel {

    public Bgpanel(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.pink);
        g.fillRect(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
    }

}
