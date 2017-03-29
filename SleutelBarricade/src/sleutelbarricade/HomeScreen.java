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
    private ArrayList<JButton> button;
    private int amountOfLevels;
    
    public HomeScreen() {
        this.amountOfLevels = 3;
        
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        //create all buttons
        this.button = new ArrayList();
        for(int i = 0; i < amountOfLevels; i++){
            button.add(new JButton("Level " + (i + 1)));

            ActionListener listener = new AddInterestListener();
            button.get(i).addActionListener(listener);
        }
        
        createPanel();
    }
    
    class AddInterestListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            
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