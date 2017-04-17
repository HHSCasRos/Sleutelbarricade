package sleutelbarricade;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class Player {
    private String name;
    private boolean hasKey;
    private Key key;
    private int x;
    private int y;
    private Color color;
    
    public Player(int x, int y) {
        this.x += x;
        this.y += y;
        key = new Key(0);
        this.color = Color.BLUE;
    }
    
    public boolean move(KeyEvent e, Field[][] fields, int i, int j, int fieldSize, int gameFieldSize){
        boolean encounteredObstacle = false;
        
        //walk up
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(this.y > 0 ){
                if(fields[i-1][j].canMoveThru()) {
                    this.y -= fieldSize;
                    i--;
                    encounteredObstacle = false;
                }else{
                    encounteredObstacle = true;
                }
            }
        }
        
        //walk left
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(this.x > 0 ){
                if(fields[i][j-1].canMoveThru()) {
                    this.x -= fieldSize;
                    j--;
                    encounteredObstacle = false;
                }else{
                    encounteredObstacle = true;
                }
            }
        }
        
        //walk down
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(this.y < (fieldSize * (gameFieldSize-1)) ){
                if(fields[i+1][j].canMoveThru()) {
                    this.y += fieldSize;
                    i++;
                    encounteredObstacle = false;
                }else{
                    encounteredObstacle = true;
                }
            }
        }
        
        //walk right
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(this.x < (fieldSize * (gameFieldSize-1)) ){
                if(fields[i][j+1].canMoveThru()) {
                    this.x += fieldSize;
                    j++;
                    encounteredObstacle = false;
                }else{
                    encounteredObstacle = true;
                }
            }
        }
        return encounteredObstacle;
    }
    
    public String pickUpKey(WalkWay walkway){
        if(hasKey){
            //ask player if he want's to pick up the key
            this.key = walkway.getKey();
        } else {
            //pick up the key the player is standing on
            this.key = walkway.getKey();
        }
        walkway.setKey(null);
        
        return "picked up the " + this.key.getIdCode() + " key";
    }

    //setters and getters
    public Key getKey() {
        return key;
    }
    public void setKey(Key key) {
        this.key = key;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    
    public Color getColor() {
        return this.color;
    }
}