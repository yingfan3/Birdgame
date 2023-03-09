package birdgame.board;

import java.util.Random;

public enum BoardBlockers {



    ICE1("I1"),ICE2("I2"),ICE3("I3"), BUBBLE("BB"),  SAND("SD"),EMPTY("EM"),NONE("NO");
    String blocker;
    private static Random rm =null;
    BoardBlockers(String x){
        blocker=x;

    }

    }

