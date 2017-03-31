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
        
        this.fieldSize = component.getFieldSize();
        this.gameFieldSize = component.getGameFieldSize();
        
        //define and set framesize
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
            int j = level.getPlayer().getX()/fieldSize;
            int i = level.getPlayer().getY()/fieldSize;
            //walk up
            if(e.getKeyCode() == KeyEvent.VK_UP){
                if(level.getPlayer().getY() > 0 ){
                    if(fields[i-1][j].canMoveThru()) {
                        level.getPlayer().move(0, -fieldSize);
                    }
                }
                
            }
            //walk left
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                if(level.getPlayer().getX() > 0 ){
                    if(fields[i][j-1].canMoveThru()) {
                        level.getPlayer().move(-fieldSize, 0);
                    }
                }
            }
            //walk down
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                if(level.getPlayer().getY() < (fieldSize * (gameFieldSize-1)) ){
                    if(fields[i+1][j].canMoveThru()) {
                        level.getPlayer().move(0, +fieldSize);
                    }
                }
            }
            //walk right
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                if(level.getPlayer().getX() < (fieldSize * (gameFieldSize-1)) ){
                    if(fields[i][j+1].canMoveThru()) {
                        level.getPlayer().move(+fieldSize, 0);
                    }
                }
            }
            
            System.out.println("X: " + level.getPlayer().getX() + "\n"
                             + "Y: " + level.getPlayer().getY());
            
            component.repaint();
        }
    }
}