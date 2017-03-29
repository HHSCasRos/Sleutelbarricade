package sleutelbarricade;

import javax.swing.JFrame;

public class GameFieldViewer  extends JFrame{
    private GameField component;
    
    private final int FRAME_WIDTH;
    private final int FRAME_HEIGHT;
    
    private int size;
    private int fieldSize;
    private int gameFieldSize;
    
    public GameFieldViewer(Level level) {       
        this.component = new GameField(level);
        
        this.fieldSize = component.getFieldSize();
        this.gameFieldSize = component.getGameFieldSize();
        
        this.FRAME_WIDTH = fieldSize * gameFieldSize;
        this.FRAME_HEIGHT = fieldSize * gameFieldSize;
        
        
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        add(component);
    }
}