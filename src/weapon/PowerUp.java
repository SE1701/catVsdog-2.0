package weapon;

/**
 * @author qanna
 */
public class PowerUp extends Weapon {
    public PowerUp() {
        super(-50, 0,"补血工具");
        this.setFlag(POWER_UP);
    }
}
