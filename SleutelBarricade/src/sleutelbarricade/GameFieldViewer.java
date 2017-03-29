package sleutelbarricade;

import javax.swing.*;

public class GameFieldViewer  extends JFrame{
    private GameField component;
    
    private final int FRAME_WIDTH;
    private final int FRAME_HEIGHT;
    
    private int size;
    private int fieldSize;
    private int gameFieldSize;
    
    public GameFieldViewer(Level level) { 
        this.setSize(900,900);
        this.component = new GameField(level);
        
        this.fieldSize = component.getFieldSize();
        this.gameFieldSize = component.getGameFieldSize();
        
        this.FRAME_WIDTH = fieldSize * gameFieldSize;
        this.FRAME_HEIGHT = fieldSize * gameFieldSize;
        
        JPanel panel = new JPanel();
        panel.add(component);
        add(panel);
    }
}