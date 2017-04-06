package sleutelbarricade;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cas_Ros
 */
public class LevelTest {
    /**
     * Tests of Level method, of class Level.
     */
    @Test
    public void testCreateLevelDefault() {
        String expectedNameStandaard = "default";
        
        Level standaard = new Level(expectedNameStandaard, 0);
        
        String actualNameStandaard = standaard.getIdLevel();
        
        int actualStandaardGameFieldSize = standaard.getGameFieldSize();
        int expectedStandaardGameFieldSize = 3;
        
        assertEquals(actualNameStandaard, expectedNameStandaard);
        assertEquals(actualStandaardGameFieldSize, expectedStandaardGameFieldSize);
    }
    @Test
    public void testCreateLevelEasy(){
        String expectedNameEasy = "Easy difficulty";
        
        Level makelijk = new Level(expectedNameEasy, 1);
        
        String actualNameEasy = makelijk.getIdLevel();
        
        int actualMakelijkGameFieldSize = makelijk.getGameFieldSize();
        int expectedMakelijkGameFieldSize = 5;
        
        assertEquals(actualNameEasy, expectedNameEasy);
        assertEquals(actualMakelijkGameFieldSize, expectedMakelijkGameFieldSize);
    }
    @Test
    public void testCreateLevelMedium(){
        String expectedNameMedium = "Medium difficulty";
        
        Level gemiddeld = new Level(expectedNameMedium, 2);
        
        String actualNameMedium = gemiddeld.getIdLevel();
        
        int actualGemiddeldGameFieldSize = gemiddeld.getGameFieldSize();
        int expectedGemiddeldGameFieldSize = 10;
        
        assertEquals(actualNameMedium, expectedNameMedium);
        assertEquals(actualGemiddeldGameFieldSize, expectedGemiddeldGameFieldSize);
    }
    @Test
    public void testCreateLevelHard(){
        String expectedNameHard = "Hard difficulty";
        
        Level moeilijk = new Level(expectedNameHard, 3);
        
        String actualNameHard = moeilijk.getIdLevel();
        
        int actualMoeilijkGameFieldSize = moeilijk.getGameFieldSize();
        int expectedMoeilijkGameFieldSize = 15;
        
        assertEquals(actualNameHard, expectedNameHard);
        assertEquals(actualMoeilijkGameFieldSize, expectedMoeilijkGameFieldSize);
    }
}
