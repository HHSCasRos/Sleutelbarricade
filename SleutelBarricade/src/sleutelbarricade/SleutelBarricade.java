package sleutelbarricade;

import java.util.ArrayList;
import javax.swing.JFrame;

public class SleutelBarricade {
    
    public static void main(String[] args) {
        ArrayList<Level> levels = new ArrayList();
        
        //tutorial level
        Level tutorial = new Level("Tutorial", 0);
        Key tutorialKey1 = new Key(100);
        Field[][] tutorialField = new Field[tutorial.getGameFieldSize()][tutorial.getGameFieldSize()];
        for(int i = 0; i < tutorialField.length; i++){
            for(int j = 0; j < tutorialField.length; j++){
                if(j == 1 && i == 1){
                    tutorialField[i][j] = new Barricade(100);
                }else if(i == 2 && j == 0) {
                    tutorialField[i][j] = new WalkWay(tutorialKey1);
                }else if(i == 2 && j == 2) {
                    tutorialField[i][j] = new EndField();
                }else if(j == 1 && i == 0 || i == 2){
                    tutorialField[i][j] = new Wall();
                }else{
                    tutorialField[i][j] = new WalkWay();
                }
            }
        }
        createField(tutorialField);
        
        tutorial.setGameField(tutorialField);
        levels.add(tutorial);
        
        
        //level 1
        Level level1 = new Level("Level 1", 2);
        Key level1key1 = new Key(100);
        Key level1key2 = new Key(300);
        Key level1key3 = new Key(100);
        Key level1key4 = new Key(200);
        Field[][] Level1Field = new Field[level1.getGameFieldSize()][level1.getGameFieldSize()];
        for(int i = 0; i < Level1Field.length; i++){
            for(int j = 0; j < Level1Field.length; j++){
                if((i != 1 && i != 2) && j == 1){//row 2
                    if(i == 5){
                        Level1Field[i][j] = new Barricade(200);
                    } else {
                        Level1Field[i][j] = new Wall();
                    }
                    
                }else if(i != 1 && j == 2){// row 3
                    Level1Field[i][j] = new Barricade(100);
                    
                }else if((i == 4 || i==6 || i==7 || i==8 || i==9) && j == 3){//row 4
                    if(i == 4){
                        Level1Field[i][j] = new Barricade(100);
                    } else if(i == 6){
                        Level1Field[i][j] = new Wall();
                    } else if(i == 7){
                        Level1Field[i][j] = new Barricade(900);
                    } else if(i == 8){
                        Level1Field[i][j] = new Barricade(50);
                    } else if(i == 9){
                        Level1Field[i][j] = new Barricade(150);
                    }
                    
                }else if((i == 4 || i==6 || i==7) && j == 4){//row 5
                    if(i == 4 || i == 6){
                        Level1Field[i][j] = new Wall();
                    } else if(i == 7){
                        Level1Field[i][j] = new Barricade(500);
                    }
                    
                }else if((i == 4 || i==6 || i==7) && j == 5){//row 6
                    if(i == 4){
                        Level1Field[i][j] = new Wall();
                    } else if(i == 6){
                        Level1Field[i][j] = new Barricade(300);
                    } else if(i == 7){
                        Level1Field[i][j] = new Barricade(100);
                    }
                    
                }else if((i == 4 || i == 5 || i == 6) && j == 6){//row 7
                    Level1Field[i][j] = new Wall();
                    
                }else if(i != 7 && j == 7){//row 8
                    if(i == 0){
                        Level1Field[i][j] = new Barricade(30);
                    } else if(i == 1){
                        Level1Field[i][j] = new Barricade(90);
                    } else if(i == 2){
                        Level1Field[i][j] = new Barricade(300);
                    } else if(i == 3){
                        Level1Field[i][j] = new Barricade(190);
                    } else if(i == 4){
                        Level1Field[i][j] = new Barricade(220);
                    } else if(i == 5){
                        Level1Field[i][j] = new Barricade(100);
                    } else if(i >= 6){
                        Level1Field[i][j] = new Wall();
                    }
                    
                }else if(i <= 5 && j == 8){//row 9
                    if(i == 0){
                        Level1Field[i][j] = new Barricade(70);
                    } else if(i == 1){
                        Level1Field[i][j] = new Barricade(40);
                    } else if(i == 2){
                        Level1Field[i][j] = new Barricade(300);
                    } else if(i == 3){
                        Level1Field[i][j] = new Barricade(80);
                    } else if(i == 4){
                        Level1Field[i][j] = new Barricade(100);
                    } else if(i == 5){
                        Level1Field[i][j] = new Barricade(360);
                    }
                    
                }else if((i == 0 || i == 1 || i == 3 || i == 4) && j == 9){//row 10
                    if(i < 4){
                        Level1Field[i][j] = new Barricade(90);
                    } else if(i == 4){
                        Level1Field[i][j] = new Barricade(50);
                    }
                    
                }else if(i == 1 && j == 4) {//place all the key
                    Level1Field[i][j] = new WalkWay(level1key1);
                }else if(i == 1 && j == 5) {
                    Level1Field[i][j] = new WalkWay(level1key2);
                }else if(i == 2 && j == 9) {
                    Level1Field[i][j] = new WalkWay(level1key3);
                }else if(i == 8 && j == 0) {
                    Level1Field[i][j] = new WalkWay(level1key4);
                }else if(i == 9 && j == 9) {//place end field
                    Level1Field[i][j] = new EndField();
                }else{
                    Level1Field[i][j] = new WalkWay();
                }
            }
        }
        createField(Level1Field);
        
        level1.setGameField(Level1Field);
        levels.add(level1);
        
        
        levels.add(new Level("Level 2", 1));
        
        JFrame frame = new HomeScreen(levels);
        
        frame.setTitle("Home Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }
    
    //set drawing positions
    private static void createField(Field[][] field) {
        for(int i=0; i < field.length; i++){
            int j = 0;
            field[i][j].setX(0);
            field[i][j].setY(i * field[i][j].getSize());
            for(j=0; j<field.length; j++){
                field[i][j].setX(j * field[i][j].getSize());
                field[i][j].setY(i * field[i][j].getSize());
            }
        }
    }
}