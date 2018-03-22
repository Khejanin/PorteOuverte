/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author Khejanin
 */
public abstract class Entity {
    
    protected Point2D pos = new Point(0,0);
    protected Double velocity;
    protected int width,height;
    public static final int MOVE_DOWN = -1,MOVE_UP = 1,MOVE_LEFT = 2,MOVE_RIGHT = 3;
    
    public Entity(){
        width = Game.Game.TILE_WIDTH;
        height = Game.Game.TILE_HEIGHT;
    }
    
    public abstract void draw(Graphics g);
}
