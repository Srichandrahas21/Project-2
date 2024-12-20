
public class Hero {
    //Fields
    
    //name of the hero
    private String name;
    //type of hero
    private char type;
    //health of the hero
    private int health;
    //power of the hero
    private double power;
    //attack ability of the hero
    private String attackAbility;
    
    
    /**
     * Constructs a Hero_SA872378 object
     * @param heroName the name of hero
     * @param heroType the type of hero
     * @param heroHealth the health of the hero
     * @param heroPower the power of the hero
     * @param heroAttackAbility the hero attack ability
     */
    //constructor
    public Hero(String heroName, char heroType, int heroHealth, double heroPower, String heroAttackAbility) {
        name = heroName;
        type = heroType;
        health = heroHealth;
        power = heroPower;
        attackAbility = heroAttackAbility;
    }
    
    //getters
    /**
     * this method gets the name of the hero
     * @return the name of the hero
     */
    public String getName() {
        return name;
    }
    
    /**
     * this method gets the type of hero like living of non living
     * @return the type of hero
     */
    public char getType() {
        return type;
    }
    
    /**
     * this method gets the health of the hero
     * @return the health of the hero
     */
    public int getHealth() {
        return health;
    }
    
    /**
     * this method gets the power level of the hero
     * @return the power level of the hero
     */
    public double getPower() {
        return power;
    }
    
    /**
     * this method gets the attack ability aka the superpower
     * @return the attack ability
     */
    public String getAttackAbility() {
        return attackAbility;
    }
    
    
    //setters
    
    /**
     * Sets the name of the hero.
     * @param heroName the name to set for the hero
     */
    public void setName(String heroName) {
        name = heroName;
    }
    
    /**
     * Sets the type of the hero.
     * @param heroType the type to set for the hero
     */
    public void setType(char heroType) {
        type = heroType;
    }
    
    /**
     * Sets the health of the hero.
     * @param heroHealth the health to set for the hero
     */
    public void setHealth(int heroHealth) {
        health = heroHealth;
    }
    
    /** 
     * Sets the power of the hero.
     * @param heroPower the power to set for the hero
     */
    public void setPower(double heroPower) {
        power = heroPower;
    }
    
    /**
     * Sets the attack ability of the hero.
     * @param heroAttackAbility the attack ability to set for the hero
     */
    public void setAttackAbility(String heroAttackAbility) {
        attackAbility = heroAttackAbility;
    }
    
    /**
     * returns the hero's descriptions as strings
     * @return name type health power attackAbility as a string
     */
    public String toString() {
        return "Name: " + name + ", Type: " + type + ", Health: " + health + ", Power: " + power + ", Attack Ability: " + attackAbility;
    }
    
    
    
    
    }
    