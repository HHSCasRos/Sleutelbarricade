package sleutelbarricade;

import javax.swing.JFrame;

public class GameFieldViewer  extends JFrame{
    private HomeComponent component;
    
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;
    
    private int size;
    
    public GameFieldViewer(int size) {
        
        this.size = size;
        
        
        
        this.component = new GameField(this.size);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
}