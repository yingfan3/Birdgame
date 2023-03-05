package birdgame.board;

import java.util.Random;

public enum BoardAnimals {
    FOX,BEAR,BIRD,FROG,HIPPO,OWL;


    public static BoardAnimals getAnimal(){

        Random rm=new Random();
        int n= rm.nextInt(6);

        return BoardAnimals.values()[n];

    }



}




