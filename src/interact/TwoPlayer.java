package interact;

import character.Dog;

/**
 * @author qanna
 */
public class TwoPlayer extends Game {
    private static  int flag;
    public TwoPlayer(){
        super();
        this.controller.setAttacker(new Dog("小狗"));
        this.controller.setVictim(new Dog("小猫"));

    }



}
