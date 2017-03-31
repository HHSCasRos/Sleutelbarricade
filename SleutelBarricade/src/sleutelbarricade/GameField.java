package sleutelbarricade;

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
            }
        }
        g.setColor(level.getPlayer().getColor());
        g.fillRect(level.getPlayer().getX() + 15, level.getPlayer().getY() + 15, 10, 10);
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