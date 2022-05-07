package BattleOfAges;
import BattleOfAges.TurretTypes.Turret;
import BattleOfAges.Type.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player {
    private Age currentAge;
    private int ageIDinArray = 0;
    private int money;
    private int exp;
    private int timeNeededToUsePower; // seconds
    protected Warriors[] warriors = new Warriors[0];
    protected Castle castle = new Castle(this);
    Type[] Coordinates = new Type[1];
    int position;
    Player(int LeftOrRight, Warriors[] WarriorsArrayName){
        exp = 0;
        money = 500;
        currentAge = new Age(Main.arrayOfAges[0]);
        timeNeededToUsePower = 120; // seconds
        position = LeftOrRight;
    }
    public Warriors[] changeArray(Player player){ // jnjuma mi hat warrior
        int newLength = player.warriors.length - 1;
        Warriors[] newArray = new Warriors[newLength];
        Warriors[] copyArray = new Warriors[newLength];
        for (int i = 1; i < player.warriors.length; i++) {
            newArray[i-1] = player.warriors[i];
            copyArray[i-1]= new Warriors(player.warriors[i]);
        }
        this.warriors = newArray;
        return newArray;
    }
    public Warriors[] changeArray(Player player, int index){ // jnjuma mi hat warrior
        int newLength = player.warriors.length - 1;
        Warriors[] newArray = new Warriors[newLength];
        Warriors[] copyArray = new Warriors[newLength];
        for (int i = 0, j=0; i < player.warriors.length; i++)
        // petqa grel
        {
            if (i == index){
                continue;
            }
            newArray[i] = player.warriors[i-1];
            copyArray[i]= new Warriors(player.warriors[i-1]);
        }
        this.warriors = newArray;
        return newArray;
    }
    public Warriors[] changeArray(Player player,Warriors newWarrior) { // avelacnuma mi hat warrior
        // poxel em
        int newLength = player.warriors.length + 1;
        Warriors[] copyArray = new Warriors[newLength];
        Warriors[] newArray = new Warriors[newLength];
        for (int i = 0; i < player.warriors.length; i++) {
            newArray[i] = player.warriors[i];
            copyArray[i]= new Warriors(player.warriors[i]);
        }
        newArray[newLength - 1] = newWarrior;
        copyArray[newLength - 1] = new Warriors(newWarrior);
        this.warriors = newArray;
        return newArray;
    }

    public void usePower(Player opponent){
        Warriors[] listOfWarriors = opponent.getWarriors();
        for (int i= 0; i< listOfWarriors.length; i++){
            if (listOfWarriors[i].getCurrentHealth()-currentAge.getPower().getDamage()>0){
            listOfWarriors[i] = new Warriors((listOfWarriors[i].getCurrentHealth()-currentAge.getPower().getDamage()),
                    listOfWarriors[i].getAttack(),listOfWarriors[i].getPosition()) ;}
            else{
                changeArray(opponent,i);
            } // check exp and time before using power
        }
        exp = 0;
        timeNeededToUsePower += 120;
        // call power(player, currentAge);
    }
    public void ClickOnAge(){
        if(exp >= 1000){
            changeAge();
            return;
        }
        System.out.println("not enough exp");
    }
    private void changeAge(){
        if(ageIDinArray < 3){
            ageIDinArray++;
            currentAge = Main.arrayOfAges[ageIDinArray]; // karanq "new Age(Main.arrayOfAges[ageIDinArray])"- el anenq
        }
        else {
            System.out.println("last age reached");
        }

    }



    public void addWarriors(Warriors newWarrior) {
        this.warriors = changeArray(this, newWarrior);
    }
    //adds the newly created warrior to the player's warriors array.
    // imasty?





    //    public creatType1Unit(){
//        Type1 type1 = new Type1();
//        changeArray(Coordinates,1); // adds one length
//        Coordinates[Coordinates.length]= type1
//
//    }

    public Age getAge(){
        return new Age(currentAge.getImage(), currentAge.getHealthBonus(),
                currentAge.getAttackBonus(), currentAge.getPowerBonus(),currentAge.getCastleHealthBonus(), currentAge.getTurretDamageBonus(), currentAge.getCostBonus());
    }
    public Warriors[] getWarriors() {
        Warriors[] listOfWarriors = new Warriors[warriors.length];
        for(int i = 0; i< warriors.length;i++){
            listOfWarriors[i] = new Warriors(warriors[i].getCurrentHealth(),warriors[i].getAttack(),warriors[i].getPosition());
        }
        return listOfWarriors;
    }

    public int getCastleHealthNow() {
        return castle.getCastleHealth();
    }
    private void setCastleHealthNow(int castleHealthNow) {
        if(!castle.changeCastleHealth(this)){
            System.out.println("the age wasn't able to change");
        }
    }
    public class UnitMoveOrCreate implements ActionListener{
        public int playerSide;
        public int x = 0;
        public int y = 0;
        Timer t = new Timer(2000, this);
        public String unitImage;
        public UnitMoveOrCreate(int playerSide,String unitImage) {
            this.playerSide = playerSide;
            this.unitImage = unitImage;
            if( playerSide == 1){
                this.x = 1080;
                this.y = 1080;
            }

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            x+= 20;
        }
    }

//  public Warriors getFirstWarrior() {
////        Warriors copyWarrior = new Warriors(warriors[0]);
////        return copyWarrior;
////    }
    public void setDamageFirstWarriorHealth(int damageToWarrior) {
        warriors[0].setCurrentHealth(damageToWarrior);
        if(warriors[0].getCurrentHealth() < 1) {
            changeArray(this);
        }
    }
    protected Age getNextAge(){
        Main.arrayCount++;
        return Main.arrayOfAges[Main.arrayCount];
    }
    protected Turret getNextTurret() {
        return Main.arrayOfTurrets[Main.arrayCount];
    }
}
