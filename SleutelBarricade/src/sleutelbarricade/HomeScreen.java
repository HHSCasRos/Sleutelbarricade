package sleutelbarricade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeScreen extends JFrame{
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;
    
    //interface elements
    private final ArrayList<JButton> button;
    private ArrayList<ActionListener> listener;
    private final int amountOfLevels;
    
    public HomeScreen(int amountOfLevels) {
        this.amountOfLevels = amountOfLevels;
        
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        //create all buttons
        this.button = new ArrayList();
        
        button.add(new JButton("Tutorial"));
        
        for(int i = 1; i <= this.amountOfLevels; i++){
            button.add(new JButton("" + i));

            listener.add(new LevelSelectListener(i));
            button.get(i).addActionListener(listener.get(i));
        }
        
        createPanel();
    }
    
    class LevelSelectListener implements ActionListener{
        private int idLevel;
        public LevelSelectListener(int idLevel) {
            this.idLevel = idLevel;
        }
        
        @Override
        public void actionPerformed(ActionEvent event){
            JFrame level = new GameFieldViewer(idLevel);
            
        }
    }
    
    //adds all buttons to panel
    private void createPanel() {
        JPanel panel = new JPanel();
        
        for(int i = 0; i < button.size(); i++){
            panel.add(button.get(i));
        }
        
        add(panel);
    }
}