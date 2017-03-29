package sleutelbarricade;

import java.awt.Color;

public class EndField extends Field{
    public EndField() {
        super.setColor(Color.GREEN);
    }
    
    public void message(){
        System.out.println("Victory!");
    }
    
    public void endGame(){
        
    }
}