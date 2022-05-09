package BattleOfAges;

import BattleOfAges.Type.Type;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

    Panel panel1;
    MyPanel panel2;
    JButton usePower;
    JLabel playerHealth;
    JLabel botHealth;
    JButton upgrade;
    JButton type1;
    JButton type2;
    JButton type3;


    MyFrame(){
        ImageIcon image = new ImageIcon("logo.png");
        panel1 = new Panel();
        panel2 = new MyPanel();

        panel1.setMaximumSize(new Dimension(1920,80));
        panel2.setPreferredSize(new Dimension(1920,980));
        panel1.setLayout(new FlowLayout());
        playerHealth =  new JLabel("Player's health: 100 %");
        botHealth =  new JLabel("Enemy's health: 100%");
        upgrade = new JButton("UPGRADE");
        upgrade.setBorderPainted(false);
        usePower = new JButton("usePOWER");
        usePower.setBorderPainted(false);
        panel1.add(playerHealth);
        panel1.add(usePower);
        panel1.add(upgrade);
        type1 = new JButton();
        type2 = new JButton();
        type3 = new JButton();
        panel1.add(type1);
        panel1.add(type2);
        panel1.add(type3);
        panel1.add(botHealth);
        type1.setBorderPainted(false);
        type2.setBorderPainted(false);
        type3.setBorderPainted(false);
        type1.setContentAreaFilled(false);
        type1.setFocusPainted(false);
        type2.setContentAreaFilled(false);
        type2.setFocusPainted(false);
        type3.setContentAreaFilled(false);
        type3.setFocusPainted(false);
        type1.setMaximumSize(new Dimension(65,80));
        type2.setMaximumSize(new Dimension(65,80));
        type3.setMaximumSize(new Dimension(65,80));

        type1.setIcon(new ImageIcon("ba1t1O.PNG"));
        type2.setIcon(new ImageIcon("ba1t2O.PNG"));
        type3.setIcon(new ImageIcon("ba1t3O.PNG"));

        this.setIconImage(image.getImage());
        this.setLayout(new BorderLayout(0,0));

        this.setTitle("Age of Wars");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(1920,1080);
        this.setVisible(true);

        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.CENTER);

        this.pack();



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.usePower) {
            Console.player.usePower();
            // avelacnel zinvornery

        }
        else if(e.getSource()==this.upgrade) {
            Console.player.changeAge();
            this.panel2.changeBackground(Console.player.getAge().getImage());



        }
        else if(e.getSource()==this.type1) {
            Console.player.addWarriors(new Warriors(Console.player.getAge(),Console.Type1,-90));

        }
        if(e.getSource()==this.type2) {
            Console.player.addWarriors(new Warriors(Console.player.getAge(), Console.Type2,Console.player.warriors.length+1));


        }
        if(e.getSource()==this.type3) {
            Console.player.addWarriors(new Warriors(Console.player.getAge(), Console.Type3,Console.player.warriors.length+1));

        }
    }


}