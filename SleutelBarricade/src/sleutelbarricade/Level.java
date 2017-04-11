package sleutelbarricade;

public class Level {
    private final String idLevel;
    private boolean paused;
    private float time;
    private final int niveau;//1=low, 2=medium, 3=high
    private Field[][] fields;
    private int gameFieldSize;
    private Player player;
    private boolean gehaald;
    
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
        this.gehaald = false;
    }
    
    public void setGameField(Field[][] fields) {
        this.fields = new Field[gameFieldSize][gameFieldSize];
        
        for(int i = 0; i < gameFieldSize; i++){
            for(int j = 0; j < gameFieldSize; j++){
                if(fields[i][j] instanceof WalkWay){
                    WalkWay currentField = (WalkWay)fields[i][j];
                    if(currentField.isHasKey()){
                        this.fields[i][j] = new WalkWay(currentField.getKey());
                    }else
                        this.fields[i][j] = new WalkWay();
                }else if(fields[i][j] instanceof EndField){
                    this.fields[i][j] = fields[i][j];
                }else if(fields[i][j] instanceof Barricade){
                    Barricade currentField = (Barricade)fields[i][j];
                    this.fields[i][j] = new Barricade(currentField.getIdCode());
                }else{
                    this.fields[i][j] = new Wall();
                }
            } 
        }
        
        for(int i=0; i < gameFieldSize; i++){
            int j = 0;
            this.fields[i][j].setX(0);
            this.fields[i][j].setY(i * this.fields[i][j].getSize());
            for(j=0; j<gameFieldSize; j++){
                this.fields[i][j].setX(j * this.fields[i][j].getSize());
                this.fields[i][j].setY(i * this.fields[i][j].getSize());
            }
        }
    }
    
    public Field[][] getGameField(){
        return fields;
    }
    
    public void pauseGame(){
        paused = true;
    }
    public void resumeGame() {
        paused = false;
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
    
    public boolean isGehaald() {
        return gehaald;
    }
    public void setGehaald(boolean gehaald) {
        this.gehaald = gehaald;
    }
    
    public int getNiveau(){
        return niveau;
    }
}