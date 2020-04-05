package controller;

import character.Cat;
import character.Dog;
import character.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import weapon.Ordinary;
import weapon.PowerUp;
import weapon.Weapon;
import weapon.Wind;

import javax.swing.text.PlainDocument;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.management.PlatformLoggingMXBean;

import static org.junit.Assert.*;

public class ControllerTest {
    private Controller controller;

    @Before
    public void setUp() throws Exception {
        controller = new Controller();
    }

    @After
    public void tearDown() throws Exception {
        controller = null;
    }



    @Test
    public void generateWind() {
//        fail();
        Wind wind = controller.generateWind();
        assertTrue(wind.getWindSpeed()>=-20&&wind.getWindSpeed()<=20);
    }


    //以下采用等价类测试
    //攻击者使用补血工具
    @Test
    public void throwWeapon_WithPowerUp() {
//        fail();
        Weapon wp = new PowerUp();
        Wind wd = new Wind();
        Player attacker = new Player();
        Player victim = new Player();

        String expected = "攻击者血量回升";
        assertEquals(expected,controller.throwWeapon(wp,wd,attacker,victim));

    }

    //攻击者使用攻击工具并击中对方
    @Test
    public void throwWeapon_DogAttackCatAndHit() {
//        fail();
        Weapon wp = new Ordinary();
        Wind wd = new Wind();
        Player attacker = new Dog("DOG");
        Player victim = new Cat("CAT");

        wd.setWindSpeed(10);
        String power = "15";
        String actual;
        String expected = "发射武器的力度为15，武器击中对方";

        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(power.getBytes()));
            actual = controller.throwWeapon(wp,wd,attacker,victim);
        } finally {
            System.setIn(stdin);
        }

        assertEquals(expected,actual);
    }

    //攻击者使用攻击工具未击中对方
    @Test
    public void throwWeapon_DogAttackCatNotHit() {
//        fail();
        Weapon wp = new Ordinary();
        Wind wd = new Wind();
        Player attacker = new Dog("DOG");
        Player victim = new Cat("CAT");

        wd.setWindSpeed(5);
        String power = "5";
        String actual;
        String expected = "发射武器的力度为5，武器未击中对方";

        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(power.getBytes()));
            actual = controller.throwWeapon(wp,wd,attacker,victim);
        } finally {
            System.setIn(stdin);
        }

        assertEquals(expected,actual);
    }


    //以下采用等价类测试
    //满血时补血
    @Test
    public void addBlood_AllBlood() {
//        fail();
        Weapon wp = new PowerUp();
        Player player = new Player();
        player.setBloodVolume(100);
        controller.addBlood(wp,player);
        assertEquals(100,player.getBloodVolume());
    }

    //失血时补血
    @Test
    public void addBlood_LessBlood() {
//        fail();
        Weapon wp = new PowerUp();
        Player player = new Player();
        player.setBloodVolume(20);
        controller.addBlood(wp,player);
        assertTrue(player.getBloodVolume()>20);
    }


    //以下是等价类测试
    //顺风被击中受伤减血
    @Test
    public void getHurt_withInDistAndFollowingWind() {
//        fail();
        Weapon wp = new Ordinary();
        Wind wd = new Wind();
        Player victim = new Player();
        wp.setPosition(20);
        wd.setWindSpeed(7);
        victim.setBloodVolume(80);

        int expected = 60;
        boolean isHit = controller.getHurt(wp,wd,victim);
        int actual = victim.getBloodVolume();
        assertTrue(isHit==true);
        assertEquals(expected,actual);
    }

    //逆风被击中受伤减血
    @Test
    public void getHurt_withInDistAndAgainstTheWind() {
//        fail();
        Weapon wp = new Ordinary();
        Wind wd = new Wind();
        Player victim = new Player();
        wp.setPosition(-10);
        wd.setWindSpeed(35);
        victim.setBloodVolume(80);

        int expected = 60;
        boolean isHit = controller.getHurt(wp,wd,victim);
        int actual = victim.getBloodVolume();
        assertTrue(isHit==true);
        assertEquals(expected,actual);
    }


    //未击中减血
    @Test
    public void getHurt_withoutRange() {
//        fail();
        Weapon wp = new Ordinary();
        Wind wd = new Wind();
        Player victim = new Player();
        wp.setPosition(-10);
        wd.setWindSpeed(45);
        victim.setBloodVolume(80);

        int expected = 80;
        boolean isHit = controller.getHurt(wp,wd,victim);
        int actual = victim.getBloodVolume();
        assertTrue(isHit==false);
        assertEquals(expected,actual);
    }


    //以下采用边界值测试
    @Test
    public void getHurt_minBorder1() {
//        fail();
        Weapon wp = new Ordinary();
        Wind wd = new Wind();
        Player victim = new Player();
        wp.setPosition(-10);
        wd.setWindSpeed(29);
        victim.setBloodVolume(80);

        int expected = 80;
        boolean isHit = controller.getHurt(wp,wd,victim);
        int actual = victim.getBloodVolume();
        assertTrue(isHit==false);
        assertEquals(expected,actual);
    }

    @Test
    public void getHurt_minBorder2() {
//        fail();
        Weapon wp = new Ordinary();
        Wind wd = new Wind();
        Player victim = new Player();
        wp.setPosition(-10);
        wd.setWindSpeed(30);
        victim.setBloodVolume(80);

        int expected = 60;
        boolean isHit = controller.getHurt(wp,wd,victim);
        int actual = victim.getBloodVolume();
        assertTrue(isHit==true);
        assertEquals(expected,actual);
    }

    @Test
    public void getHurt_minBorder3() {
//        fail();
        Weapon wp = new Ordinary();
        Wind wd = new Wind();
        Player victim = new Player();
        wp.setPosition(-10);
        wd.setWindSpeed(31);
        victim.setBloodVolume(80);

        int expected = 60;
        boolean isHit = controller.getHurt(wp,wd,victim);
        int actual = victim.getBloodVolume();
        assertTrue(isHit==true);
        assertEquals(expected,actual);
    }


    @Test
    public void getHurt_maxBorder1() {
//        fail();
        Weapon wp = new Ordinary();
        Wind wd = new Wind();
        Player victim = new Player();
        wp.setPosition(-10);
        wd.setWindSpeed(39);
        victim.setBloodVolume(80);

        int expected = 60;
        boolean isHit = controller.getHurt(wp,wd,victim);
        int actual = victim.getBloodVolume();
        assertTrue(isHit==true);
        assertEquals(expected,actual);
    }


    @Test
    public void getHurt_maxBorder2() {
//        fail();
        Weapon wp = new Ordinary();
        Wind wd = new Wind();
        Player victim = new Player();
        wp.setPosition(-10);
        wd.setWindSpeed(40);
        victim.setBloodVolume(80);

        int expected = 60;
        boolean isHit = controller.getHurt(wp,wd,victim);
        int actual = victim.getBloodVolume();
        assertTrue(isHit==true);
        assertEquals(expected,actual);
    }

    @Test
    public void getHurt_maxBorder3() {
//        fail();
        Weapon wp = new Ordinary();
        Wind wd = new Wind();
        Player victim = new Player();
        wp.setPosition(-10);
        wd.setWindSpeed(41);
        victim.setBloodVolume(80);

        int expected = 80;
        boolean isHit = controller.getHurt(wp,wd,victim);
        int actual = victim.getBloodVolume();
        assertTrue(isHit==false);
        assertEquals(expected,actual);
    }



    //以下采用等价类测试
    //游戏结束
    @Test
    public void gameOver_True() {
//        fail();
        Player player = new Player();
        player.setBloodVolume(-10);
        assertTrue(controller.gameOver(player)==true);
    }

    //游戏未结束
    @Test
    public void gameOver_False() {
//        fail();
        Player player = new Player();
        player.setBloodVolume(10);
        assertTrue(controller.gameOver(player)==false);
    }


    //以下采用边界值测试
    @Test
    public void gameOver_BloodIs1() {
//        fail();
        Player player = new Player();
        player.setBloodVolume(1);
        assertTrue(controller.gameOver(player)==false);
    }

    @Test
    public void gameOver_BloodIs0() {
//        fail();
        Player player = new Player();
        player.setBloodVolume(0);
        assertTrue(controller.gameOver(player)==true);
    }

    @Test
    public void gameOver_BloodMinus1() {
//        fail();
        Player player = new Player();
        player.setBloodVolume(-1);
        assertTrue(controller.gameOver(player)==true);
    }



    @Test
    public void randomDistance() {
//        fail();
        int min = 4;
        int max = 10;
        int actual = Controller.randomDistance(min,max);
        assertTrue(actual>=min&&actual<max);
    }

    //单人模式
    @Test
    public void changeAttacker_OnePlayer() {
//        fail();
        Player attacker = new Dog("DOG");
        Player victim = new Cat("CAT");
        controller.setAttacker(attacker);
        controller.setVictim(victim);
        controller.changeAttacker();
        Player attackerAfter = controller.getAttacker();
        Player victimAfter = controller.getVictim();

        assertTrue(attackerAfter instanceof Cat);
        assertTrue(victimAfter instanceof Dog);

    }

    //双人模式
    @Test
    public void changeAttacker_TwoPlayer() {
//        fail();
        String attacker = "DOG1";
        String victim = "DOG2";
        controller.setAttacker(new Dog(attacker));
        controller.setVictim(new Dog(victim));
        controller.changeAttacker();
        String attackerAfter = controller.getAttacker().getName();
        String victimAfter = controller.getVictim().getName();

        assertEquals(attacker,victimAfter);
        assertEquals(victim,attackerAfter);

    }


}