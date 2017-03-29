package sleutelbarricade;

import java.util.ArrayList;
import javax.swing.JFrame;

public class SleutelBarricade {
    
    public static void main(String[] args) {
        
        ArrayList<Level> levels = new ArrayList();
        levels.add(new Level("Tutorial", 1));
        levels.add(new Level("Level 1", 1));
        levels.add(new Level("Level 2", 1));
        
        JFrame frame = new HomeScreen(levels);
        
        frame.setTitle("Home Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }
}