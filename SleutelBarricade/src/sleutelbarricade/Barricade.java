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
    
    //check if the key the player is holding has the same pincode
    public boolean keyFits(Key k){
        if(k.getIdCode() == idCode) {
            isOpen = true;
            
            //make the barricade a fake walkway
            super.setMoveThru(true);
            super.setColor(Color.GRAY);
            
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