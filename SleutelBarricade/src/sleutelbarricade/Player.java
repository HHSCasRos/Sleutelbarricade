package sleutelbarricade;

public class Player {
    private String name;
    private boolean hasKey;
    private Key key;
    private int x;
    private int y;
    
    public Player(int x, int y) {
        this.x += x;
        this.y += y;
        key = new Key(0);
    }
    
    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }
    
    public void pickUpKey(){
        
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
}