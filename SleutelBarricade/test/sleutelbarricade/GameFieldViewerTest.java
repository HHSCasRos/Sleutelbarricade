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
        Robot robot = new Robot();
        level.requestFocusInWindow();
        
        //get player position by getting the player coordinates and dividing them by the size of the fields
        int Y;
        int X;
            
        //test walking out of the top
        for(int i = 0;i < test.getGameFieldSize(); i++){
            robot.keyPress(KeyEvent.VK_UP);
            robot.keyRelease(KeyEvent.VK_UP);
        }
        
        Y = level.getLevelCopy().getPlayer().getY()/level.getLevelCopy().getGameField()[0][0].getSize();
        
        assertEquals(0, Y);
        
        //test walking out of the left side
        for(int i = 0;i < test.getGameFieldSize(); i++){
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.keyRelease(KeyEvent.VK_LEFT);
        }
        
        X = level.getLevelCopy().getPlayer().getX()/level.getLevelCopy().getGameField()[0][0].getSize();
        
        assertEquals(0, X);
        
        //test walking out of the bottom
        for(int i = 0;i < test.getGameFieldSize(); i++){
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
        }
        
        Y = level.getLevelCopy().getPlayer().getY()/level.getLevelCopy().getGameField()[0][0].getSize();
        
        assertEquals(level.getLevelCopy().getGameFieldSize() - 1, Y);
        
        //test walking out of the right side
        for(int i = 0;i < test.getGameFieldSize(); i++){
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }
        
        X = level.getLevelCopy().getPlayer().getX()/level.getLevelCopy().getGameField()[0][0].getSize();
        
        assertEquals(level.getLevelCopy().getGameFieldSize() - 1, X);
    }
}