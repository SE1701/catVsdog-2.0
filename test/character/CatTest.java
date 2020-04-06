package character;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import weapon.Weapon;

import static org.junit.Assert.*;

public class CatTest {
    private Cat cat;

    @Before
    public void setUp() throws Exception {
        cat = new Cat("CAT");
    }

    @After
    public void tearDown() throws Exception {
        cat = null;
    }


    //四种工具均可选择时
    @Test
    public void getWeaponChoice_AllWeaponToChoose() {
//        fail();
        int choice = cat.getWeaponChoice();
        assertTrue(choice>=0&&choice<4);
    }

    //不可选补血工具时
    @Test
    public void getWeaponChoice_PowerUpNotEnough() {
//        fail();
        cat.getWeaponAmount().set(Weapon.POWER_UP,0);
        int choice = cat.getWeaponChoice();
        assertTrue(choice == 0||choice == 2||choice == 3);

    }

    //不可选 强力一击 时
    @Test
    public void getWeaponChoice_PowerStrikeNotEnough() {
//        fail();
        cat.getWeaponAmount().set(Weapon.POWER_STRIKE,0);
        int choice = cat.getWeaponChoice();
        assertTrue(choice == 0||choice == 1||choice == 3);
    }

    //不可选 地毯轰炸 时
    @Test
    public void getWeaponChoice_CarpetBombingNotEnough() {
//        fail();
        cat.getWeaponAmount().set(Weapon.CARPET_BOMBING,0);
        int choice = cat.getWeaponChoice();
        assertTrue(choice == 0||choice == 1||choice == 2);
    }


    //只有 普通攻击工具 时
    @Test
    public void getWeaponChoice_OrdinaryOnly() {
//        fail();
        cat.getWeaponAmount().set(Weapon.POWER_UP,0);
        cat.getWeaponAmount().set(Weapon.POWER_STRIKE,0);
        cat.getWeaponAmount().set(Weapon.CARPET_BOMBING,0);
        int choice = cat.getWeaponChoice();
        assertTrue(choice == 0);
    }

    @Test
    public void getPowerByPlayer() {
//        fail();
        int choice = cat.getPowerByPlayer();
        assertTrue(choice>=0&&choice<50);
    }
}