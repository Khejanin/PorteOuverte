/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author nogal156
 */
public class Floor extends Block{

    public Floor(int posX, int posY) {
        super(posX, posY);
        color = Color.GRAY;
        isWalkable = true;
    }

    @Override
    public void draw(Graphics g, int size) {
        g.setColor(color);
        g.fillRect(posX*size, posY*size, size, size);
    }
    
}
