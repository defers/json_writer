package classesfortests;

public class Weapon {
    private String weaponName;
    private int power;

    public Weapon(String weaponName, int power) {
        this.weaponName = weaponName;
        this.power = power;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
