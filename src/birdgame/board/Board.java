package birdgame.board;

public class Board {
    private Tile tile;
    private static Tile [][] tiles;
    public  Board(Tile tile){
        this.tile=tile;

    }
    static boolean exist (Tile tile){
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if(tile.equals(tiles[i][j])){
                    return true;
                }
            }

        }
        return false;
    }

    public boolean select(Tile tile){
        this.tile=tile;
        if(exist(tile)){
            return true;
        }
        return false;
    }
    public void swap(Tile tile, Tile curTile){
        BoardAnimals animals1=tile.getSpotAnimal();
        BoardAnimals animals2=curTile.getSpotAnimal();
        if(select(tile) &&select(curTile)){
            if((tile.getLocationX()+ tile.getHeight()==curTile.getLocationX() ||tile.getLocationY()+ tile.getHeight()==curTile.getLocationY()||curTile.getLocationX()+curTile.getHeight()==tile.getLocationX()||curTile.getLocationY()+curTile.getHeight()==tile.getLocationY())){
                if(tile.equals(curTile)){}
                else{curTile.setBoardBlocker(tile.getBoardBlocker());
                    curTile.setAnimalModifyer(tile.getAnimalModifyer());
                    curTile.setSpotAnimal(tile.getSpotAnimal());
                    tile.setBoardBlocker(curTile.getBoardBlocker());
                    tile.setAnimalModifyer(curTile.getAnimalModifyer());
                    tile.setSpotAnimal(curTile.getSpotAnimal());
                }

            }
        }
    }
    public void clearandfill(){
        int n=tiles.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j <n-1 ; j++) {
                if(tiles[i-1][j].getSpotAnimal().equals(tiles[i][j].getSpotAnimal())&tiles[i][j].getSpotAnimal().equals(tiles[i+1][j].getSpotAnimal()) ){
                    while (i<n-3){
                        tiles[i-1][j]=tiles[i+2][j];
                        i++;
                    }
                    tiles[n-3][j].setSpotAnimal(BoardAnimals.getAnimal());
                    tiles[n-3][j].setBoardBlocker(BoardBlockers.NONE);
                    tiles[n-3][j].setAnimalModifyer(AnimalModifyer.none);
                    tiles[n-2][j].setSpotAnimal(BoardAnimals.getAnimal());
                    tiles[n-2][j].setBoardBlocker(BoardBlockers.NONE);
                    tiles[n-2][j].setAnimalModifyer(AnimalModifyer.none);
                    tiles[n-1][j].setSpotAnimal(BoardAnimals.getAnimal());
                    tiles[n-1][j].setBoardBlocker(BoardBlockers.NONE);
                    tiles[n-1][j].setAnimalModifyer(AnimalModifyer.none);
                }else if(tiles[i][j-1].getSpotAnimal().equals(tiles[i][j].getSpotAnimal())&tiles[i][j].getSpotAnimal().equals(tiles[i][j+1].getSpotAnimal()) ){
                    while (i<n-3){
                        tiles[i][j-1]=tiles[i][j+2];
                        j++;
                    }
                    tiles[i][j-3].setSpotAnimal(BoardAnimals.getAnimal());
                    tiles[i][j-3].setBoardBlocker(BoardBlockers.NONE);
                    tiles[i][j-3].setAnimalModifyer(AnimalModifyer.none);
                    tiles[i][j-2].setSpotAnimal(BoardAnimals.getAnimal());
                    tiles[i][j-2].setBoardBlocker(BoardBlockers.NONE);
                    tiles[i][j-2].setAnimalModifyer(AnimalModifyer.none);
                    tiles[i][j-1].setSpotAnimal(BoardAnimals.getAnimal());
                    tiles[i][j-1].setBoardBlocker(BoardBlockers.NONE);
                    tiles[i][j-1].setAnimalModifyer(AnimalModifyer.none);
                }
            }
        }

    }





}


