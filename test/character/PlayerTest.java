package character;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import weapon.*;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player();
    }

    @After
    public void tearDown() throws Exception {
        player = null;
    }

    //测试 Weapon 为 Ordinary 时
    @Test
    public void getWeaponByPlayer_Ordinary() {
//        fail();
        player.setWeaponMode(0);
        Weapon actual = player.getWeaponByPlayer();
        assertTrue(actual instanceof Ordinary);
    }

    //测试 Weapon 为 PowerUp 时
    @Test
    public void getWeaponByPlayer_PowerUp() {
//        fail();
        player.setWeaponMode(1);
        Weapon actual = player.getWeaponByPlayer();
        assertTrue(actual instanceof Ordinary);
    }

    @Test
    public void getWeaponChoice() {
//        fail();
        assertEquals(0,player.getWeaponChoice(),0.01);
    }

    @Test
    public void getPowerByPlayer() {
//        fail();
        assertEquals(0,player.getPowerByPlayer(),0.01);
    }

    //测试 mode = 0 时是否获取 Ordinary（）
    @Test
    public void getWeaponByMode_Ordinary() {
//        fail();
        player.setWeaponMode(0);
        Weapon actual = player.getWeaponByMode();
        assertTrue(actual instanceof Ordinary);
    }

    //测试 mode = 1 时是否获取 PowerUp（）
    @Test
    public void getWeaponByMode_PowerUp() {
//        fail();
        player.setWeaponMode(1);
        Weapon actual = player.getWeaponByMode();
        assertTrue(actual instanceof PowerUp);
    }

    //测试 mode = 2 时是否获取 PowerStrike（）
    @Test
    public void getWeaponByMode_PowerStrike() {
//        fail();
        player.setWeaponMode(2);
        Weapon actual = player.getWeaponByMode();
        assertTrue(actual instanceof PowerStrike);
    }

    //测试 mode = 3 时是否获取 CarpetBombing（）
    @Test
    public void getWeaponByMode_CarpetBombing() {
//        fail();
        player.setWeaponMode(3);
        Weapon actual = player.getWeaponByMode();
        assertTrue(actual instanceof CarpetBombing);
    }


    //测试 获取武器失败
    @Test
    public void getWeaponByMode_Null() {
//        fail();
        player.setWeaponMode(6);
        Weapon actual = player.getWeaponByMode();
        assertTrue(actual == null);
    }


}