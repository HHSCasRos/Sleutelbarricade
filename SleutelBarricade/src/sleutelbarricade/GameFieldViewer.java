package sleutelbarricade;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GameFieldViewer  extends JFrame{
    private GameField component;
    private JPanel pausePanel;
    
    private final int FRAME_WIDTH;
    private final int FRAME_HEIGHT;
    
    private int fieldSize;
    private int gameFieldSize;
    private Level level;
    private Field[][] fields;
    
    public GameFieldViewer(Level level, JFrame homeScreen) {
        createPausePanel();
        
        this.setLayout(new BorderLayout());
        this.level = level;
        
        this.fields = this.level.getGameField();
        this.component = new GameField(this.level);
        
        KeyListener listener = new KeyListener1(this, homeScreen);
        this.addKeyListener(listener);
        
        //define and set framesize based on the required size of GameField
        this.fieldSize = component.getFieldSize();
        this.gameFieldSize = component.getGameFieldSize();
        
        this.FRAME_WIDTH = fieldSize * gameFieldSize;
        this.FRAME_HEIGHT = fieldSize * gameFieldSize;
        this.setSize(FRAME_WIDTH + 16, FRAME_HEIGHT + 39);
        
        add(component, BorderLayout.CENTER);
        
        component.setVisible(true);
        pausePanel.setVisible(false);
    }
    
    public void createPausePanel(){
        JButton resume = new JButton("Resume");
        
        JButton restart = new JButton("Restart");
        
        JButton HomeScreen = new JButton("HomeScreen");
        
        
        pausePanel = new JPanel();
        pausePanel.setLayout(new GridLayout(3,1));
        pausePanel.add(resume);
        pausePanel.add(restart);
        pausePanel.add(HomeScreen);
        add(pausePanel);
    }
    
    
    class KeyListener1 implements KeyListener {   
        private JFrame frame;
        private JFrame homeScreen;
        private boolean paused;
        
        public KeyListener1(JFrame frame, JFrame homeScreen) {
            this.frame = frame;
            this.homeScreen = homeScreen;
            this.paused = false;
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }
    

        @Override
        public void keyReleased(KeyEvent e) {
            //determine field coordinates of player
            int i = level.getPlayer().getY()/fieldSize;
            int j = level.getPlayer().getX()/fieldSize;
            
            //pause/unpause the game
            if(e.getKeyCode() == KeyEvent.VK_PAUSE){
                paused = !paused;
                component.setVisible(!paused);
                pausePanel.setVisible(paused);
                System.out.println("pause key pressed " + paused);
            }
            
            if(paused != true){//disable walking if game is paused
                //walk up
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    if(level.getPlayer().getY() > 0 ){
                        if(fields[i-1][j].canMoveThru()) {
                            level.getPlayer().move(0, -fieldSize);
                            i--;
                        }else{
                           checkIfBaricadeCanOpen(i-1,j); 
                        }
                    }
                }
                //walk left
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if(level.getPlayer().getX() > 0 ){
                        if(fields[i][j-1].canMoveThru()) {
                            level.getPlayer().move(-fieldSize, 0);
                            j--;
                        }else{
                           checkIfBaricadeCanOpen(i,j-1); 
                        }
                    }
                }
                //walk down
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    if(level.getPlayer().getY() < (fieldSize * (gameFieldSize-1)) ){
                        if(fields[i+1][j].canMoveThru()) {
                            level.getPlayer().move(0, +fieldSize);
                            i++;
                        }else{
                           checkIfBaricadeCanOpen(i+1,j); 
                        }
                    }
                }
                //walk right
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if(level.getPlayer().getX() < (fieldSize * (gameFieldSize-1)) ){
                        if(fields[i][j+1].canMoveThru()) {
                            level.getPlayer().move(+fieldSize, 0);
                            j++;
                        }else{
                           checkIfBaricadeCanOpen(i,j+1); 
                        }
                    }
                }
            }
            
            
            checkIfWalkWayHasKey(i, j);
            checkIfEndFieldFound(i, j);
            
            System.out.println("X: " + level.getPlayer().getX() + "\n"
                             + "Y: " + level.getPlayer().getY());
            
            component.repaint();
        }
        //checks if the field the player is standing on has a key
        //and if it does, calls the pickUpKey method in player
        private void checkIfWalkWayHasKey(int i, int j) {
            if(fields[i][j] instanceof WalkWay){//make sure it's possible for the current field to have a key
                WalkWay currentField = (WalkWay) fields[i][j];
                if(currentField.isHasKey()){
                    level.getPlayer().pickUpKey(currentField);
                }
            }
        }
        
        private void checkIfBaricadeCanOpen(int i, int j) {
            if(fields[i][j] instanceof Barricade){//make sure it's possible for the current field to have a key
                Barricade currentField = (Barricade) fields[i][j];
                if(!currentField.open()) {
                    currentField.keyFits(level.getPlayer().getKey());
                }
            }
        }
        
        private void checkIfEndFieldFound(int i, int j) {
            if(fields[i][j] instanceof EndField){//make sure it's possible for the current field to have a key
                EndField currentField = (EndField) fields[i][j];
                currentField.endGame();
                
                homeScreen.setVisible(true);
                frame.dispose();
            }
        }
    }
}