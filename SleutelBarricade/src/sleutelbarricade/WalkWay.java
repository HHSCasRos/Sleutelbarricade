package sleutelbarricade;

import java.awt.Color;



public class WalkWay extends Field{
    private boolean hasKey;
    private Key key;
    
    public WalkWay(){
        this.hasKey = false;
        super.setColor(Color.GRAY);
    }
    public WalkWay(Key key){
        this.key = key;
        this.hasKey = true;
        super.setColor(Color.GRAY);
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public Key getKey() {
        return key;
    }
}