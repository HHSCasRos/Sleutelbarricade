package sleutelbarricade;

import java.awt.Color;

public class Wall extends Field{

    public Wall() {
        super.setColor(Color.RED);
        super.setMoveThru(false);
    }
    
    @Override
    public void hasPlayer(int playerPosition){
        hasPlayer = false;
    }
}