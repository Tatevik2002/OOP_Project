package BattleOfAges;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener{

    final int PANEL_WIDTH = 1090;
    final int PANEL_HEIGHT = 800;
    Image enemy;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 100;
    int x =0;
    int y = 0;
    boolean t;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        t = false;
        backgroundImage = new ImageIcon("background.png").getImage();
        enemy = new ImageIcon("image3_.png").getImage();
        timer = new Timer(2500, this);
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(backgroundImage, 0, 0, null);
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


}

