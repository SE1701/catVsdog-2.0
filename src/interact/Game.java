package interact;

import controller.Controller;
import weapon.Weapon;
import weapon.Wind;

/**
 * @author qanna
 */
public class Game {
    protected Controller controller;
    private String name;
//    public static  int  flag=0;
//    public static  int  flag2=0;
//    public static  int  flag3=0;

    public static int INPUT_ERROR = -1;
    public static int ONE = 0;
    public static int TWO = 1;

    public Game(){
        this.controller = new Controller();

    }

    public boolean round() {
        try{
            Wind wind = controller.generateWind();
            System.out.println("当前风速大小及方向:"+wind.getWindSpeed());

            Weapon wp = controller.getAttacker().getWeaponByPlayer();
            System.out.println("攻击者选择了"+wp.getToolName());

            String result = controller.throwWeapon(wp, wind, controller.getAttacker(), controller.getVictim());
            System.out.println(result);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }


    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

}
