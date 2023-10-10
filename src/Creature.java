public class Creature {
    private static int N = 100;
    private static int M = 10;
    private String name;
    private int attack;
    private int defence;
    private int health;
    private int damage;
    private int healingLeft = 4;

    public Creature(String name, int attack, int defence, int health, int damage) {
        if (attack >= 1 & attack <= 30 & defence >= 1 & defence <= 30) {
            if (health >= 1 & health <= getN()) {
                if (damage >= getM() & damage <= getN()) {
                    this.name = name;
                    this.attack = attack;
                    this.defence = defence;
                    this.health = health;
                    this.damage = damage;
                } else {
                    throw new RuntimeException("damage must be in [" + getM() + ", " + getN() + "]");
                }
            } else {
                throw new RuntimeException("health must be in [1, " + getN() + "]");
            }
        } else {
            throw new RuntimeException("attack and defence must be in [1, 30]");
        }
    }

    public void attack(Creature attackTarget) {
        int attackModifier = this.getAttack() - attackTarget.getDefence();
        boolean success = false;
        if (attackModifier <= 0) {
            if(Math.random()<=(double)(1/3)){
                success = true;
            }
        } else {
            for (int i = 0; i < attackModifier; i++) {
                if (Math.random() <= (double) (1 / 3)) {
                    success = true;
                }
            }
        }
        if(success){
            attackTarget.takeDamage((int)(Math.round(Math.random()*this.getAttack())));
            System.out.println("The creature " + this.getName() + " hit " + attackTarget.getName());
        }else{
            System.out.println("The creature " + this.getName() + " tried to hit " + attackTarget.getName() + " but failed");
        }

    }

    public void takeDamage(int givenDamage){
        this.setHealth(this.getHealth()-givenDamage);
        System.out.println("The creature " + this.getName() + " took " + givenDamage + " damage");
        if(this.getHealth()<=0){
            System.out.println("The creature " + this.getName() + " died!");
        }
    }

    public void heal(){
        if(this.getHealingLeft()>0){
            this.setHealth((int)(Math.round(this.getHealth()+getN()*0.3)));
            this.setHealingLeft(this.getHealingLeft()-1);
            System.out.println("The creature " + this.getName() + " used healing. Health: " + this.getHealth() + ". Healing abilities left: " + this.getHealingLeft());
        }else{
            System.out.println("You've already spent all you healing abilities");
        }
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefence() {
        return defence;
    }
    public static void setN(int n) {
        N = n;
    }
    public static void setM(int m) {
        M = m;
    }
    public static int getN() {
        return N;
    }
    public static int getM() {
        return M;
    }
    private void setHealingLeft(int healingLeft) {
        this.healingLeft = healingLeft;
    }
    public int getHealingLeft() {
        return healingLeft;
    }
}
