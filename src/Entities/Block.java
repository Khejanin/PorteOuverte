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
public abstract class Block {
    
    protected int posX = 0,posY = 0;
    protected Color color;
    protected boolean isWalkable;
    
    public Block(int posX,int posY){
        this.posX = posX;
        this.posY = posY;
    }
    
    public abstract void draw(Graphics g,int size);
}
