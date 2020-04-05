package weapon;

/**
 * @author qanna
 */
public class Weapon {
    /**
     * damage:伤害大小
     * range:伤害范围
     * position:工具落下的位置
     * toolName：工具名称
     */
    protected int damage;
    protected int range;
    private int position;
    private String toolName;

    private int flag;

    public static final int INPUT_ERROR = -1;
    public static final int ORDINARY = 0;
    public static final int POWER_UP = 1;
    public static final int POWER_STRIKE = 2;
    public static final int CARPET_BOMBING = 3;

    public Weapon(){
    }

    public Weapon(int damage, int range, String name){
        this.damage = damage;
        this.range = range;
        this.toolName = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getToolName() {
        return toolName;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

}
