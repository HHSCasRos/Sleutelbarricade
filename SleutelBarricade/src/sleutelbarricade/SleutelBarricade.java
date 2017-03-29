package sleutelbarricade;

import javax.swing.JFrame;

public class SleutelBarricade {
    
    public static void main(String[] args) {
        JFrame frame = new HomeScreen();
        
        frame.setTitle("Home Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }
}