package birdgame.board;

public class Board {
    private Tile tile;
    private static Tile [][] tiles=new Tile[6][6];
//    public  Board(Tile tile){
//        this.tile=tile;
//
//    }
    static boolean select (Tile tile){

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if(tile.equals(tiles[i][j])){
                    return true;
                }
            }

        }
        return false;
    }


    public static void swap(Tile tile, Tile curTile){

        if(select(tile) &&select(curTile)){
            if((tile.getIndexX()+ 1==curTile.getIndexX() ||tile.getIndexY()+ 1==curTile.getIndexY()||curTile.getIndexX()+1==tile.getIndexX()||curTile.getIndexY()+1==tile.getIndexY())){
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
    public int clear(){
        int n=tiles.length;
//        clear row
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j <n-1 ; j++) {
                if(tiles[i-1][j].getSpotAnimal().equals(tiles[i][j].getSpotAnimal())&tiles[i][j].getSpotAnimal().equals(tiles[i+1][j].getSpotAnimal()) ){
                    while (i<n-3){
                        tiles[i-1][j]=tiles[i+2][j];
                        i++;
                    }

                    return 1;
                }
//                clear column
                else if(tiles[i][j-1].getSpotAnimal().equals(tiles[i][j].getSpotAnimal())&tiles[i][j].getSpotAnimal().equals(tiles[i][j+1].getSpotAnimal()) ){
                    while (i<n-3){
                        tiles[i][j-1]=tiles[i][j+2];
                        j++;
                    }

                    return 2;
                }
            }
        }
        return 0;

    }
    public void fill (Tile tile){
        int i=tile.getIndexX();
        int j=tile.getIndexY();
        while (clear()==1){
            tiles[i-3][j].setSpotAnimal(BoardAnimals.getAnimal());
            tiles[i-3][j].setBoardBlocker(BoardBlockers.NONE);
            tiles[i-3][j].setAnimalModifyer(AnimalModifyer.none);
            tiles[i-2][j].setSpotAnimal(BoardAnimals.getAnimal());
            tiles[i-2][j].setBoardBlocker(BoardBlockers.NONE);
            tiles[i-2][j].setAnimalModifyer(AnimalModifyer.none);
            tiles[i-1][j].setSpotAnimal(BoardAnimals.getAnimal());
            tiles[i-1][j].setBoardBlocker(BoardBlockers.NONE);
            tiles[i-1][j].setAnimalModifyer(AnimalModifyer.none);

        }
        while (clear()==2){
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


