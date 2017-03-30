package gamefieldtest;

import java.awt.Color;

public class Field {
    private static final int size = 80;
    private int x;
    private int y;
    private boolean hasPlayer;
    private Color color;
    
    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getSize() {
        return size;
    }
    
    public void checkPlayer(Player p) {
        if(p.getX() >= this.x           && 
           p.getX() < this.x + size    &&
           p.getY() >= this.y           &&
           p.getY() < this.y + size) 
        {
            hasPlayer = true;
        }else{
            hasPlayer = false;
        }
    }
    
    public boolean hasPlayer() {
        return hasPlayer;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return this.x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return this.y;
    }
}
