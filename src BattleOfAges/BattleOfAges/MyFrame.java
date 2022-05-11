package BattleOfAges;

import BattleOfAges.Type.Type;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyFrame extends JFrame implements ActionListener {

    Panel panel1;
    MyPanel panel2;
    JButton usePower;
    JButton upgrade;
    JButton type1;
    JButton type2;
    JButton type3;
    Timer timer;
    JProgressBar playerHealth;
    JProgressBar botHealth;
    JProgressBar playerExperience;
    JProgressBar botExperience;
    Integer  castleHealthInt;
    Integer  castleHealthIntBot;
    Float  playerExperienceFloat;
    Float  botExperienceFloat ;

    MyFrame(){
        ImageIcon image = new ImageIcon("logo.png");
        panel1 = new Panel();
        panel2 = new MyPanel();

        panel1.setMaximumSize(new Dimension(1920,80));
        panel2.setPreferredSize(new Dimension(1920,980));
        panel1.setLayout(new FlowLayout());
        playerHealth = new JProgressBar(SwingConstants.HORIZONTAL,0, 400);
        botHealth = new JProgressBar(SwingConstants.HORIZONTAL,0,400);
        playerHealth.setStringPainted(true);
        botHealth.setStringPainted(true);
        playerHealth.setBackground(Color.green);
        botHealth.setBackground(Color.RED);
        castleHealthInt = Console.player.castle.getCastleHealth();
        this.playerHealth.setString(castleHealthInt.toString());
        castleHealthIntBot = Console.Bot.castle.getCastleHealth();
        this.botHealth.setString(castleHealthIntBot.toString());
        playerExperienceFloat = Console.player.getExp();
        botExperienceFloat = Console.player.getExp();

        playerExperience = new JProgressBar(SwingConstants.HORIZONTAL, 0, 1000);
        botExperience = new JProgressBar(SwingConstants.HORIZONTAL, 0, 1000);

        playerExperience.setStringPainted(true);
        botExperience.setStringPainted(true);
        this.playerExperience.setString( playerExperienceFloat.toString()+"XP");
        this.playerExperience.setString( botExperienceFloat.toString()+"XP");

        playerExperience.setBackground(Color.ORANGE);
        botExperience.setBackground(Color.pink);

        upgrade = new JButton("Upgrade");
        upgrade.setBorderPainted(false);
        usePower = new JButton("Use power");
        usePower.setBorderPainted(false);
        panel1.add(playerHealth);
        panel1.add(playerExperience);
        panel1.add(usePower);
        panel1.add(upgrade);
        type1 = new JButton();
        type2 = new JButton();
        type3 = new JButton();
        panel1.add(type1);
        panel1.add(type2);
        panel1.add(type3);
        panel1.add(botExperience);
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
        type1.addActionListener(this);
        type2.addActionListener(this);
        type3.addActionListener(this);
        upgrade.addActionListener(this);
        usePower.addActionListener(this);
        timer = new Timer(1000, this);
        timer.start();



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
        castleHealthInt = Console.player.castle.getCastleHealth();
        castleHealthIntBot = Console.player.castle.getCastleHealth();
        playerExperienceFloat = Console.player.getExp();
        botExperienceFloat = Console.player.getExp();

        this.playerHealth.setString(castleHealthInt.toString());
        this.botHealth.setString(castleHealthIntBot.toString());
        this.playerExperience.setString( playerExperienceFloat.toString()+"XP");
        this.botExperience.setString( botExperienceFloat.toString()+"XP");


        if(e.getSource()==this.usePower) {
            Console.player.tryUsingPower();


        }
        else if(e.getSource()==this.upgrade) {
            Console.player.tryUpgradingAge();


            if(Console.player.getAge()==Console.Age2){
                this.type1.setIcon(new ImageIcon("ba2t1O.PNG"));
                this.type2.setIcon(new ImageIcon("ba2t2O.PNG"));
                this.type3.setIcon(new ImageIcon("ba2t3O.PNG"));
            }
            else if(Console.player.getAge()==Console.Age3){
                this.type1.setIcon(new ImageIcon("ba3t1O.PNG"));
                this.type2.setIcon(new ImageIcon("ba3t2O.PNG"));
                this.type3.setIcon(new ImageIcon("ba3t3O.PNG"));
            }
            else if(Console.player.getAge()==Console.Age4){
                this.type1.setIcon(new ImageIcon("ba4t1O.PNG"));
                this.type2.setIcon(new ImageIcon("ba4t2O.PNG"));
                this.type3.setIcon(new ImageIcon("ba4t3O.PNG"));
            }



        }
        else if(e.getSource()==this.type1) {
            Console.player.tryCreatingUnit(Console.Type1);


        }
        else if(e.getSource()==this.type2) {
            Console.player.tryCreatingUnit(Console.Type2);

        }
        else if(e.getSource()==this.type3) {
            Console.player.tryCreatingUnit(Console.Type3);
        }
        repaint();
    }


}
