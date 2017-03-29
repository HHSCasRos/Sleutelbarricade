package sleutelbarricade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class HomeScreen extends JFrame{
    private HomeComponent component;
    
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;
    
    private ArrayList<JButton> button;
    
    public HomeScreen() {
        this.component = new HomeComponent();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        for(int i = 0; i < 3; i++){
            button.add(new JButton("Level " + i));

            ActionListener listener = new AddInterestListener();
            button.get(i).addActionListener(listener);
        }
        
        
        add(component);
    }
    class AddInterestListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            
        }
    }
}