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
        if(Console.player.warriors.length != 0){
            for (Warriors element:Console.player.warriors){
                String name;
                name ="a"+(element.getAge().getAgeNumber())+"t"+element.getThisType().getNumber()+"O.PNG";

                Image image1 = new ImageIcon(name).getImage();
                g2D.drawImage(image1, element.getPositionX(), y, null);
            }//for player
        }
        if(Console.Bot.getMyWarriorLength() != 0){
            for (Warriors element:Console.Bot.warriors){
                String name;
                name ="a"+(element.getAge().getAgeNumber())+"t"+element.getThisType().getNumber()+".PNG";
                Image image1 = new ImageIcon(name).getImage();
                g2D.drawImage(image1, element.getPositionX(), y, null);

            }//for bot
        }

        Console.player.ToBeOrNotToBe();
        Console.Bot.ToBeOrNotToBe();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.backgroundImage = new ImageIcon(Console.player.getAge().getImage()).getImage();
        if(Console.player.getAge().getAgeNumber()==1){
            this.castle = new ImageIcon("castle1O.png").getImage();
        }
        else if(Console.player.getAge().getAgeNumber()==2){
            this.castle = new ImageIcon("castle2O.png").getImage();
        }
        else if(Console.player.getAge().getAgeNumber()==3){
            this.castle = new ImageIcon("castle3O.png").getImage();
        }
        else if(Console.player.getAge().getAgeNumber()==4){
            this.castle = new ImageIcon("castle4O.png").getImage();
        }


        if(Console.Bot.getAge().getAgeNumber()==1){
            this.castle = new ImageIcon("castle1.png").getImage();
        }
        else if(Console.Bot.getAge().getAgeNumber()==2){
            this.castle = new ImageIcon("castle2.png").getImage();
        }
        else if(Console.Bot.getAge().getAgeNumber()==3){
            this.castle = new ImageIcon("castle3.png").getImage();
        }

        else if(Console.Bot.getAge().getAgeNumber()==4){
            this.castle = new ImageIcon("castle4.png").getImage();
        }
        repaint();






    }



}