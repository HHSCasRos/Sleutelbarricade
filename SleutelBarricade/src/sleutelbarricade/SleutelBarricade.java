package sleutelbarricade;

import java.util.ArrayList;
import javax.swing.JFrame;

public class SleutelBarricade {
    
    public static void main(String[] args) {
        
        ArrayList<Level> levels = new ArrayList();
        Level tutorial = new Level("Tutorial", 3);
        Field[][] tutorialField = new Field[tutorial.getGameFieldSize()][tutorial.getGameFieldSize()];
        for(int i = 0; i < tutorialField.length; i++){
            for(int j = 0; j < tutorialField.length; j++){
                tutorialField[i][j] = new WalkWay();
            }
        }
        for(int i=0; i<tutorialField.length; i++){
                int j = 0;
                tutorialField[i][j].setX(0);
                tutorialField[i][j].setY(i * tutorialField[i][j].getSize());
                for(j=0; j<tutorialField.length; j++){
                    tutorialField[i][j].setX(j * tutorialField[i][j].getSize());
                    tutorialField[i][j].setY(i * tutorialField[i][j].getSize());
                }  
            }
        
        tutorial.setGameField(tutorialField);
        levels.add(tutorial);
        levels.add(new Level("Level 1", 1));
        levels.add(new Level("Level 2", 1));
        
        JFrame frame = new HomeScreen(levels);
        
        frame.setTitle("Home Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }
}