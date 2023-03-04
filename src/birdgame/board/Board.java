package birdgame.board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame implements ActionListener {
    BirdPanel panel;

    public  Board(){
        this.setSize(500,500);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel=new BirdPanel();
        this.add(panel);

        JMenuBar mb=new JMenuBar();
        JMenu m1=new JMenu("Game");
        JMenuItem item1= new JMenuItem("Exit");
        JMenuItem item2= new JMenuItem("Restart");
        mb.add(m1);
        m1.add(item1);
        m1.add(item2);
        this.setJMenuBar(mb);
        item1.addActionListener(this);
        item2.addActionListener(this);

        Timer timer=new Timer(1000,this);
        timer.start();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Exit".equals(e.getActionCommand())){
            System.exit(0);
        }else if("Restart".equals(e.getActionCommand())){

        }
    }






}


