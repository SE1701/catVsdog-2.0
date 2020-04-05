package character;

import weapon.Weapon;

import java.util.Scanner;
/**
 * @author qanna
 */
public class Dog extends Player {

    public Dog(String name) {
        super(name);
        //此处按顺序添加武器数量，默认武器可随意，不会判定耗尽
        this.getWeaponAmount().add(0);
        this.getWeaponAmount().add(1);
        this.getWeaponAmount().add(1);
        this.getWeaponAmount().add(1);
    }


    /**
     *从控制台输入获得攻击工具的选择
     */
    @Override
    public int getWeaponChoice() {
        System.out.println("请选择工具   0：普通攻击工具  1：补血工具（剩余"+this.getWeaponAmount().get(1)+"个）  2：强力一击（剩余"+this.getWeaponAmount().get(2)+"个）  3：地毯轰炸（剩余"+this.getWeaponAmount().get(3)+"个）");
        int choice = getUserInput();
        choice = getVerifiedWeaponChoice(choice);
        return choice;

    }

    /**
     * 验证输入是否正确。如果不正确则重新要求输入
     * 这样处理是为了方便测试
     */
    public int getVerifiedWeaponChoice(int choice) {
        int verifiedChoice = choice;
        boolean weaponisfalse=false;
        boolean weaponnotenough=false;
        weaponisfalse=(verifiedChoice != Weapon.ORDINARY && verifiedChoice != Weapon.POWER_UP && verifiedChoice != Weapon.POWER_STRIKE && verifiedChoice != Weapon.CARPET_BOMBING) ;
        if(!weaponisfalse){
            weaponnotenough=(verifiedChoice!=Weapon.ORDINARY && this.getWeaponAmount().get(verifiedChoice)<=0);
        }

        while(weaponisfalse || weaponnotenough){
            if(weaponisfalse){
                System.out.println("请正确输入：");
            }
            else{
                System.out.println("所选工具数量不足,请重新选择");
            }
            verifiedChoice = getUserInput();
            weaponisfalse=(verifiedChoice != Weapon.ORDINARY && verifiedChoice != Weapon.POWER_UP && verifiedChoice != Weapon.POWER_STRIKE && verifiedChoice != Weapon.CARPET_BOMBING) ;
            if(!weaponisfalse){
                weaponnotenough=(verifiedChoice!=Weapon.ORDINARY && this.getWeaponAmount().get(verifiedChoice)<=0);
            }
        }

        if(verifiedChoice!=Weapon.ORDINARY){
            this.getWeaponAmount().set(verifiedChoice,this.getWeaponAmount().get(verifiedChoice)-1);
        }
        return verifiedChoice;
    }

    /**
     * 从控制台输入获得攻击力度的选择
     */
    @Override
    public int getPowerByPlayer() {
        System.out.println("请选择发射攻击的力度  [0，50)内的整数");
        int power = getUserInput();
        power = getVerifiedPower(power);
        return power;
    }

    /**
     *验证输入是否正确。如果不正确则重新要求输入
     * 这样处理是为了方便测试
     */
    public int getVerifiedPower(int power) {
        int verifiedPower = power;
        while (verifiedPower < 0 || verifiedPower >= this.getHalfVolume()) {
            System.out.println("请正确输入：");
            verifiedPower = getUserInput();
        }
        return verifiedPower;
    }

    public int getUserInput() {
        int num = -1;
        Scanner scanner = new Scanner(System.in);
        try {
            num = scanner.nextInt();
        } catch (Exception e) {
            num = Weapon.INPUT_ERROR;
        }
        return num;
    }
}


