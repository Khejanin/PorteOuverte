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
    
    private Point maxTiles = new Point();
    private Point panelSize = new Point();
    public static int TILE_WIDTH,TILE_HEIGHT;
    private Player player;
    private ResizeListener resizeListener = new ResizeListener();
    
    public Game(int width,int height){
        setPanelSize(width, height);
    }

    public ResizeListener getResizeListener() {
        return resizeListener;
    }
    
    public void draw(Graphics g){
        player.draw(g);
        
    }
    
    public void drawGrid(Graphics g){
        for (int i = 0; i < maxTiles.x; i++) {
            for (int j = 0; j < maxTiles.y; j++) {
               
            }
        }
    }
    
    private void setPanelSize(int width,int height){
        panelSize.x = width;
        panelSize.y = height;
    }
    
    private void calculateTileSize(){
        int size = Math.min(panelSize.x, panelSize.y);
        TILE_WIDTH = size/50;
        TILE_HEIGHT = size/50;
        maxTiles.x = panelSize.x / TILE_WIDTH;
        maxTiles.y = panelSize.y / TILE_HEIGHT;
    }
    
    class ResizeListener extends ComponentAdapter{
        public void componentResized(ComponentEvent e){
            setPanelSize(e.getComponent().getWidth(), e.getComponent().getHeight());
            System.out.println("resize");
        }
    }
}
