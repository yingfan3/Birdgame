package birdgame.board;

import java.util.Random;

public enum BoardAnimals {
    FOX("F"),BEAR("B"),BIRD("C"),FROG("G"),HIPPO("H"),OWL("O"),NONE("N");
    String anmial;
    private static Random rm =null;
    BoardAnimals(String x){
        anmial=x;
    }
    public static BoardAnimals getAnimal(){

        if (rm==null){
             rm=new Random(178556);
        }


        int n= rm.nextInt(6);

        return BoardAnimals.values()[n];

    }



}




