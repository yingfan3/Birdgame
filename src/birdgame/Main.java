package birdgame;

import birdgame.board.*;

public class Main {

    public static void main(String[] args) {
        Tile tile1=new Tile(2,3,5,BoardAnimals.FOX, BoardBlockers.SAND, AnimalModifyer.none);

        Tile tile2=new Tile(2,4,5,BoardAnimals.BIRD, BoardBlockers.ICE1, AnimalModifyer.none);
        Board.swap(tile1,tile2);
        System.out.println(tile1.getAnimalModifyer());
    }

}


