package sleutelbarricade;

import java.awt.Color;

public class WalkWay extends Field{
    private boolean hasKey;
    private Key key;
    
    public WalkWay(){
        this.hasKey = false;
        super.setColor(Color.GRAY);
        super.setMoveThru(true);
    }
    public WalkWay(Key key){
        this.key = key;
        this.hasKey = true;
        super.setColor(Color.WHITE);
        super.setMoveThru(true);
    }
    
    @Override
    public void hasPlayer(int playerPosition){
        if(super.getX() == playerPosition){
            hasPlayer = true;
        }else{
            hasPlayer = false;
        }
    }

    //setters and getters
    public boolean isHasKey() {
        return hasKey;
    }

    public Key getKey() {
        return key;
    }
}