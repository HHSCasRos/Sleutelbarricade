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
    private ArrayList<Level> levels;
    private final int amountOfLevels;
    
    public HomeScreen(ArrayList<Level> levels) {
        this.amountOfLevels = levels.size();
        this.levels = levels;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        //create all buttons
        this.button = new ArrayList();
        this.listener = new ArrayList();
        
        for(int i = 0; i < this.amountOfLevels; i++){
            button.add(new JButton(levels.get(i).getIdLevel()));

            listener.add(new LevelSelectListener(levels.get(i).getIdLevel(),this));
            button.get(i).addActionListener(listener.get(i));
        }
        
        createPanel();
    }
    
    class LevelSelectListener implements ActionListener{
        private String idLevel;
        private JFrame frame;
        public LevelSelectListener(String idLevel , JFrame f) {
            this.idLevel = idLevel;
            this.frame = f;
        }
       
        @Override
        public void actionPerformed(ActionEvent event){
            JFrame level = new GameFieldViewer(levels.get(0));
            level.setVisible(true);
            level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.dispose();
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