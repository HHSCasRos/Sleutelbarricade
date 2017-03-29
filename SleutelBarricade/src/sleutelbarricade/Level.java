package sleutelbarricade;

public class Level {
    private int idLevel;
    private boolean paused;
    private float time;
    private String niveau;
    
    public Level(int idLevel, String niveau) {
        this.idLevel = idLevel;
        this.niveau = niveau;
        this.paused = false;
    }
    
    public void start() {
        
    }
    public void pauseGame(){
        paused = true;
    }
    public void resumeGame() {
        paused = false;
    }
    public void reStart(){
        
    }
}