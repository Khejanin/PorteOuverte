/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author nogal156
 */
public class Brick extends Block{

    public Brick(int x, int y) {
        super(x, y);
        color = Color.GRAY;
        isWalkable = false;
    }
    
    @Override
    public void draw(Graphics g,int size){
        g.setColor(color);
        g.fillRect(posX*size, posY*size, size, size);
        g.setColor(Color.BLACK);
        g.drawLine((int)(posX*size+size/2.0), posY*size, (int)(posX*size+size/2.0), posY*size+size);
        g.drawLine(posX*size, (int)(posY*size+size/2.0), posX*size+size, (int)(posY*size+size/2.0));
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2));
        g.drawRect(posX*size, posY*size, size, size);
        g2.setStroke(new BasicStroke(1));
    }
}
