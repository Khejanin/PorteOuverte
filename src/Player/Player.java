/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Khejanin
 */
public class Player extends Entities.Entity{

    @Override
    public void draw(Graphics g,int size) {
        g.setColor(Color.RED);
        g.fillOval((int)pos.getX(),(int)pos.getY(),size,size);
        g.setColor(Color.BLACK);
        g.drawOval((int)pos.getX(),(int)pos.getY(), size, size);
    }
    
    public void move(int direction){
        if(direction == MOVE_DOWN){
            pos.setLocation(pos.getX(), pos.getY()+velocity);
        }
        else if(direction == MOVE_UP){
            pos.setLocation(pos.getX(), pos.getY()-velocity);
        }
        else if(direction == MOVE_LEFT){
            pos.setLocation(pos.getX()-velocity, pos.getY());
        }
        else if(direction == MOVE_RIGHT){
            pos.setLocation(pos.getX()+velocity, pos.getY());
        }
    }
}
