import birdgame.board.*;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Board board=new Board(7,7);
        board.tiles[3][3].setSpotAnimal(BoardAnimals.FOX);
        board.tiles[4][3].setSpotAnimal(BoardAnimals.BIRD);
        board.tiles[4][2].setSpotAnimal(BoardAnimals.FOX);
        board.tiles[4][0].setSpotAnimal(BoardAnimals.HIPPO);
        System.out.println("origional : \n"+board);

        board.fristSelected=board.tiles[4][2];
        board.secondSelected=board.tiles[4][3];
        board.swap(board.fristSelected, board.secondSelected);
        System.out.println("after swap 4,2 4,3 : \n"+board);
        board.clear();
        System.out.println("after clear : \n"+board);
        board.fall();

        System.out.println("after fall : \n"+board);


    }


}






