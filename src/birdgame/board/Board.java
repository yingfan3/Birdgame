package birdgame.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {
        private Tile fristSelected;
        private Tile secondSelected;

        private final Tile [][] tiles;

        public Board(int xSize, int ysize){
                tiles=new Tile[xSize][ysize];

                for (int i = 0; i < tiles.length; i++) {
                        for (int j = 0; j < tiles[i].length; j++) {
                                tiles[i][j]=new Tile(i,j);
                        }
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


        private int howmanyinarowU(int x, int y){
                int result=1;
                BoardAnimals animals=tiles[x][y].getSpotAnimal();

                for (int i = x-1; i > -1; i--) {
                        if(tiles[i][y].getSpotAnimal().equals(animals)){
                                result++;
                        }   else {break;}
                }

                return result;

        }
        private int howmanyinarowD(int x, int y){
                int result=1;
                BoardAnimals animals=tiles[x][y].getSpotAnimal();

                for (int i = x+1; i < tiles.length; i++) {
                        if(tiles[i][y].getSpotAnimal().equals(animals)){
                                result++;

                        }else {
                                break;
                        }
                }


                return result;

        }

        private int howmanyinarowL(int x, int y){
                int result=0;

                BoardAnimals animals=tiles[x][y].getSpotAnimal();

                for (int j = y-1; j > -1; j--) {
                        if(tiles[x][j].getSpotAnimal().equals(animals)){
                                result++;
                        }else {
                                break;
                        }
                }

                return result;

        }
        private int howmanyinarowR(int x, int y){
                int result=0;

                BoardAnimals animals=tiles[x][y].getSpotAnimal();

                for (int j = y+1; j < tiles[x].length; j++) {
                        if(tiles[x][j].getSpotAnimal().equals(animals)){
                                result++;
                        }else {
                                break;
                        }
                }


                return result;

        }

        private boolean shouldclear(){
                if(fristSelected.getAnimalModifyer()!=AnimalModifyer.NONE
                        &&secondSelected.getAnimalModifyer()!=AnimalModifyer.NONE){
                        return true;
                }

                int fL=howmanyinarowL(fristSelected.getIndexX(),fristSelected.getIndexY());
                int fR=howmanyinarowR(fristSelected.getIndexX(),fristSelected.getIndexY());
                int fU=howmanyinarowU(fristSelected.getIndexX(),fristSelected.getIndexY());
                int fD=howmanyinarowD(fristSelected.getIndexX(),fristSelected.getIndexY());
                if(fL+fR+1>=3||fU+fD+1>=3){
                        return true;
                }

                int sL=howmanyinarowL(secondSelected.getIndexX(),secondSelected.getIndexY());
                int sR=howmanyinarowR(secondSelected.getIndexX(),secondSelected.getIndexY());
                int sU=howmanyinarowU(secondSelected.getIndexX(),secondSelected.getIndexY());
                int sD=howmanyinarowD(secondSelected.getIndexX(),secondSelected.getIndexY());
                if(sL+sR+1>=3||sU+sD+1>=3){
                        return true;
                }
                return false;
        }

        private void clear1() {
        }
        private void fall (){

        }
//        public void doLogic(){
////            use most to all methods above
//        }
}


