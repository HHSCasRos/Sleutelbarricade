package gamefieldtest;



public class WalkField extends Field{
    private boolean hasKey;
    private Key key;
    
    public WalkField() {
    
    }
    
    public WalkField(Key k) {
        hasKey = true;
        key = k;
    }
    
    @Override
    public void checkPlayer(Player p) {
        super.checkPlayer(p);
    }
}
