package sleutelbarricade;

import javax.swing.JComponent;
import java.awt.Graphics;

public class GameField extends JComponent{
    private int size;
    private Field[][] fields;

    public GameField(int size) {
        this.size = size;
        fields = new Field[size][size];
    }
    
    public void createGameField() {
        
    }
    
    
    public void paintComponent(Graphics g) {
        
    }
    
    //setters and getters
    public int getGameFieldSize() {
        return this.size;
    }
    public void setGameFieldSize(int size) {
        this.size = size;
    }
    public int getFieldSize() {
        return fields[0][0].getSize();
    }
}