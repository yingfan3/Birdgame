package birdgame.board;

public class Board {
    private Tile tile;
    private Tile fristSelected;
    private Tile secondSelected;
    private int fx,fy,sx,sy;
    private static Tile [][] tiles=new Tile[4][4];


    private boolean select (Tile tile){
//not finished!!!!
        if(tile.getIndexX()<tiles.length&&tile.getIndexY()<tiles.length){
            return true;
        }
        return false;
        }

    public void swap(Tile fristSelected, Tile secondSelected){

        if(select(fristSelected) &&select(secondSelected)){
            if((fristSelected.getIndexX()+ 1==secondSelected.getIndexX() ||fristSelected.getIndexY()+ 1==secondSelected.getIndexY()||secondSelected.getIndexX()+1==fristSelected.getIndexX()||secondSelected.getIndexY()+1==fristSelected.getIndexY())){
                if(fristSelected.equals(secondSelected)){}
                else{secondSelected.setBoardBlocker(fristSelected.getBoardBlocker());
                    secondSelected.setAnimalModifyer(fristSelected.getAnimalModifyer());
                    secondSelected.setSpotAnimal(fristSelected.getSpotAnimal());
                    fristSelected.setBoardBlocker(secondSelected.getBoardBlocker());
                    fristSelected.setAnimalModifyer(secondSelected.getAnimalModifyer());
                    fristSelected.setSpotAnimal(secondSelected.getSpotAnimal());
                }

            }
        }

    }


    public int clear(){
        int n=tiles.length;
//        clear row
        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j <tiles[i].length-1; j++) {
                if(tiles[i][j-1].getSpotAnimal().equals(tiles[i][j].getSpotAnimal())&tiles[i][j].getSpotAnimal().equals(tiles[i][j+1].getSpotAnimal()) ){
                    while (i<n-3){
                        tiles[i][j]=tiles[i][j+2];
                        i++;
                    }
//
                    return 1;
                }
//                clear column
//                else if(tiles[i][j-1].getSpotAnimal().equals(tiles[i][j].getSpotAnimal())&tiles[i][j].getSpotAnimal().equals(tiles[i][j+1].getSpotAnimal()) ){
//                    while (i<n-3){
//                        tiles[i][j-1]=tiles[i][j+2];
//                        j++;
//                    }
//
//                    return 2;
//                }
            }
        }
        return 0;

    }
    public void fall(Tile tile){
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
//
//        private void swap(){
////also very simple
//        }
//        private int clear(){
//            make this into the 4 +cases.... aka make methods for each DO NOOOT PUT IT ALL IN THIS METHOD
//            if stament
//                    metod
//            if stament
//                    method
//            if stament
//            method...
//        }
//        private void fall (){
//            uses makeFalllist... adds removes the peice it has done and adds back new Locations
//        }
//        private list<Locations> makeFallList(){ //Locations is NOT TILES it is an XY PAIR or a  X1Y1X2Y2 pair...
//            //makes a list and adds a xy pair if there is a empty spot with a piece above it or the in side fall actions
//            like
//                    H
//            FB             HB
//            B                F
//            BX   ->      BB
//        }
//        public void doLogic(){
//            use most to all methods above
//        }



}


