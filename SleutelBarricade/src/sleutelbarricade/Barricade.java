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
    
    //message given if an incorrect key is used
    public String message(){
        return "Sorry, this key doesn't fit.";
    }
    
    //check if the key the player is holding has the same pincode
    public String keyFits(Key k){
        if(k.getIdCode() == idCode) {
            isOpen = true;
            
            //make the barricade a fake walkway
            super.setMoveThru(true);
            super.setColor(Color.GRAY);
                    
            return "barricade opened";
        }else{
            return message();
        }
    }
    
    public boolean open(){
        return isOpen;
    }

    public int getIdCode() {
        return idCode;
    }
}