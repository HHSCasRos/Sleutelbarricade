package sleutelbarricade;

import javax.swing.JComponent;
import java.awt.Graphics;

public class GameField extends JComponent{
    private int size;
    private Field[][] fields;

    public GameField(Level l) {
        fields = l.getGameField();
        this.size = fields.length;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        createGameField();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                g.setColor(fields[i][j].getColor());
                g.fillRect( fields[i][j].getX() , 
                            fields[i][j].getY() , 
                            fields[i][j].getSize()   , 
                            fields[i][j].getSize()   );
            }
        }
    }
    
    public void createGameField() {
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                fields[i][j] = new WalkWay();
            }
        }
        
        for(int i=0; i<size; i++){
                int j = 0;
                fields[i][j].setX(0);
                fields[i][j].setY(i * fields[i][j].getSize());
                for(j=0; j<size; j++){
                    fields[i][j].setX(j * fields[i][j].getSize());
                    fields[i][j].setY(i * fields[i][j].getSize());
                }  
            }
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