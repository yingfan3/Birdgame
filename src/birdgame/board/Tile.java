package birdgame.board;

public class Tile {
    private BoardAnimals spotAnimal;
    private BoardBlockers boardBlocker;
    private AnimalModifyer animalModifyer;
    private int locationX,locationY;
    Boolean isalive=true;

    public void setLocationX(int x) {
        this.locationX = x;
    }
    public void setLocationY(int y) {
        this.locationY = y;
    }
    public int getLocationX(){
        return locationX;
    }
    public int getLocationY(){
        return locationY;
    }
    public void setSpotAnimal(BoardAnimals spotAnimal) {
        this.spotAnimal = spotAnimal;
    }
    public BoardAnimals getSpotAnimal(){
        return spotAnimal;
    }

    public Tile(int x , int y, BoardAnimals spotAnimal){
        this.locationX=x;
        this.locationY=y;
        this.spotAnimal=spotAnimal;
        if (x>500 || y>500){
            isalive=false;
        }
    }

    public static void move(Tile tile, Tile curTile){
        int X=tile.getLocationX();
        int Y=tile.getLocationX();
        int X1=curTile.getLocationX();
        int Y1=curTile.getLocationY();
        BoardAnimals animals1=tile.getSpotAnimal();
        BoardAnimals animals2=curTile.getSpotAnimal();
        if (tile.spotAnimal==curTile.spotAnimal){

        }else if(X==X1){
            tile.setLocationY(Y1);
            curTile.setLocationY(Y);

        }else if(Y==Y1){
            tile.setLocationX(X1);
            curTile.setLocationX(X);

        }

    }



}


