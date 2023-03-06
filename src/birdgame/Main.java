package birdgame;

import birdgame.board.*;

public class Main {



    public static void main (String[]args){
        Tile tile1=new Tile(0,0,BoardAnimals.FOX, BoardBlockers.SAND, AnimalModifyer.none);

        Tile tile2=new Tile(0,1,BoardAnimals.FOX, BoardBlockers.ICE1, AnimalModifyer.none);

        Tile tile3=new Tile(0,2,BoardAnimals.FOX, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile4=new Tile(0,3,BoardAnimals.HIPPO, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile5=new Tile(1,0,BoardAnimals.BIRD, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile6=new Tile(1,1,BoardAnimals.BIRD, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile7=new Tile(1,2,BoardAnimals.BEAR, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile8=new Tile(1,3,BoardAnimals.OWL, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile9=new Tile(2,0,BoardAnimals.FROG, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile10=new Tile(2,1,BoardAnimals.BIRD, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile11=new Tile(2,2,BoardAnimals.OWL, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile12=new Tile(2,3,BoardAnimals.BIRD, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile13=new Tile(3,0,BoardAnimals.FOX, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile14=new Tile(3,1,BoardAnimals.BIRD, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile15=new Tile(3,2,BoardAnimals.BEAR, BoardBlockers.ICE1, AnimalModifyer.none);
        Tile tile16=new Tile(3,3,BoardAnimals.OWL, BoardBlockers.ICE1, AnimalModifyer.none);


        Tile [][]tiles={
                {tile1,tile2,tile3,tile4},
                {tile5,tile6,tile7,tile8},
                {tile9,tile10,tile11,tile12},
                {tile13,tile14,tile15,tile16}
        };
        Board board=new Board();
        board.clear();
        for (int i = 0; i < tiles.length; i++) {
                        System.out.println();
                        for (int j = 0; j < tiles[i].length; j++) {
                            System.out.print(tiles[i][j].getSpotAnimal() + " ");
                        }

        }
        System.out.println(board.clear());

    }

}




