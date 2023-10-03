

enum TERRAN{
    Marine("Marine",3, 10, false, false),
    Tank("Tank", 7, 15, false, false),
    Goliath("Goliath", 5, 15, false, true),
    Wraith("Wraith", 3, 10, true, true),
    Valkyrie("Valkyrie", 4, 12, true, true),
    BattleCruzer("BattleCruzer", 20, 30, true, true); // 추가된 유닛
    private final String name;
    private final int power;
    private final int defense;
    private final boolean flyable;
    private final boolean attackToFly;
    

    TERRAN(String name, int power, int defense, boolean flyable, boolean attackToFly) {
        this.name = name;
        this.power = power;
        this.defense = defense;
        this.flyable = flyable;
        this.attackToFly = attackToFly;
    }

    public String getName() { 
        return this.name;
    }

    public int getPoewer() {
        return this.power;
    }

    public int getDefense() {
        return this.defense;
    }

    public boolean getFlyable() {
        return this.flyable;
    }

    public boolean getAttackToFly() {
        return this.attackToFly;
    }

}


enum PROTOS{
    Zealot("Zealot",5, 20, false, false),
    Dragoon("Dragoon", 3, 15, false, true),
    HighTempler("HighTempler", 10, 2, false, false),
    Scout("Scout", 5, 10, true, true),
    Corsair("Cosair", 4, 12, true, true),
    Carrier("Carrier", 25, 40, true, true);

    private final String name;
    private final int power;
    private final int defense;
    private final boolean flyable;
    private final boolean attackToFly;
    

    PROTOS(String name, int power, int defense, boolean flyable, boolean attackToFly) {
        this.name = name;
        this.power = power;
        this.defense = defense;
        this.flyable = flyable;
        this.attackToFly = attackToFly;
    }

    public String getName() { 
        return this.name;
    }

    public int getPoewer() {
        return this.power;
    }

    public int getDefense() {
        return this.defense;
    }

    public boolean getFlyable() {
        return this.flyable;
    }

    public boolean getAttackToFly() {
        return this.attackToFly;
    }

}


enum ZERG{
    Zergling("Zergling",2, 2, false, false),
    Hydralis("Hydralist", 3, 7, false, true),
    Ultralisk("Ultralisk", 5, 15, false, false),
    Mutalisk("Mutalisk", 2, 8, true, true),
    Guardian("Guardian", 3, 6, true, true),
    Queen("Queen", 15, 25, true, true);

    private final String name;
    private final int power;
    private final int defense;
    private final boolean flyable;
    private final boolean attackToFly;
    

    ZERG(String name, int power, int defense, boolean flyable, boolean attackToFly) {
        this.name = name;
        this.power = power;
        this.defense = defense;
        this.flyable = flyable;
        this.attackToFly = attackToFly;
    }

    public String getName() { 
        return this.name;
    }

    public int getPoewer() {
        return this.power;
    }

    public int getDefense() {
        return this.defense;
    }

    public boolean getFlyable() {
        return this.flyable;
    }

    public boolean getAttackToFly() {
        return this.attackToFly;
    }

}



