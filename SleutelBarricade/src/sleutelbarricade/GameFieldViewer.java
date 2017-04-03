package sleutelbarricade;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFieldViewer  extends JFrame{
    private GameField component;
    
    private final int FRAME_WIDTH;
    private final int FRAME_HEIGHT;
    
    private int size;
    private int fieldSize;
    private int gameFieldSize;
    private Level level;
    private Field[][] fields;
    
    public GameFieldViewer(Level level) {
        this.level = level;
        this.fields = level.getGameField();
        this.component = new GameField(level);
        
        KeyListener listener = new KeyListener1();
        this.addKeyListener(listener);
        
        //define and set framesize based on the required size of GameField
        this.fieldSize = component.getFieldSize();
        this.gameFieldSize = component.getGameFieldSize();
        
        this.FRAME_WIDTH = fieldSize * gameFieldSize;
        this.FRAME_HEIGHT = fieldSize * gameFieldSize;
        this.setSize(FRAME_WIDTH + 16, FRAME_HEIGHT + 39);
        
        add(component);
    }
    
    class KeyListener1 implements KeyListener {         
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }
    

        @Override
        public void keyReleased(KeyEvent e) {
            //determine field coordinates of player
            int i = level.getPlayer().getY()/fieldSize;
            int j = level.getPlayer().getX()/fieldSize;
            
            //walk up
            if(e.getKeyCode() == KeyEvent.VK_UP){
                if(level.getPlayer().getY() > 0 ){
                    if(fields[i-1][j].canMoveThru()) {
                        level.getPlayer().move(0, -fieldSize);
                        i--;
                    }
                }
            }
            //walk left
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                if(level.getPlayer().getX() > 0 ){
                    if(fields[i][j-1].canMoveThru()) {
                        level.getPlayer().move(-fieldSize, 0);
                        j--;
                    }
                }
            }
            //walk down
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                if(level.getPlayer().getY() < (fieldSize * (gameFieldSize-1)) ){
                    if(fields[i+1][j].canMoveThru()) {
                        level.getPlayer().move(0, +fieldSize);
                        i++;
                    }
                }
            }
            //walk right
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                if(level.getPlayer().getX() < (fieldSize * (gameFieldSize-1)) ){
                    if(fields[i][j+1].canMoveThru()) {
                        level.getPlayer().move(+fieldSize, 0);
                        j++;
                    }
                }
            }
            
            checkIfWalkWayHasKey(i, j);
            
            System.out.println("X: " + level.getPlayer().getX() + "\n"
                             + "Y: " + level.getPlayer().getY());
            
            component.repaint();
        }
        //checks if the field the player is standing on has a key
        //and if it does, calls the pickUpKey method in player
        private void checkIfWalkWayHasKey(int i, int j) {
            if(fields[i][j] instanceof WalkWay){//make sure it's possible for the current field to have a key
                WalkWay currentField = (WalkWay) fields[i][j];
                if(currentField.isHasKey()){
                    level.getPlayer().pickUpKey();
                }
            }
        }
    }
}