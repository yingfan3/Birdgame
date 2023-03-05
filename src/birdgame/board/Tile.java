package birdgame.board;

public class Tile {
    private BoardAnimals spotAnimal;
    private BoardBlockers boardBlocker;
    private AnimalModifyer animalModifyer;
    private int locationX,locationY;
    private int height;

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

    public AnimalModifyer getAnimalModifyer() {
        return animalModifyer;
    }

    public void setAnimalModifyer(AnimalModifyer animalModifyer) {
        this.animalModifyer = animalModifyer;
    }

    public BoardBlockers getBoardBlocker() {
        return boardBlocker;
    }

    public void setBoardBlocker(BoardBlockers boardBlocker) {
        this.boardBlocker = boardBlocker;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Tile(int x , int y, int height, BoardAnimals spotAnimal, BoardBlockers boardBlocker, AnimalModifyer animalModifyer){
        this.locationX=x;
        this.locationY=y;
        this.height=height;
        this.spotAnimal=spotAnimal;
        this.boardBlocker= boardBlocker;
        this.animalModifyer=animalModifyer;

    }




}


