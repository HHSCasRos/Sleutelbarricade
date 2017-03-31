package sleutelbarricade;

import java.awt.Color;

public class EndField extends Field{
    public EndField() {
        super.setColor(Color.GREEN);
        super.setMoveThru(true);
    }
    
    @Override
    public void hasPlayer(int playerPosition){
        if(super.getX() == playerPosition){
            endGame();
        }else{
            hasPlayer = false;
        }
    }
    
    public void message(){
        System.out.println("Victory!");
    }
    
    public void endGame(){
        
    }
}