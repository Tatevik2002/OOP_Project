package BattleOfAges;

import java.awt.*;

import javax.swing.*;

public class MyFrame extends JFrame{

    Panel panel1;
    MyPanel panel2;
    Panel panel3;



    MyFrame(){
        ImageIcon image = new ImageIcon("logo.png");
        panel1 = new Panel();
        panel2 = new MyPanel();
        panel3 = new Panel();

        panel1.setMaximumSize(new Dimension(1920,100));
        panel2.setPreferredSize(new Dimension(1920,980));
        panel1.setLayout(new FlowLayout());
        JLabel playerHealth =  new JLabel("Player's health: 100 %");
        JLabel botHealth =  new JLabel("Enemy's health: 100%");
        JButton upgrade = new JButton("UPGRADE");
        JButton usePower = new JButton("usePOWER");
        panel1.add(playerHealth);
        panel1.add(usePower);
        panel1.add(upgrade);
        panel1.add(botHealth);
        JButton type1 = new JButton();
        JButton type2 = new JButton();
        JButton type3 = new JButton();
        panel1.add(type1);
        panel1.add(type2);
        panel1.add(type3);
        type1.setMaximumSize(new Dimension(20,280));
        type2.setMaximumSize(new Dimension(20,280));
        type3.setMaximumSize(new Dimension(20,280));

        type1.setIcon(new ImageIcon("image3_.png"));
        type2.setIcon(new ImageIcon("image3_.png"));
        type3.setIcon(new ImageIcon("image3_.png"));

        this.setIconImage(image.getImage());
        this.setLayout(new BorderLayout());

        this.setTitle("Age of Wars");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1920,1080);
        this.setVisible(true);

        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.CENTER);
        this.pack();



    }
}
