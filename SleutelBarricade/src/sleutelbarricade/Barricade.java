package sleutelbarricade;

import java.awt.Color;

public class Barricade extends Field{
    private int idCode;
    private boolean isOpen;

    public Barricade(int idCode) {
        this.idCode = idCode;
        this.isOpen = false;
        super.setColor(Color.ORANGE);
    }
    
    @Override
    public void hasPlayer(int playerPosition){
        if(super.getX() == playerPosition){
            hasPlayer = true;
        }else{
            hasPlayer = false;
        }
    }
    
    public void message(){
        System.out.println("Sorry, this key doesn't fit.");
    }
    
    public boolean keyFits(Key k){
        if(k.getIdCode() == idCode) {
            isOpen = true;
            return true;
        }else{
            message();
            return false;
        }
    }
    
    public boolean open(){
        return isOpen;
    }

    public int getIdCode() {
        return idCode;
    }
}