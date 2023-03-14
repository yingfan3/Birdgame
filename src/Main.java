import birdgame.board.*;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Board board=new Board(10,10);
        int goal=8;
        int newgoal=0;
        String animal=BoardAnimals.getAnimal().toString();
        for (int i = 0; i < board.tiles.length; i++) {
            for (int j = 0; j < board.tiles[i].length; j++) {
                if(board.tiles[i][j].getSpotAnimal().toString().equals(animal)){
                    newgoal++;
                }
            }
        }
        goal=Math.min(goal,newgoal);
        System.out.println("Goal : "+goal+" "+animal+"\n"+board);
        Scanner myObj = new Scanner(System.in);
        System.out.println("Welcome to baobao birdgame!Let's get started");
        while (goal>0){
            System.out.println("first animal x:");
            int x1=myObj.nextInt();
            System.out.println("first animal y:");
            int y1=myObj.nextInt();
            board.fristSelected=board.tiles[x1][y1];
            System.out.println("second animal x:");
            int x2=myObj.nextInt();
            System.out.println("second animal y:");
            int y2=myObj.nextInt();
            board.secondSelected=board.tiles[x2][y2];
            board.swap(board.fristSelected, board.secondSelected);
            if(board.shouldclear()==false){
                board.swap(board.fristSelected,board.secondSelected);
            }
            board.clear();

            if(board.s.equals(animal)){
                for (int i = 0; i < board.tiles.length; i++) {
                    for (int j = 0; j < board.tiles[i].length; j++) {
                        if(board.tiles[i][j].getSpotAnimal().equals(BoardAnimals.NONE)){
                            goal--;
                        }
                    }
                }
            }


            board.fall2();
            System.out.println("Goal : "+goal+" "+animal+"\n"+board);

        }
        System.out.println("Congratualations!You win!");

//        board.fall1();
//        System.out.println("after fall1 : \n"+board);

    }


}






