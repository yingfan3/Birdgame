package birdgame.board;



public class Tile  {
    private BoardAnimals spotAnimal;
    private BoardBlockers boardBlocker;
    private AnimalModifyer animalModifyer;
    private boolean mark;
    private int indexX;
    private int indexY;

    public int getIndexY() {
        return indexY;
    }

    public void setIndexY(int indexY) {
        this.indexY = indexY;
    }

    public int getIndexX() {
        return indexX;
    }

    public void setIndexX(int indexX) {
        this.indexX = indexX;
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


    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    public Tile(int indexX, int indexY){
        this.indexX=indexX;
        this.indexY=indexY;
        this.spotAnimal= BoardAnimals.NONE;
        this.boardBlocker= BoardBlockers.NONE;
        this.animalModifyer= AnimalModifyer.NONE;
        this.mark=false;
    }

    @Override
    public String toString() {
        return " "+spotAnimal.anmial+"-"+boardBlocker.blocker
                +"-"+animalModifyer.superpower+" ";
    }
}


