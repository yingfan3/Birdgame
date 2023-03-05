package birdgame.board;

import java.util.Random;

public enum BoardBlockers {
    ICE1,ICE2,ICE3, BUBBLE,  SAND,EMPTY,NONE;
    public static BoardAnimals getBlcokers(){

        Random rm=new Random();
        int n= rm.nextInt(7);

        return BoardAnimals.values()[n];

    }

    }

