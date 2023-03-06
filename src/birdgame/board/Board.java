package birdgame.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {
        private Tile fristSelected;
        private Tile secondSelected;

        private final Tile [][] tiles;
        ArrayList<ArrayList<Tile>> tileList;
        public Board(int xSize, int ysize){
                tiles=new Tile[xSize][ysize];

                for (int i = 0; i < tiles.length; i++) {
                        for (int j = 0; j < tiles[i].length; j++) {
                                tiles[i][j]=new Tile(i,j);
                        }
                }
                ArrayList<ArrayList<Tile>> tileList=new ArrayList<ArrayList<Tile>>() ;
                for (int i = 0; i < tiles.length; i++) {
                        tileList.add(i,new ArrayList<>(Arrays.asList(tiles[i])));
                }
        }
        private void select (int x, int y){
                if(isfirstsecletion()){
                        fristSelected=tiles[x][y];
                }else {
                        if(Math.abs(fristSelected.getIndexX()-x)==1&fristSelected.getIndexY()==y ||
                                Math.abs(fristSelected.getIndexY()-y)==1&fristSelected.getIndexX()==x    ){
                                secondSelected=tiles[x][y];
                        }
                        else {
                                fristSelected=tiles[x][y];
                        }
                }

        }
        private boolean isfirstsecletion(){
                return fristSelected==null;
        }



        private void swap(Tile fristSelected,Tile secondSelected){
                BoardAnimals animals1=fristSelected.getSpotAnimal();
                BoardAnimals animals2=secondSelected.getSpotAnimal();
                BoardBlockers blockers1=fristSelected.getBoardBlocker();
                BoardBlockers blockers2=secondSelected.getBoardBlocker();
                AnimalModifyer modifyer1=fristSelected.getAnimalModifyer();
                AnimalModifyer modifyer2=secondSelected.getAnimalModifyer();
                fristSelected.setSpotAnimal(animals2);
                fristSelected.setAnimalModifyer(modifyer2);
                fristSelected.setBoardBlocker(blockers2);
                secondSelected.setSpotAnimal(animals1);
                secondSelected.setAnimalModifyer(modifyer1);
                secondSelected.setBoardBlocker(blockers1);
        }


        private int howmanyinarowUD(int x, int y){
                int result=1;
                BoardAnimals animals=tiles[x][y].getSpotAnimal();

                for (int i = x+1; i < tiles.length; i++) {
                       if(tiles[i][y].getSpotAnimal().equals(animals)){
                               result++;

                       }else {
                               break;
                       }
                }
                for (int i = x-1; i > -1; i--) {
                        if(tiles[i][y].getSpotAnimal().equals(animals)){
                                result++;
                        }   else {break;}
                }

                return result;



        }

        private int howmanyinarowLR(int x, int y){
                int result=1;
                BoardAnimals animals=tiles[x][y].getSpotAnimal();

                for (int j = y+1; j < tiles[x].length; j++) {
                        if(tiles[x][j].getSpotAnimal().equals(animals)){
                                result++;
                        }
                }
                for (int j = y-1; j > -1; j--) {
                        if(tiles[x][j].getSpotAnimal().equals(animals)){
                                result++;
                        }
                }

                return result;

        }

        private boolean shouldclear(){
                if(fristSelected.getAnimalModifyer()!=AnimalModifyer.NONE
                        &&secondSelected.getAnimalModifyer()!=AnimalModifyer.NONE){
                        return true;
                }

                int fLR=howmanyinarowLR(fristSelected.getIndexX(),fristSelected.getIndexY());
                int fUD=howmanyinarowUD(fristSelected.getIndexX(),fristSelected.getIndexY());

                if(fLR>=3||fUD>=3){
                        return true;
                }

                int sLR =howmanyinarowLR(secondSelected.getIndexX(),secondSelected.getIndexY());
                int sUD=howmanyinarowUD(secondSelected.getIndexX(),secondSelected.getIndexY());
                if(sLR>=3||sUD>=3){
                        return true;
                }
                return false;
        }

        private void clear1(){
                if(fristSelected.getAnimalModifyer()!=AnimalModifyer.NONE
                        &&secondSelected.getAnimalModifyer()!=AnimalModifyer.NONE){
                        if(fristSelected.getAnimalModifyer().equals(AnimalModifyer.uPDown)){
                            tileList.remove(tileList.get(fristSelected.getIndexY()));
                        }else if(fristSelected.getAnimalModifyer().equals(AnimalModifyer.leftRight)){
                                tileList.remove(tileList.get(fristSelected.getIndexX()));

                        }else if(secondSelected.getAnimalModifyer().equals(AnimalModifyer.uPDown)){
                                tileList.remove(tileList.get(fristSelected.getIndexY()));
                        }else if(secondSelected.getAnimalModifyer().equals(AnimalModifyer.leftRight)){
                                tileList.remove(tileList.get(fristSelected.getIndexX()));
                        }

                }



        }
        private void clear2(){
                int fLR=    howmanyinarowLR(fristSelected.getIndexX(),fristSelected.getIndexY());

                int fUD=howmanyinarowUD(fristSelected.getIndexX(),fristSelected.getIndexY());


                int sLR =howmanyinarowLR(secondSelected.getIndexX(),secondSelected.getIndexY());
                int sUD=howmanyinarowUD(secondSelected.getIndexX(),secondSelected.getIndexY());

        }



//        private void fall (){
////            uses makeFalllist... adds removes the peice it has done and adds back new Locations
//        }
//        private List<Tile> makeFallList(){ //Locations is NOT TILES it is an XY PAIR or a  X1Y1X2Y2 pair...
////            //makes a list and adds a xy pair if there is a empty spot with a piece above it or the in side fall actions
////            like
////                    H
////            FB             HB
////            B                F
////            BX   ->      BB
////        }
//        public void doLogic(){
////            use most to all methods above
//        }
}


