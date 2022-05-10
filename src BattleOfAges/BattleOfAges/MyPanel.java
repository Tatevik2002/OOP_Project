package BattleOfAges;

import java.awt.*;


import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener{

    final int PANEL_WIDTH = 1920;
    final int PANEL_HEIGHT = 1000;
    Image castle;
    Image botCastle;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 100;
    int x =0;
    int y = 540;
    boolean t;
    Graphics2D g2D;


    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        t = false;
        backgroundImage = new ImageIcon("background_age1.jpg").getImage();
        castle = new ImageIcon("castle1O.png").getImage();
        botCastle = new ImageIcon("castle1.png").getImage();
        timer = new Timer(2500, this);
        timer.start();
    }

    public void paint(Graphics g) {
        g2D = (Graphics2D) g;
        g2D.drawImage(backgroundImage, 0, 0, null);
        g2D.drawImage(castle,-90,450, null);
        g2D.drawImage(botCastle,1320,450, null);
        Image image = new ImageIcon("a1t1O.PNG").getImage();
        if(Console.player.warriors.length != 0){
            for (Warriors element:Console.player.warriors){
                String name;
                name ="a"+element.getAge().getAgeNumber()+"t"+element.getThisType().getNumber()+"O.PNG";
                Image image1 = new ImageIcon(name).getImage();
                g2D.drawImage(image, element.getPositionX(), y, null);

            }//for player
        }
        if(Console.Bot.getMyWarriorLength() != 0){
            for (Warriors element:Console.Bot.warriors){
                String name;
                name ="a"+element.getAge().getAgeNumber()+"t"+element.getThisType().getNumber()+".PNG";
                Image image1 = new ImageIcon(name).getImage();
                g2D.drawImage(image, element.getPositionX(), y, null);

            }//for bot
        }

        //move
        //bar

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.backgroundImage = (new ImageIcon(Console.player.getAge().getImage())).getImage();
        if(Console.player.getAge()==Console.Age1){
            this.castle = new ImageIcon("castle1O").getImage();
        }
        else if(Console.player.getAge()==Console.Age2){
            this.castle = new ImageIcon("castle2O").getImage();
        }
        else if(Console.player.getAge()==Console.Age3){
            this.castle = new ImageIcon("castle3O").getImage();
        }
        else if(Console.player.getAge()==Console.Age4){
            this.castle = new ImageIcon("castle4O").getImage();
        }


        if(Console.Bot.getAge()==Console.Age1){
            this.castle = new ImageIcon("castle1").getImage();
        }
        else if(Console.Bot.getAge()==Console.Age2){
            this.castle = new ImageIcon("castle2O").getImage();
        }
        else if(Console.Bot.getAge()==Console.Age3){
            this.castle = new ImageIcon("castle3O").getImage();
        }

        else if(Console.player.getAge()==Console.Age4){
            this.castle = new ImageIcon("castle4O").getImage();
        }





        repaint();


    }



}