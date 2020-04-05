package weapon;

/**
 * @author qanna
 */
public class Ordinary extends Weapon {
    public Ordinary() {
        super(20,5,"普通攻击工具");
        this.setFlag(ORDINARY);
    }
}
