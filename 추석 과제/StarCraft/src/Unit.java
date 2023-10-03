public class Unit {

    private String name;
    private String race;
    private int power;
    private int defense;
    private boolean flyable;
    private boolean attackToFly;


    Unit(String name, String race, int power, int defense, boolean flyable, boolean attackToFly) {
        this.name = name;
        this.race = race;
        this.power = power;
        this.defense = defense;
        this.flyable = flyable;
        this.attackToFly = attackToFly;
    }

    public boolean attack(Unit attackedUnit) {

        if (attackedUnit.getFly() && !attackToFly) {
            return false;
        }

        int afterAttack = attackedUnit.getDefense() - this.power;

        attackedUnit.setDefense(afterAttack);
        
        return true;
    };

    public int getPower() {
        return this.power;
    }

    public int getDefense() {
        return this.defense;
    }

    public boolean getFly() {
        return this.flyable;
    }

    public boolean getAttackToFly() {
        return this.attackToFly;
    }

    public String getName() {
        return this.name;
    }


    public String getRace() {
        return this.race;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }


    @Override
    public String toString() {
        return this.name + " (현재 방어력: " + defense + ")"; 
    }
 }
