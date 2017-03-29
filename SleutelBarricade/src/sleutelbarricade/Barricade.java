package sleutelbarricade;

import java.awt.Color;

public class Barricade extends Field{
    private int idCode;

    public Barricade(int idCode) {
        this.idCode = idCode;
        super.setColor(Color.ORANGE);
    }
    
    public void message(){
        if(true){
            System.out.println("Key fits, barricade is opening.");
        }else{
            System.out.println("Sorry, this key doesn't fit.");
        }
    }
    
    public boolean keyFits(Key k){
        if(k.getIdCode() == idCode) {
            return true;
        }else{
            return false;
        }
    }
    
    public void open(){
        
    }

    public int getIdCode() {
        return idCode;
    }
}