package classesfortests;

import java.util.List;

public class Player {
    private long exp;
    private int health;
    private String name;
    private Weapon weapon;
    private String[] inventory = {"inv1", "inv2"};
    private int[] inventory2 = {65, 150};
    private List<Integer> inventory3 = List.of(423, 521, 350);

    public Player(long exp, int health, String name, Weapon weapon) {
        this.exp = exp;
        this.health = health;
        this.name = name;
        this.weapon = weapon;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
