package sleutelbarricade;

public class Level {
    private final String idLevel;
    private boolean paused;
    private float time;
    private final int niveau;//1=low, 2=medium, 3=high
    private Field[][] fields;
    private int gameFieldSize;
    
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
                gameFieldSize = 2;
                fields = new Field[gameFieldSize][gameFieldSize];
                break;
        }
        this.idLevel = idLevel;
        this.niveau = niveau;
        this.paused = false;
    }
    
    public void setGameField(Field[][] fields) {
        this.fields = fields;
        for(int i = 0; i < gameFieldSize; i++){
            for(int j = 0; j < gameFieldSize; j++){
                fields[i][j] = new WalkWay();
            }
        }
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
}