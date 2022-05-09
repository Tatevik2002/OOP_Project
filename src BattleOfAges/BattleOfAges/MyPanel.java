package BattleOfAges;

import java.awt.*;


import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener{

    final int PANEL_WIDTH = 1920;
    final int PANEL_HEIGHT = 1000;
    Image castle;
    Image enemy;
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
        enemy = new ImageIcon("a1t1O.PNG").getImage();
        timer = new Timer(2500, this);
        timer.start();
    }

    public void paint(Graphics g) {
        g2D = (Graphics2D) g;

        g2D.drawImage(backgroundImage, 0, 0, null);
        g2D.drawImage(castle,-90,450, null);
        g2D.drawImage(botCastle,1320,450, null);

        g2D.drawImage(enemy, x, y, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(x>=PANEL_WIDTH-enemy.getWidth(null) || x<0) {
            xVelocity = xVelocity * -1;
        }

        if(t == false){
            x = x + xVelocity;
            t = true;
            repaint();
        }

    }
    protected void  changeBackground(String name){
        Image backgroundImage = new ImageIcon("name").getImage();
        g2D.drawImage(backgroundImage,0,0, null);
    }


}