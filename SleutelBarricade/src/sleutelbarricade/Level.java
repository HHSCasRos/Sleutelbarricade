package sleutelbarricade;

public class Level {
    private final String idLevel;
    private boolean paused;
    private float time;
    private final int niveau;//1=low, 2=medium, 3=high
    private Field[][] fields;
    private int gameFieldSize;
    private Player player;
    
    public Level(String idLevel, int niveau) {
        switch(niveau) {
            case 1: 
                gameFieldSize = 5;
                fields = new Field[gameFieldSize][gameFieldSize];
                break;
            case 2:
                gameFieldSize = 10;
                fields = new Field[gameFieldSize][gameFieldSize];
                break;
            case 3:
                gameFieldSize = 15;
                fields = new Field[gameFieldSize][gameFieldSize];
                break;
            default :
                gameFieldSize = 3;
                fields = new Field[gameFieldSize][gameFieldSize];
                break;
        }
        this.idLevel = idLevel;
        this.niveau = niveau;
        this.paused = false;
        this.player = new Player(0,0);
    }
    
    public void setGameField(Field[][] fields) {
        this.fields = fields;
    }
    
    public Field[][] getGameField(){
        return fields;
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
    
    
    public int getGameFieldSize() {
        return this.gameFieldSize;
    }
    
    public Player getPlayer() {
        return player;
    }
}