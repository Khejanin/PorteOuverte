/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maze;

import Entities.Block;
import Entities.Brick;
import Entities.Grass;
import Player.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

/**
 *
 * @author Khejanin
 */
public class Maze{
    
    private static int SIZE = 50;
    private Point panelSize = new Point();
    public static int TILE_SIZE = 0;
    private Player player = new Player();
    private ResizeListener resizeListener = new ResizeListener();
    private Block[][] blocks = new Block[SIZE][SIZE];
    private static final int HORIZONTAL = 1,VERTICAL = 3;
    
    public Maze(int width,int height){
        generate(width, height);
//        generateGrass();
    }

    public void generate(int width,int height){
        setPanelSize(width, height);
        calculateTileSize();
        clear();
        drawBorder(0, SIZE, 0, SIZE);
        maze(1, SIZE-1, 1, SIZE-1,new Point(0,0));
//        generateGrass();
    }
    
    public ResizeListener getResizeListener() {
        return resizeListener;
    }
    
    public void draw(Graphics g,int width,int height){
        g.setColor(Color.RED);
        g.drawRect(0, 0, TILE_SIZE*SIZE, TILE_SIZE*SIZE);
        setPanelSize(width, height);
        calculateTileSize();
        player.draw(g,TILE_SIZE);
        draw(g);
    }
    
    public void fill(){
        if(blocks != null){
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    blocks[i][j] = new Brick(i, j);
                }
            }
        }
    }
    
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        if(blocks != null){
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if(blocks[i][j] != null)
                        blocks[i][j].draw(g,TILE_SIZE);
                }
            }
        }
    }
    
    private void setPanelSize(int width,int height){
        panelSize.x = width;
        panelSize.y = height;
    }
    
    private void calculateTileSize(){
        int size = Math.min(panelSize.x, panelSize.y);
        TILE_SIZE = size/SIZE;
    }
    
//    public void maze(int startX,int endX,int startY,int endY,int dir){
//        if(endX-startX > 5 && endY - startY > 5){
//            int randomX = (int)(Math.random()*(endX-startX))+startX;
//            int randomY = (int)(Math.random()*(endY-startY))+startY;
//            System.out.println("X : " + randomX + " Y : "+randomY);
//            if(dir == HORIZONTAL){
//                int pos = randomY;
//                int special = randomX;
//                for(int i = startX;i < endX;i++){
//                    if(i != special) blocks[i][pos] = new Brick(i, pos);
//                    else blocks[i][pos] = new Grass(i, pos);
//                }
//                maze(startX, endX, startY, pos, VERTICAL);
//                maze(startX, endX, pos+1, endY, VERTICAL);
//            }
//            else{
//                int pos = randomX;
//                int special = randomY;
//                for(int i = startY;i < endY;i++){
//                    if(i != special) blocks[pos][i] = new Brick(pos, i);
//                    else blocks[pos][i] = new Grass(pos, i);
//                }
//                maze(startX, pos, startY, pos, HORIZONTAL);
//                maze(pos+1, endX, startY, endY, HORIZONTAL);
//            }
//        }
//    }
//    
//    public void maze(int startX,int endX,int startY,int endY,int dir){
//        if(endX-startX > 1 && endY - startY > 1){
//            int randomX = (int)(Math.random()*(endX-startX))+startX;
//            int randomY = (int)(Math.random()*(endY-startY))+startY;
//            System.out.println("X : " + randomX + " Y : "+randomY);
//            if(dir == HORIZONTAL){
//                int pos = randomY;
//                int special = randomX;
//                for(int i = startX;i < endX;i++){
//                    if(i != special) blocks[i][pos] = new Brick(i, pos);
//                    else blocks[i][pos] = new Grass(i, pos);
//                }
//                maze(startX, special, startY, pos, VERTICAL);
//                maze(special+1, endX, startY, pos, VERTICAL);
//                maze(startX, special, pos+1, endY, VERTICAL);
//                maze(special+1, endX, pos+1, endY, VERTICAL);
//            }
//            else{
//                int pos = randomX;
//                int special = randomY;
//                for(int i = startY;i < endY;i++){
//                    if(i != special) blocks[pos][i] = new Brick(pos, i);
//                    else blocks[pos][i] = new Grass(pos, i);
//                }
//                maze(startX, pos, startY, special, HORIZONTAL);
//                maze(startX, pos, special+1, endY-1, HORIZONTAL);
//                maze(pos+1, endX, startY, special, HORIZONTAL);
//                maze(pos+1, endX, special+1, endY-1, HORIZONTAL);
//            }
//        }
//    }
//    
    public void maze(int startX,int endX,int startY,int endY,Point forbidden){
        drawBorder(startX,endX,startY,endY);
        generateMaze(startX, endX, startY, endY, forbidden);
    }
    
    public void drawBorder(int startX,int endX,int startY,int endY){
        if(blocks != null){
            for (int i = 0; i < SIZE; i++) {
                blocks[i][0] = new Brick(i, 0);
                if(i != 1)
                    blocks[0][i] = new Brick(0,i);
                blocks[i][SIZE-1] = new Brick(i,SIZE-1);
                if(i != SIZE-2)
                    blocks[SIZE-1][i] = new Brick(SIZE-1,i);
            }
        }
    }
    
    public boolean findPath(Point current,ArrayList<Point> path){
        if(!path.contains(current)){
            path.add(current);
            if(blocks[current.x+1][current.y].isWalkable()){
                return findPath(new Point(current.x+1,current.y),path);
            }
            if(blocks[current.x][current.y+1].isWalkable()){
                
            }
            if(blocks[current.x-1][current.y].isWalkable()){
                
            }
            if(blocks[current.x][current.y-1].isWalkable()){
                
            }
            return true;
        }
        else return false;
    }
    
    public void generateMaze(int startX,int endX,int startY,int endY,Point forbidden){
        
        if(endX- startX > 4 || endY - startY > 4){
            if( endX - startX > 2 && endY - startY > 2){
                int randomX = (int)(Math.random()*(endX-startX-2))+startX+1;
                int randomY = (int)(Math.random()*(endY-startY-2))+startY+1;
                while(randomX == forbidden.x && randomY == forbidden.y){
                    randomX = (int)(Math.random()*(endX-startX))+startX;
                    randomY = (int)(Math.random()*(endY-startY))+startY;
                }

                int hole1 = (int)(Math.random()*(randomX-startX))+startX;
                int hole2 = (int)(Math.random()*(endX-randomX-1))+randomX+1;
                int hole3 = (int)(Math.random()*(randomY-startY))+startY;
                int hole4 = (int)(Math.random()*(endY-randomY-1))+randomY+1;

                forbidden.x = randomX;
                forbidden.y = randomY;


                for(int i = startX ; i < randomX+1;i++){ //Horizontal 1
                    if(i != hole1){
                        blocks[i][randomY] = new Brick(i, randomY);
                    }
    //                else blocks[i][randomY] = new Grass(i, randomY);
                }
                for(int i = randomX+1 ; i < endX ; i++){ //Horizontal 2
                    if(i != hole2){
                        blocks[i][randomY] = new Brick(i, randomY);
                    }
    //                else blocks[i][randomY] = new Grass(i, randomY);
                }


                for(int i = startY ; i < randomY;i++){ //Vertical 1
                    if(i != hole3){
                        blocks[randomX][i] = new Brick(randomX, i);
                    }
    //                else blocks[randomX][i] = new Grass(randomX, i);
                }
                for(int i = randomY+1 ; i < endY ; i++){ //Vertical 2
                    if(i != hole4){
                        blocks[randomX][i] = new Brick(randomX, i);
                    }
    //                else blocks[randomX][i] = new Grass(randomX, i);
                }
                maze(startX, randomX, startY, randomY, new Point(hole1,hole3));
                maze(randomX+1, endX, startY, randomY, new Point(hole2,hole3));
                maze(startX, randomX, randomY+1, endY, new Point(hole1,hole4));
                maze(randomX+1, endX, randomY+1, endY, new Point(hole2,hole4));
            }
        }
    }
    
    public void generateGrass(){
        if(blocks != null){
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if(blocks[i][j] == null)
                        blocks[i][j] = new Grass(i, j);
                }
            }
        }
    }
    
    public void clear(){
        blocks = new Block[SIZE][SIZE];
    }
    
    class ResizeListener extends ComponentAdapter{
        public void componentResized(ComponentEvent e){
            setPanelSize(e.getComponent().getWidth(), e.getComponent().getHeight());
            calculateTileSize();
            System.out.println("resize");
        }
    }
    
}
