package sleutelbarricade;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameFieldViewerTest {
    public GameFieldViewerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createPausePanel method, of class GameFieldViewer.
     * @throws java.awt.AWTException
     */
    @Test
    public void testMoveOutOfBounds() throws AWTException{
        //set up field
        Level test = new Level("Tutorial", 0);
        Field[][] testField = new Field[test.getGameFieldSize()][test.getGameFieldSize()];
        for (Field[] testField1 : testField) {
            for (int j = 0; j < testField.length; j++) {
                testField1[j] = new WalkWay();
            }
        }
        for(int i=0; i < testField.length; i++){
            int j = 0;
            testField[i][j].setX(0);
            testField[i][j].setY(i * testField[i][j].getSize());
            for(j=0; j<testField.length; j++){
                testField[i][j].setX(j * testField[i][j].getSize());
                testField[i][j].setY(i * testField[i][j].getSize());
            }
        }
        test.setGameField(testField);
        
        //add level to array list for homescreen
        ArrayList<Level> arraylist;
        arraylist = new ArrayList();
        arraylist.add(test);
        
        //create homescreen for constructor
        HomeScreen frame;
        frame = new HomeScreen(arraylist);
        
        //create GameFieldViewer
        GameFieldViewer level;
        level = new GameFieldViewer(test, frame);
        
        //thing that simulates key presses
        KeyEvent direction;
        
        //get player position by getting the player coordinates and dividing them by the size of the fields
        int Y;
        int X;
            
        //test walking out of the top
        direction = new KeyEvent(level, 0, 0, 0, 38);
        
        for(int i = 0;i < test.getGameFieldSize(); i++){
            level.getLevelCopy().getPlayer().move(
                    direction,
                    level.getLevelCopy().getGameField(),
                    level.getLevelCopy().getPlayer().getY()/level.getLevelCopy().getGameField()[0][0].getSize(),
                    level.getLevelCopy().getPlayer().getX()/level.getLevelCopy().getGameField()[0][0].getSize(),
                    level.getLevelCopy().getGameField()[0][0].getSize(),
                    level.getLevelCopy().getGameFieldSize());
        }
        
        
        Y = level.getLevelCopy().getPlayer().getY()/level.getLevelCopy().getGameField()[0][0].getSize();
        
        assertEquals(0, Y);
        
        //test walking out of the left side
        direction = new KeyEvent(level, 0, 0, 0, 37);
        
        for(int i = 0;i < test.getGameFieldSize(); i++){
            level.getLevelCopy().getPlayer().move(
                    direction,
                    level.getLevelCopy().getGameField(),
                    level.getLevelCopy().getPlayer().getY()/level.getLevelCopy().getGameField()[0][0].getSize(),
                    level.getLevelCopy().getPlayer().getX()/level.getLevelCopy().getGameField()[0][0].getSize(),
                    level.getLevelCopy().getGameField()[0][0].getSize(),
                    level.getLevelCopy().getGameFieldSize());
        }
        
        
        X = level.getLevelCopy().getPlayer().getX()/level.getLevelCopy().getGameField()[0][0].getSize();
        
        assertEquals(0, X);
        
        //test walking out of the bottom
        direction = new KeyEvent(level, 0, 0, 0, 40);
        
        for(int i = 0;i < test.getGameFieldSize(); i++){
            level.getLevelCopy().getPlayer().move(
                    direction,
                    level.getLevelCopy().getGameField(),
                    level.getLevelCopy().getPlayer().getY()/level.getLevelCopy().getGameField()[0][0].getSize(),
                    level.getLevelCopy().getPlayer().getX()/level.getLevelCopy().getGameField()[0][0].getSize(),
                    level.getLevelCopy().getGameField()[0][0].getSize(),
                    level.getLevelCopy().getGameFieldSize());
        }
        
        
        Y = level.getLevelCopy().getPlayer().getY()/level.getLevelCopy().getGameField()[0][0].getSize();
        
        assertEquals(level.getLevelCopy().getGameFieldSize() - 1, Y);
        
        //test walking out of the right side
        direction = new KeyEvent(level, 0, 0, 0, 39);
        
        for(int i = 0;i < test.getGameFieldSize(); i++){
            level.getLevelCopy().getPlayer().move(
                    direction,
                    level.getLevelCopy().getGameField(),
                    level.getLevelCopy().getPlayer().getY()/level.getLevelCopy().getGameField()[0][0].getSize(),
                    level.getLevelCopy().getPlayer().getX()/level.getLevelCopy().getGameField()[0][0].getSize(),
                    level.getLevelCopy().getGameField()[0][0].getSize(),
                    level.getLevelCopy().getGameFieldSize());
        }
        
        
        X = level.getLevelCopy().getPlayer().getX()/level.getLevelCopy().getGameField()[0][0].getSize();
        
        assertEquals(level.getLevelCopy().getGameFieldSize() - 1, X);
    }
}