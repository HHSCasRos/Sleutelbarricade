package sleutelbarricade;

import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Graphics;

public class GameField extends JComponent{
    private int size;
    private Field[][] fields;
    private Level level;

    public GameField(Level l) {
        this.level = l;
        fields = level.getGameField();
        this.size = fields.length;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                g.setColor(fields[i][j].getColor());
                g.fillRect( fields[i][j].getX() , 
                            fields[i][j].getY() , 
                            fields[i][j].getSize()   , 
                            fields[i][j].getSize()   );
                if(fields[i][j] instanceof Barricade){
                    Barricade currentField = (Barricade) fields[i][j];
                    if(!currentField.open()) {
                        g.setColor(Color.BLACK);
                        g.drawString(""+currentField.getIdCode(),
                                     fields[i][j].getX()+(fields[i][j].getSize()/4), 
                                     fields[i][j].getY()+(fields[i][j].getSize()/2));
                    }
                }
                if(fields[i][j] instanceof WalkWay){//make sure it's possible for the current field to have a key
                    WalkWay currentField = (WalkWay) fields[i][j];
                    if(currentField.isHasKey()){
                        g.setColor(Color.BLACK);
                        g.drawString(""+currentField.getKey().getIdCode(),
                                     fields[i][j].getX()+(fields[i][j].getSize()/4), 
                                     fields[i][j].getY()+(fields[i][j].getSize()/2));
                    }
                }
            }
        }
        g.setColor(level.getPlayer().getColor());
        g.fillRect(level.getPlayer().getX() + fields[0][0].getSize()/4,
                    level.getPlayer().getY() + fields[0][0].getSize()/4,
                    fields[0][0].getSize()/2, 
                    fields[0][0].getSize()/2);
    }
    
    //setters and getters
    public int getGameFieldSize() {
        return this.size;
    }
    public void setGameFieldSize(int size) {
        this.size = size;
    }
    public int getFieldSize() {
        if(fields[0][0] == null){
           return 10; 
        }else{
           return fields[0][0].getSize();
        }
    }
}