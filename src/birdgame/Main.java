package birdgame;

import birdgame.board.AnimalModifyer;
import birdgame.board.Board;
import birdgame.board.BoardAnimals;
import birdgame.board.Tile;

public class Main {
    public static void main(String[] args) {
//        new Board();
        Tile tile=new Tile(2,4,BoardAnimals.FOX);
        Tile tile1=new Tile(2,3,BoardAnimals.FOX);
        Tile.move(tile,tile1);
        System.out.println(tile.getSpotAnimal());
        System.out.println(tile.getLocationX());
        System.out.println(tile.getLocationY());
    }
}
