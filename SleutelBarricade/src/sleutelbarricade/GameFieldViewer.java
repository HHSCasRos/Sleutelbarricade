package sleutelbarricade;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFieldViewer  extends JFrame{
    private GameField component;
    private JPanel pausePanel;
    private JPanel messagePanel;
    
    private final int FRAME_WIDTH;
    private final int FRAME_HEIGHT;
    
    private int fieldSize;
    private int gameFieldSize;
    private Level level;
    private Level levelCopy;
    private Field[][] fields;
    private JLabel label;
    
    public GameFieldViewer(Level level, HomeScreen homeScreen) {
        this.setLayout(new BorderLayout());
        this.level = level;
        this.levelCopy = new Level(level.getIdLevel(),level.getNiveau());
        this.levelCopy.setGameField(level.getGameField());
        
        this.fields = this.levelCopy.getGameField();
        this.component = new GameField(this.levelCopy);
        
        //define and set framesize based on the required size of GameField
        this.fieldSize = component.getFieldSize();
        this.gameFieldSize = component.getGameFieldSize();
        
        this.FRAME_WIDTH = fieldSize * gameFieldSize;
        this.FRAME_HEIGHT = fieldSize * gameFieldSize;
        this.setSize(FRAME_WIDTH + 16, FRAME_HEIGHT + 89);

        createPausePanel(homeScreen);
        KeyListener listener = new KeyListener1(this, homeScreen);
        this.addKeyListener(listener);
        pausePanel.addKeyListener(listener);
        
        createMessageBoard();
        
        add(pausePanel, BorderLayout.NORTH);
        add(messagePanel, BorderLayout.SOUTH);
        add(component, BorderLayout.CENTER);
        
        pausePanel.setVisible(false);
        //messagePanel.setVisible(false);
        component.setVisible(true);
        
        
    }
    
    public void createPausePanel(HomeScreen homeFrame){
//        JButton resume = new JButton("Resume");
//        resume.addActionListener(new ResumeListener());
//        
        JButton restart = new JButton("Restart");
        restart.addActionListener(new RestartListener(this.level, homeFrame));
        
        JButton homeScreen = new JButton("HomeScreen");
        homeScreen.addActionListener(new HomeScreenListener(this, homeFrame));
        
        pausePanel = new JPanel();
        pausePanel.setLayout(new GridLayout(3,1));
//        pausePanel.add(resume);
        pausePanel.add(restart);
        pausePanel.add(homeScreen);
        add(pausePanel);
    }
    
    public void createMessageBoard(){
        label = new JLabel("\"p\": toggle het pauseMenu.");
        messagePanel = new JPanel();
        messagePanel.add(label);
    }
    
    class KeyListener1 implements KeyListener {   
        private JFrame frame;
        private HomeScreen homeScreen;
        private boolean paused;
        
        public KeyListener1(JFrame frame, HomeScreen homeScreen) {
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
            label.setText("\"p\": toggle het pauseMenu.");
            //determine field coordinates of player
            int i = levelCopy.getPlayer().getY()/fieldSize;
            int j = levelCopy.getPlayer().getX()/fieldSize;
            
            //pause/unpause the game
            if(e.getKeyCode() == KeyEvent.VK_PAUSE ||e.getKeyCode() == KeyEvent.VK_P){
                paused = !paused;
                component.setVisible(!paused);
                pausePanel.setVisible(paused);
                System.out.println();
                
                label.setText("pause key pressed " + paused + '.');//notify player
            }
            
            if(component.isVisible()){//disable walking if game is paused
                //walk up
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    if(levelCopy.getPlayer().getY() > 0 ){
                        if(fields[i-1][j].canMoveThru()) {
                            levelCopy.getPlayer().move(0, -fieldSize);
                            i--;
                        }else{
                           checkIfBaricadeCanOpen(i-1,j); 
                        }
                    }
                }
                //walk left
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if(levelCopy.getPlayer().getX() > 0 ){
                        if(fields[i][j-1].canMoveThru()) {
                            levelCopy.getPlayer().move(-fieldSize, 0);
                            j--;
                        }else{
                           checkIfBaricadeCanOpen(i,j-1); 
                        }
                    }
                }
                //walk down
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    if(levelCopy.getPlayer().getY() < (fieldSize * (gameFieldSize-1)) ){
                        if(fields[i+1][j].canMoveThru()) {
                            levelCopy.getPlayer().move(0, +fieldSize);
                            i++;
                        }else{
                           checkIfBaricadeCanOpen(i+1,j); 
                        }
                    }
                }
                //walk right
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if(levelCopy.getPlayer().getX() < (fieldSize * (gameFieldSize-1)) ){
                        if(fields[i][j+1].canMoveThru()) {
                            levelCopy.getPlayer().move(+fieldSize, 0);
                            j++;
                        }else{
                           checkIfBaricadeCanOpen(i,j+1); 
                        }
                    }
                }
            }
            
            checkIfWalkWayHasKey(i, j);
            checkIfEndFieldFound(i, j);
            
            component.repaint();
        }
        //checks if the field the player is standing on has a key
        //and if it does, calls the pickUpKey method in player
        private void checkIfWalkWayHasKey(int i, int j) {
            if(fields[i][j] instanceof WalkWay){//make sure it's possible for the current field to have a key
                WalkWay currentField = (WalkWay) fields[i][j];
                if(currentField.isHasKey()){
                    label.setText(levelCopy.getPlayer().pickUpKey(currentField)+".");
                }
            }
        }
        
        private void checkIfBaricadeCanOpen(int i, int j) {
            if(fields[i][j] instanceof Barricade){
                Barricade currentField = (Barricade) fields[i][j];
                if(!currentField.open()) {
                    label.setText(currentField.keyFits(levelCopy.getPlayer().getKey())+".");
                }
            }
        }
        
        private void checkIfEndFieldFound(int i, int j) {
            if(fields[i][j] instanceof EndField){
                EndField currentField = (EndField) fields[i][j];
                
                levelCopy.setGehaald(true);
                
                homeScreen.setVisible(true);
                homeScreen.checklevels();
                
                frame.dispose();
            }
        }
    }
    
    
    class ResumeListener implements ActionListener{
        private boolean paused;
        
        public ResumeListener() {
            paused = true;
        }
        
        @Override
        public void actionPerformed(ActionEvent event){
            paused = !paused;
            component.setVisible(!paused);
            pausePanel.setVisible(paused);
            
            label.setText("pause key pressed " + paused + ".");//notify player
        }
    }
    
    
    class RestartListener implements ActionListener{
        private JFrame frame;
        private HomeScreen homeScreen;
        private Level currentLevel;
        
        public RestartListener(Level currentLevel, HomeScreen homeScreen) {
            this.currentLevel = currentLevel;
            this.homeScreen = homeScreen;
        }
        
        @Override
        public void actionPerformed(ActionEvent event){
            JFrame restartFrame = new GameFieldViewer(currentLevel,homeScreen);
            restartFrame.setVisible(true);
            restartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.setVisible(false);
        }
    }
    
    
    class HomeScreenListener implements ActionListener{
        private JFrame frame;
        private JFrame homeScreen;
        
        public HomeScreenListener(JFrame frame, JFrame homeScreen) {
            this.frame = frame;
            this.homeScreen = homeScreen;
        }
        
        @Override
        public void actionPerformed(ActionEvent event){
            homeScreen.setVisible(true);
            frame.dispose();
        }
    }
}