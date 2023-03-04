package birdgame.board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public enum BoardAnimals {
    FOX,BEAR,BIRD,FROG,HIPPO,OWL;
//    Image fox,bear,bird,frog,hippo,owl;
//
//    {
//        try {
//            fox= ImageIO.read(new File("images/Fox.png"));
//            bear= ImageIO.read(new File("images/Bear.png"));
//            bird= ImageIO.read(new File("images/Bird.png"));
//            frog= ImageIO.read(new File("images/Frog.png"));
//            hippo= ImageIO.read(new File("images/Hippo.png"));
//            owl= ImageIO.read(new File("images/Owl.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static BoardAnimals getAnimal(){

        Random rm=new Random();
        int n= rm.nextInt(6);
        return BoardAnimals.values()[n];

    }


}

