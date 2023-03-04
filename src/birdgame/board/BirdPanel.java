package birdgame.board;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BirdPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            Image image= ImageIO.read(new File("images/background.png"));
            g.drawImage(image,0,0,500,500,this);

//            g.drawImage(BoardAnimals.getAnimal(),0,0,50,50,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

