package sleutelbarricade;

import java.util.ArrayList;
import javax.swing.JFrame;

public class SleutelBarricade {
    
    public static void main(String[] args) {
        
        ArrayList<Level> levels = new ArrayList();
        levels.add(new Level(10, 1));
        levels.add(new Level(23, 1));
        levels.add(new Level(38, 1));
        
        JFrame frame = new HomeScreen(levels.size());
        
        frame.setTitle("Home Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }
}