package interact;

import character.Cat;
import character.Dog;

/**
 * @author qanna
 */
public class OnePlayer extends Game {
    public static int  flag;
    public OnePlayer(){
        super();
        this.controller.setAttacker(new Dog("小狗"));
        this.controller.setVictim(new Cat("小猫"));

    }


}
