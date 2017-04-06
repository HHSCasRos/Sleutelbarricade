package sleutelbarricade;

import java.awt.Color;

public abstract class Field {
    private static final int size = 60;
    private int x;
    private int y;
    private boolean moveThru;
    protected boolean hasPlayer;
    private Color color;
    
    public abstract void hasPlayer(int playerPosition);
    
    //setters and getters
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
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean canMoveThru() {
        return moveThru;
    }
    public void setMoveThru(boolean moveThru) {
        this.moveThru = moveThru;
    }
}