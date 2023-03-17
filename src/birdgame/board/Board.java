package birdgame.board;

import java.util.*;

public class Board {
        private Tile fristSelected;
        private Tile secondSelected;
        private final Tile [][] tiles;
        private List<String> ls;



        @Override
        public String toString() {
                String board="";
                for (int i = 0; i < tiles.length; i++) {
                        for (int j = 0; j < tiles[i].length; j++) {
                                 board+=tiles[i][j].toString();
                        }
                        board+="\n";
                }
                return board;
        }

        public Board(int xSize, int ysize){
                tiles=new Tile[xSize][ysize];
                for (int i = 0; i < tiles.length; i++) {
                        for (int j = 0; j < tiles[i].length; j++) {
                                tiles[i][j]=new Tile(i,j);
                                tiles[i][j].setSpotAnimal(BoardAnimals.getAnimal());
                        }
                }

        }
        public void select (int x, int y){
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
        public boolean isfirstsecletion(){
                return fristSelected==null;
        }



        public void swap(){
             swap(fristSelected,secondSelected);
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


        public int howmanyinarowU(int x, int y){
                int result=0;
                BoardAnimals animals=tiles[x][y].getSpotAnimal();

                for (int i = x-1; i > -1; i--) {
                        if(tiles[i][y].getSpotAnimal().equals(animals)){
                                result++;
                        }   else {break;}
                }

                return result;

        }
        public int howmanyinarowD(int x, int y){
                int result=0;
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

        public int howmanyinarowL(int x, int y){
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
        public int howmanyinarowR(int x, int y){
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

        public boolean shouldclear(){
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
        public boolean checkmoifier(){
                if(fristSelected.getAnimalModifyer()!=AnimalModifyer.NONE &&
                        secondSelected.getAnimalModifyer()!=AnimalModifyer.NONE){
                        return true;
                }
                return false;
        }

        public void beforremove(int x1,int y1, int x2,int y2){
                for (int i = x1; i < x2+1; i++) {
                        for (int j = y1; j < y2+1; j++) {
                                tiles[i][j].setMark(true);

                        }
                }

        }

        public int beforeclear() {
                 int fL=howmanyinarowL(fristSelected.getIndexX(),fristSelected.getIndexY());
                 int fR=howmanyinarowR(fristSelected.getIndexX(),fristSelected.getIndexY());
                 int fU=howmanyinarowU(fristSelected.getIndexX(),fristSelected.getIndexY());
                 int fD=howmanyinarowD(fristSelected.getIndexX(),fristSelected.getIndexY());
                 int sL=howmanyinarowL(secondSelected.getIndexX(),secondSelected.getIndexY());
                 int sR=howmanyinarowR(secondSelected.getIndexX(),secondSelected.getIndexY());
                 int sU=howmanyinarowU(secondSelected.getIndexX(),secondSelected.getIndexY());
                 int sD=howmanyinarowD(secondSelected.getIndexX(),secondSelected.getIndexY());
                if(checkmoifier()){
                        if(fristSelected.getAnimalModifyer().equals(AnimalModifyer.uPDown)
                                &&secondSelected.getAnimalModifyer().equals(AnimalModifyer.uPDown)) {
                                beforremove(0, fristSelected.getIndexY(), tiles.length - 1, fristSelected.getIndexY());
                                beforremove(0, secondSelected.getIndexY(), tiles.length - 1, secondSelected.getIndexY());

                        } else if(fristSelected.getAnimalModifyer().equals(AnimalModifyer.leftRight)
                                &&secondSelected.getAnimalModifyer().equals(AnimalModifyer.leftRight)){
                                beforremove(fristSelected.getIndexX(),0,
                                        fristSelected.getIndexX(),tiles[fristSelected.getIndexX()].length);
                                beforremove(secondSelected.getIndexX(),0,
                                        secondSelected.getIndexX(),tiles[secondSelected.getIndexX()].length);
                                return 2;
                        } else if(fristSelected.getAnimalModifyer().equals(AnimalModifyer.uPDown)
                                &&secondSelected.getAnimalModifyer().equals(AnimalModifyer.leftRight)){
                                beforremove(0, fristSelected.getIndexY(), tiles.length - 1, fristSelected.getIndexY());
                                beforremove(secondSelected.getIndexX(),0,
                                        secondSelected.getIndexX(),tiles[secondSelected.getIndexX()].length);
                                return 3;
                        } else if(fristSelected.getAnimalModifyer().equals(AnimalModifyer.leftRight)
                                &&secondSelected.getAnimalModifyer().equals(AnimalModifyer.uPDown)){
                                beforremove(fristSelected.getIndexX(),0,
                                        fristSelected.getIndexX(),tiles[fristSelected.getIndexX()].length);
                                beforremove(0, secondSelected.getIndexY(), tiles.length - 1, secondSelected.getIndexY());
                                return 4;
                        }


                }
                else {
                        if (fU + fD + 1 == 3) {
                                beforremove(fristSelected.getIndexX() - fU, fristSelected.getIndexY(),
                                        fristSelected.getIndexX() + fD, fristSelected.getIndexY());
                                return 5;
                        }
                        if (sU + sD + 1 == 3) {
                                beforremove(secondSelected.getIndexX() - sU, secondSelected.getIndexY(),
                                        secondSelected.getIndexX() + sD, secondSelected.getIndexY());
                                return 6;
                        }
                        if (fL + fR + 1 == 3) {
                                beforremove(fristSelected.getIndexX(), fristSelected.getIndexY() - fL,
                                        fristSelected.getIndexX(), fristSelected.getIndexY() + fR);
                                return 7;
                        }
                        if (sL + sR + 1 == 3) {
                                beforremove(secondSelected.getIndexX(), secondSelected.getIndexY() - sL,
                                        secondSelected.getIndexX(), secondSelected.getIndexY() + sR);
                                return 8;
                        }
                        if (fU + fD + 1 == 4) {
                                beforremove(fristSelected.getIndexX() - fU, fristSelected.getIndexY(),
                                        fristSelected.getIndexX() - 1, fristSelected.getIndexY());
                                beforremove(fristSelected.getIndexX() + 1, fristSelected.getIndexY(),
                                        fristSelected.getIndexX() + fD, fristSelected.getIndexY());
                                return 9;
                        }
                        if (sU + sD + 1 == 4) {
                                beforremove(secondSelected.getIndexX() - sU, secondSelected.getIndexY(),
                                        secondSelected.getIndexX() - 1, secondSelected.getIndexY());
                                beforremove(secondSelected.getIndexX() + 1, secondSelected.getIndexY(),
                                        secondSelected.getIndexX() + sD, secondSelected.getIndexY());
                                return 10;
                        }
                        if (fL + fR + 1 == 4) {
                                beforremove(fristSelected.getIndexX(), fristSelected.getIndexY() - fL,
                                        fristSelected.getIndexX(), fristSelected.getIndexY() - 1);
                                beforremove(fristSelected.getIndexX(), fristSelected.getIndexY() + 1,
                                        fristSelected.getIndexX(), fristSelected.getIndexY() + fR);
                                return 11;
                        }
                        if (sL + sR + 1 == 4) {
                                beforremove(secondSelected.getIndexX(), secondSelected.getIndexY() - sL,
                                        secondSelected.getIndexX(), secondSelected.getIndexY() - 1);
                                beforremove(secondSelected.getIndexX(), secondSelected.getIndexY() + 1,
                                        secondSelected.getIndexX(), secondSelected.getIndexY() + sR);
                                return 12;
                        }
                        if (fU + fD + 1 == 5) {
                                beforremove(fristSelected.getIndexX() - fU, fristSelected.getIndexY(),
                                        fristSelected.getIndexX() - 1, fristSelected.getIndexY());
                                beforremove(fristSelected.getIndexX() + 1, fristSelected.getIndexY(),
                                        fristSelected.getIndexX() + fD, fristSelected.getIndexY());
                                return 13;
                        }
                        if (sU + sD + 1 == 5) {
                                beforremove(secondSelected.getIndexX() - sU, secondSelected.getIndexY(),
                                        secondSelected.getIndexX() - 1, secondSelected.getIndexY());
                                beforremove(secondSelected.getIndexX() + 1, secondSelected.getIndexY(),
                                        secondSelected.getIndexX() + sD, secondSelected.getIndexY());
                                return 14;
                        }
                        if (fL + fR + 1 == 5) {
                                beforremove(fristSelected.getIndexX(), fristSelected.getIndexY() - fL,
                                        fristSelected.getIndexX(), fristSelected.getIndexY() - 1);
                                beforremove(fristSelected.getIndexX(), fristSelected.getIndexY() + 1,
                                        fristSelected.getIndexX(), fristSelected.getIndexY() + fR);
                                return 15;
                        }
                        if (sL + sR + 1 == 5) {
                                beforremove(secondSelected.getIndexX(), secondSelected.getIndexY() - sL,
                                        secondSelected.getIndexX(), secondSelected.getIndexY() - 1);
                                beforremove(secondSelected.getIndexX(), secondSelected.getIndexY() + 1,
                                        secondSelected.getIndexX(), secondSelected.getIndexY() + sR);
                                return 16;
                        }


                }
                return 0;

        }

        public void clear() {
                int fL=howmanyinarowL(fristSelected.getIndexX(),fristSelected.getIndexY());
                int fR=howmanyinarowR(fristSelected.getIndexX(),fristSelected.getIndexY());
                int fU=howmanyinarowU(fristSelected.getIndexX(),fristSelected.getIndexY());
                int fD=howmanyinarowD(fristSelected.getIndexX(),fristSelected.getIndexY());
                int sL=howmanyinarowL(secondSelected.getIndexX(),secondSelected.getIndexY());
                int sR=howmanyinarowR(secondSelected.getIndexX(),secondSelected.getIndexY());
                int sU=howmanyinarowU(secondSelected.getIndexX(),secondSelected.getIndexY());
                int sD=howmanyinarowD(secondSelected.getIndexX(),secondSelected.getIndexY());
                if(beforeclear()==1){
                        remove(0, fristSelected.getIndexY(), tiles.length - 1, fristSelected.getIndexY());
                        remove(0, secondSelected.getIndexY(), tiles.length - 1, secondSelected.getIndexY());
                } if(beforeclear()==2){remove(fristSelected.getIndexX(),0,
                        fristSelected.getIndexX(),tiles[fristSelected.getIndexX()].length);
                        remove(secondSelected.getIndexX(),0,
                                secondSelected.getIndexX(),tiles[secondSelected.getIndexX()].length);
                } if(beforeclear()==3){
                        remove(0, fristSelected.getIndexY(), tiles.length - 1, fristSelected.getIndexY());
                        remove(secondSelected.getIndexX(),0,
                                secondSelected.getIndexX(),tiles[secondSelected.getIndexX()].length);
                } if(beforeclear()==4){
                        remove(fristSelected.getIndexX(),0,
                                fristSelected.getIndexX(),tiles[fristSelected.getIndexX()].length);
                        remove(0, secondSelected.getIndexY(), tiles.length - 1, secondSelected.getIndexY());
                } if(beforeclear()==5){
                        remove(fristSelected.getIndexX() - fU, fristSelected.getIndexY(),
                                fristSelected.getIndexX() + fD, fristSelected.getIndexY());
                } if(beforeclear()==6){
                        remove(secondSelected.getIndexX() - sU, secondSelected.getIndexY(),
                                secondSelected.getIndexX() + sD, secondSelected.getIndexY());
                } if(beforeclear()==7){
                        remove(fristSelected.getIndexX(), fristSelected.getIndexY() - fL,
                                fristSelected.getIndexX(), fristSelected.getIndexY() + fR);

                } if(beforeclear()==8){
                        remove(secondSelected.getIndexX(), secondSelected.getIndexY() - sL,
                                secondSelected.getIndexX(), secondSelected.getIndexY() + sR);
                } if(beforeclear()==9){
                        remove(fristSelected.getIndexX() - fU, fristSelected.getIndexY(),
                                fristSelected.getIndexX() - 1, fristSelected.getIndexY());
                        remove(fristSelected.getIndexX() + 1, fristSelected.getIndexY(),
                                fristSelected.getIndexX() + fD, fristSelected.getIndexY());
                        fristSelected.setAnimalModifyer(AnimalModifyer.leftRight);

                } if(beforeclear()==10){
                        remove(secondSelected.getIndexX() - sU, secondSelected.getIndexY(),
                                secondSelected.getIndexX() - 1, secondSelected.getIndexY());
                        remove(secondSelected.getIndexX() + 1, secondSelected.getIndexY(),
                                secondSelected.getIndexX() + sD, secondSelected.getIndexY());
                        secondSelected.setAnimalModifyer(AnimalModifyer.leftRight);
                } if (beforeclear()==11) {
                        remove(fristSelected.getIndexX(), fristSelected.getIndexY() - fL,
                                        fristSelected.getIndexX(), fristSelected.getIndexY() - 1);
                        remove(fristSelected.getIndexX(), fristSelected.getIndexY() + 1,
                                        fristSelected.getIndexX(), fristSelected.getIndexY() + fR);
                        fristSelected.setAnimalModifyer(AnimalModifyer.leftRight);

                } if (beforeclear()==12) {
                        remove(secondSelected.getIndexX(), secondSelected.getIndexY() - sL,
                                        secondSelected.getIndexX(), secondSelected.getIndexY() - 1);
                        remove(secondSelected.getIndexX(), secondSelected.getIndexY() + 1,
                                        secondSelected.getIndexX(), secondSelected.getIndexY() + sR);
                        secondSelected.setAnimalModifyer(AnimalModifyer.uPDown);

                } if (beforeclear()==13) {
                        remove(fristSelected.getIndexX() - fU, fristSelected.getIndexY(),
                                        fristSelected.getIndexX() - 1, fristSelected.getIndexY());
                        remove(fristSelected.getIndexX() + 1, fristSelected.getIndexY(),
                                        fristSelected.getIndexX() + fD, fristSelected.getIndexY());
                        fristSelected.setAnimalModifyer(AnimalModifyer.square);
                } if (beforeclear()==14) {
                        remove(secondSelected.getIndexX() - sU, secondSelected.getIndexY(),
                                        secondSelected.getIndexX() - 1, secondSelected.getIndexY());
                        remove(secondSelected.getIndexX() + 1, secondSelected.getIndexY(),
                                        secondSelected.getIndexX() + sD, secondSelected.getIndexY());
                        secondSelected.setAnimalModifyer(AnimalModifyer.square);

                } if (beforeclear()==15) {
                        remove(fristSelected.getIndexX(), fristSelected.getIndexY() - fL,
                                        fristSelected.getIndexX(), fristSelected.getIndexY() - 1);
                        remove(fristSelected.getIndexX(), fristSelected.getIndexY() + 1,
                                        fristSelected.getIndexX(), fristSelected.getIndexY() + fR);
                        fristSelected.setAnimalModifyer(AnimalModifyer.square);
                } if (beforeclear()==16) {
                        remove(secondSelected.getIndexX(), secondSelected.getIndexY() - sL,
                                        secondSelected.getIndexX(), secondSelected.getIndexY() - 1);
                        remove(secondSelected.getIndexX(), secondSelected.getIndexY() + 1,
                                        secondSelected.getIndexX(), secondSelected.getIndexY() + sR);
                        secondSelected.setAnimalModifyer(AnimalModifyer.square);
                }

        }


        public void remove(int x1,int y1,int x2,int y2){
                for (int i = x1; i < x2+1; i++) {
                        for (int j = y1; j < y2+1; j++) {

                                tiles[i][j].setSpotAnimal(BoardAnimals.NONE);
                                tiles[i][j].setAnimalModifyer(AnimalModifyer.NONE);

                        }
                }

        }
        public List truetiles (){
                ls=new LinkedList<>();
                for (int i = 0; i < tiles.length; i++) {
                        for (int j = 0; j < tiles[i].length; j++) {
                                if(tiles[i][j].isMark()==true){
                                        ls.add(tiles[i][j].getSpotAnimal().toString());
                                }
                        }
                }
                return ls;
        }
        public void fall1 (){
                for (int i = 0; i <tiles.length ; i++) {
                        for (int j = 0; j < tiles[i].length; j++) {
                                if(tiles[i][j].getSpotAnimal().equals(BoardAnimals.NONE)){
                                       int n=howmanyinarowD(i,j);
                                       if(i==0) {
                                               for (int k=0;k<n+1;k++){
                                                       tiles[k][j].setSpotAnimal(BoardAnimals.getAnimal());
                                                       tiles[k][j].setAnimalModifyer(AnimalModifyer.NONE);
                                               }

                                       } else {
                                               if(n+1>i) {
                                                       for (int k = n + 1; k < i + n + 1; k++) {
                                                               tiles[k][j].setSpotAnimal(tiles[k - n - 1][j].getSpotAnimal());
                                                               tiles[k][j].setBoardBlocker(tiles[k - n - 1][j].getBoardBlocker());
                                                               tiles[k][j].setAnimalModifyer(tiles[k - n - 1][j].getAnimalModifyer());

                                                       }
                                                       for (int k = 0; k < n + 1; k++) {
                                                               tiles[k][j].setSpotAnimal(BoardAnimals.getAnimal());
                                                               tiles[k][j].setAnimalModifyer(AnimalModifyer.NONE);
                                                       }
                                               }else {
                                                       for (int k = i + n; k > n; k--) {
                                                       tiles[k][j].setSpotAnimal(tiles[k - n - 1][j].getSpotAnimal());
                                                       tiles[k][j].setBoardBlocker(tiles[k - n - 1][j].getBoardBlocker());
                                                       tiles[k][j].setAnimalModifyer(tiles[k - n - 1][j].getAnimalModifyer());
                                                       }
                                                       for (int k = 0; k < n + 1; k++) {
                                                       tiles[k][j].setSpotAnimal(BoardAnimals.getAnimal());
                                                       tiles[k][j].setAnimalModifyer(AnimalModifyer.NONE);
                                                       }
                                               }
                                       }
                                }
                        }
                }

        }
        public void fall2(){

                Queue<Tile> tilelist = new LinkedList<>();
                for (int i = 0; i < tiles.length; i++) {
                        for (int j = 0; j < tiles[i].length; j++) {
                                if(tiles[i][j].getSpotAnimal().equals(BoardAnimals.NONE)){
                                        tilelist.add(tiles[i][j]);
                                }
                        }
                }
//                Collections.shuffle((List<?>) tilelist);
                while (!tilelist.isEmpty()){
                        Tile tilehead=tilelist.remove();
                        int x=tilehead.getIndexX();
                        int y=tilehead.getIndexY();
                        if(x==0){
                                tiles[x][y].setSpotAnimal(BoardAnimals.getAnimal());
                        }
                        else {
                                if(tiles[x-1][y].getSpotAnimal()!=BoardAnimals.NONE) {
                                        tiles[x][y].setSpotAnimal(tiles[x - 1][y].getSpotAnimal());
                                        tiles[x][y].setBoardBlocker(tiles[x - 1][y].getBoardBlocker());
                                        tiles[x][y].setAnimalModifyer(tiles[x - 1][y].getAnimalModifyer());

                                        tilelist.add(tiles[x - 1][y]);
                                }else {

                                        tilelist.add(tiles[x][y]);
                                }

                        }
                }
//

        }

        public boolean turnnotover(){

                return secondSelected==null;
        }


        public void newturnstarts(){
                secondSelected=null;
        }


}


