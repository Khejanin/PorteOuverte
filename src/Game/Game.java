/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Player.Player;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author Khejanin
 */
public class Game{
    
    private Point maxTiles;
    private Point panelSize;
    public static int TILE_WIDTH,TILE_HEIGHT;
    private Player player;
    private ResizeListener resizeListener;
    
    public Game(int width,int height){
        setPanelSize(width, height);
    }

    public ResizeListener getResizeListener() {
        return resizeListener;
    }
    
    public void draw(Graphics g){
        player.draw(g);
    }
    
    private void setPanelSize(int width,int height){
        panelSize.x = width;
        panelSize.y = height;
    }
    
    private void calculateTileSize(){
        
    }
    
    class ResizeListener extends ComponentAdapter{
        public void componentResized(ComponentEvent e){
            setPanelSize(e.getComponent().getWidth(), e.getComponent().getHeight());
        }
    }
}
