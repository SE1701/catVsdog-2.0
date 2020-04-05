package weapon;

/**
 * @author qinhan
 */
public class PowerStrike extends Weapon {
    public PowerStrike() {
        super(40, 5,"强力一击");
        this.setFlag(POWER_STRIKE);
    }
}
