package sleutelbarricade;

import javax.swing.JComponent;
import java.awt.Graphics;

public class GameField extends JComponent{
    private int size;
    private Field[][] fields;

    public GameField(int niveau) {
        switch(niveau) {
            case 1: 
                this.size = 10;
                break;
            case 2:
                this.size = 15;
                break;
            case 3:
                this.size = 20;
                break;
            default :
                this.size = 10;
                break;
        }
        fields = new Field[size][size];
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