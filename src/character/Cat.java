package character;

import controller.Controller;
import weapon.Weapon;

/**
 * @author qanna
 */
public class  Cat extends Player {

       public Cat(String name){
        super(name);
        //此处按顺序添加武器数量，默认武器可随意，不会判定耗尽
        this.getWeaponAmount().add(0);
        this.getWeaponAmount().add(1);
        this.getWeaponAmount().add(1);
        this.getWeaponAmount().add(1);
    }




    /**
     *随机获得攻击工具的选择
     */
    @Override
    public int getWeaponChoice(){
        int verifiedChoice;
        if(this.getBloodVolume()<=this.getAllVolume() && this.getWeaponAmount().get(Weapon.POWER_UP)>0){
            verifiedChoice=Weapon.POWER_UP;
        }
        else{
            verifiedChoice=Controller.randomDistance(0,4);
            if(verifiedChoice==Weapon.POWER_STRIKE && this.getWeaponAmount().get(Weapon.POWER_STRIKE)>0){
                verifiedChoice=Weapon.POWER_STRIKE;
            }
            else if(verifiedChoice==Weapon.CARPET_BOMBING && this.getWeaponAmount().get(Weapon.CARPET_BOMBING)>0){
                verifiedChoice=Weapon.CARPET_BOMBING;
            }
            else {
                verifiedChoice=Weapon.ORDINARY;
            }
        }
        if(verifiedChoice!= Weapon.ORDINARY){
            this.getWeaponAmount().set(verifiedChoice,this.getWeaponAmount().get(verifiedChoice)-1);
        }
        return verifiedChoice;
    }

    /**
     *随机获得攻击力度的选择
     */
    @Override
    public int getPowerByPlayer(){
        return Controller.randomDistance(0,50);
    }
}
