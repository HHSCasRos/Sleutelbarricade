package sleutelbarricade;

import java.awt.Color;



public abstract class Field {
    private int size;
    private int x;
    private int y;
    private boolean moveThru;
    private Color color;

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
}
