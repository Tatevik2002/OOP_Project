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
    JButton turret;
    Timer timer;
    JProgressBar money;
    JProgressBar playerHealth;
    JProgressBar botHealth;
    JProgressBar playerExperience;
    JProgressBar botExperience;

    Integer  castleHealthInt;
    Integer  castleHealthIntBot;
    Integer moneyInt;
    Float  playerExperienceFloat;
    Float  botExperienceFloat ;

    MyFrame(){
        ImageIcon image = new ImageIcon("logo.png");
        panel1 = new Panel();
        panel2 = new MyPanel();

        panel1.setMaximumSize(new Dimension(1920,80));
        panel2.setPreferredSize(new Dimension(1920,1000));
        panel1.setLayout(new FlowLayout());
        money = new JProgressBar(SwingConstants.HORIZONTAL,0, 5000);
        money.setStringPainted(true);
        money.setBackground(Color.green);
        moneyInt = Console.player.getMoney();
        this.money.setString("Money: "+  moneyInt.toString());
        panel1.add(money);


        playerHealth = new JProgressBar(SwingConstants.HORIZONTAL,0, 400);
        botHealth = new JProgressBar(SwingConstants.HORIZONTAL,0,400);
        playerHealth.setStringPainted(true);
        botHealth.setStringPainted(true);
        playerHealth.setBackground(Color.YELLOW);
        botHealth.setBackground(Color.RED);
        castleHealthInt = Console.player.castle.getCastleHealth();
        this.playerHealth.setString("Player's health: "+castleHealthInt.toString());
        castleHealthIntBot = Console.Bot.castle.getCastleHealth();
        this.botHealth.setString("Bot's health: "+castleHealthIntBot.toString());
        playerExperienceFloat = Console.player.getExp();
        botExperienceFloat = Console.player.getExp();

        playerExperience = new JProgressBar(SwingConstants.HORIZONTAL, 0, 400);
        botExperience = new JProgressBar(SwingConstants.HORIZONTAL, 0, 400);

        playerExperience.setStringPainted(true);
        botExperience.setStringPainted(true);
        this.playerExperience.setString( "Player's XP: "+playerExperienceFloat.toString()+"XP");
        this.playerExperience.setString( "Bot's XP:  "+botExperienceFloat.toString()+"XP");

        playerExperience.setBackground(Color.ORANGE);
        botExperience.setBackground(Color.pink);

        upgrade = new JButton("Upgrade");
        upgrade.setBorderPainted(false);
        upgrade.setBackground(Color.BLUE);
        usePower = new JButton("Use power");
        usePower.setBorderPainted(false);
        usePower.setBackground(Color.BLUE);
        turret = new JButton();
        turret.setBorderPainted(false);
        if (Console.player.getAge().getAgeNumber() == 1)
            turret.setText("Turret: "+ Console.TypeOneTurret.getCost());
        else if (Console.player.getAge().getAgeNumber() == 2)
            turret.setText("Turret: "+ Console.TypeTwoTurret.getCost());
        else if (Console.player.getAge().getAgeNumber() == 3)
            turret.setText("Turret: "+ Console.TypeThreeTurret.getCost());
        else if (Console.player.getAge().getAgeNumber() == 4)
            turret.setText("Turret: "+ Console.TypeFourTurret.getCost());
        turret.setBackground(Color.BLUE);
        panel1.add(playerHealth);
        panel1.add(playerExperience);
        panel1.add(usePower);
        panel1.add(upgrade);
        panel1.add(turret);

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
        turret.addActionListener(this);
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
        moneyInt = Console.player.getMoney();
        this.money.setString("Money: "+ moneyInt.toString());
        this.playerHealth.setString("player's health: "+ castleHealthInt.toString());
        this.botHealth.setString("Bot's health" + castleHealthIntBot.toString());
        this.playerExperience.setString( "Player's XP: "+playerExperienceFloat.toString());
        this.botExperience.setString("Bot's XP: "+ botExperienceFloat.toString());

        if (Console.player.getAge().getAgeNumber() == 1)
            turret.setText("Turret: "+ Console.TypeOneTurret.getCost());
        else if (Console.player.getAge().getAgeNumber() == 2)
            turret.setText("Turret: "+ Console.TypeTwoTurret.getCost());
        else if (Console.player.getAge().getAgeNumber() == 3)
            turret.setText("Turret: "+ Console.TypeThreeTurret.getCost());
        else if (Console.player.getAge().getAgeNumber() == 4)
            turret.setText("Turret: "+ Console.TypeFourTurret.getCost());


        if(e.getSource()==this.usePower) {
            Console.player.tryUsingPower();


        }
        else if(e.getSource()==this.upgrade) {
            Console.player.tryUpgradingAge();


            if(Console.player.getAge()==Console.Age2){
                this.type1.setIcon(new ImageIcon("ba2t1O.PNG"));
                this.type2.setIcon(new ImageIcon("ba2t2O.PNG"));
                this.type3.setIcon(new ImageIcon("ba2t3O.PNG"));
                //this.panel2.castle = new ImageIcon("castle2.png").getImage();
            }
            else if(Console.player.getAge()==Console.Age3){
                this.type1.setIcon(new ImageIcon("ba3t1O.PNG"));
                this.type2.setIcon(new ImageIcon("ba3t2O.PNG"));
                this.type3.setIcon(new ImageIcon("ba3t3O.PNG"));
                //this.panel2.castle = new ImageIcon("castle3.png").getImage();
            }
            else if(Console.player.getAge()==Console.Age4){
                this.type1.setIcon(new ImageIcon("ba4t1O.PNG"));
                this.type2.setIcon(new ImageIcon("ba4t2O.PNG"));
                this.type3.setIcon(new ImageIcon("ba4t3O.PNG"));
               // this.panel2.castle = new ImageIcon("castle4.png").getImage();
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
        else if (e.getSource()==this.turret){
            Console.player.tryCreatingTurret();
        }
        repaint();
    }


}
