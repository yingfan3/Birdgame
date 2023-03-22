import birdgame.board.*;

import java.util.*;

public class Main  {

    public static void main(String[] args) {

        Board board=new Board(9,9);
        while (board.hasduplicate()){
            board.removeduplicate();
        }
        board.reset1();
        System.out.println(board.hasduplicate());
        Goal goal=new Goal();
        System.out.println("Goal : "+goal.getagoal()+"\n"+board);
        Scanner myObj = new Scanner(System.in);
        System.out.println("Welcome to baobao birdgame!Let's get started");



        while (goal.getN()>0){
            while (board.turnnotover()){
            System.out.println("x:");
            int x=myObj.nextInt();
            System.out.println("y:");
            int y=myObj.nextInt();
            board.select(x,y);
            }

            board.swap();
            if(board.shouldclear()){
                board.beforeclear();
                goal.shouldbecleared(board);
                board.clear();
                board.fall2();
                System.out.println("Goal : "+goal.getagoal()+"\n"+board);
                board.reset2();

            }else {
                board.swap();
            }

            board.newturnstarts();


        }
        System.out.println("Congratualations!You win!");

//        board.fall1();
//        System.out.println("after fall1 : \n"+board);


    }


}






