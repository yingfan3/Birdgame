package birdgame.board;

import java.util.Random;

public class Goal {
    Random rm=new Random();
    private int n= rm.nextInt(10);
    private String stringb=BoardAnimals.getAnimal().toString();

    public String getagoal(){
        String stringa=Integer.toString(n);
        return stringa+" "+stringb;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public void havecleared(Board board){

        if(board.getS().equals(stringb)){
            n=n- board.howmanyN();
        }


    }
}
