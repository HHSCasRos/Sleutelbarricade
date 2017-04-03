package sleutelbarricade;

import java.awt.Color;

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
    
    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }
    
    public void pickUpKey(){
            System.out.print("pick up the key");
        if(hasKey){
            //ask player if he want's to pick up the key
        } else {
            //pick up the key the player is standing on
            
        }
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