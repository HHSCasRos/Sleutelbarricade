package sleutelbarricade;

public class Level {
    private String idLevel;
    private boolean paused;
    private float time;
    private int niveau;//1=low, 2=medium, 3=high
    
    public Level(String idLevel, int niveau) {
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

    public String getIdLevel() {
        return idLevel;
    }
    
}