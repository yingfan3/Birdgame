package birdgame.board;

import java.util.Random;

public class Goal {
    Random rm=new Random();
    private int n= rm.nextInt(1,10);
    private String stringb=BoardAnimals.getAnimal().toString();

    public String getagoal(){
        String stringa=Integer.toString(n);
        return stringa+" "+stringb;
    }

    public int getN() {
        return n;
    }

    public void shouldbecleared(Board board){
        int res=0;
        for (int i = 0; i < board.truetiles().size(); i++) {
            if(board.truetiles().get(i).equals(stringb)){
                res++;
            }
        }
        n=n-res;
    }
}
