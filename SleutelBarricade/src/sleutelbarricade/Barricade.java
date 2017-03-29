package sleutelbarricade;

import java.awt.Color;



public class Barricade extends Field{
    private int idCode;

    public Barricade(int idCode) {
        this.idCode = idCode;
        super.setColor(Color.ORANGE);
    }
    
    public void message(){
        
    }
    public boolean keyFits(){
        
    }
    public void open(){
        
    }

    public int getIdCode() {
        return idCode;
    }
    
}