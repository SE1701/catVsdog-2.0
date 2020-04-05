package character;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class DogTest {
    private Dog dog;

    @Before
    public void setUp() throws Exception {
        dog = new Dog("DOG");
    }

    @After
    public void tearDown() throws Exception {
        dog = null;
    }

    //测试选择工具为 0：普通攻击工具 时
    @Test
    public void getWeaponChoice_Zero() {
//        fail();
        String input = "0";
        int actual;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            actual = dog.getWeaponChoice();
        } finally {
            System.setIn(stdin);
        }
        assertEquals(0,actual);
    }

    //测试选择工具为 1：补血工具 时
    @Test
    public void getWeaponChoice_One() {
//        fail();
        String input = "1";
        int actual;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            actual = dog.getWeaponChoice();
        } finally {
            System.setIn(stdin);
        }
        assertEquals(1,actual);
    }

    //测试有效输入为 0 时
    @Test
    public void getVerifiedWeaponChoice_ChoseZero() {
//        fail();
        int expected = 0;
        assertEquals(expected,dog.getVerifiedWeaponChoice(0));
    }

    //测试有效输入为 1 时
    @Test
    public void getVerifiedWeaponChoice_ChoseOne() {
//        fail();
        int expected = 1;
        assertEquals(expected,dog.getVerifiedWeaponChoice(1));
    }

    //测试无效输入
    @Test
    public void getVerifiedWeaponChoice_InvalidChose() {
//        fail();
        String trueInput = "1";
        int actual;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(trueInput.getBytes()));
            actual = dog.getVerifiedWeaponChoice(-1);
        }finally {
            System.setIn(stdin);
        }
        assertEquals(1,actual);
    }

    //测试获取攻击力度
    @Test
    public void getPowerByPlayer() {
//        fail();
        String input = "25";
        int actual;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            actual = dog.getPowerByPlayer();
        } finally {
            System.setIn(stdin);
        }
        assertEquals(25,actual);
    }

    //输入力度有效时
    @Test
    public void getVerifiedPower_ValidPower() {
//        fail();
        int expected = 5;
        assertEquals(expected,dog.getVerifiedPower(5));
    }

    //输入力度无效时
    @Test
    public void getVerifiedPower_InvalidPower() {
//        fail();
        String trueInput = "5";
        int actual;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(trueInput.getBytes()));
            actual = dog.getVerifiedPower(-1);
        }finally {
            System.setIn(stdin);
        }
        assertEquals(5,actual);
    }

    //以下从边界值测试输入力度
    //最小边界值
    @Test
    public void getVerifiedPower_MinPower1() {
//        fail();
        int expected = 0;
        assertEquals(expected,dog.getVerifiedPower(0));
    }

    @Test
    public void getVerifiedPower_MinPower2() {
//        fail();
        int expected = 1;
        assertEquals(expected,dog.getVerifiedPower(1));
    }

    //最大边界值
    @Test
    public void getVerifiedPower_MaxPower1() {
//        fail();
        String trueInput = "5";
        int actual;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(trueInput.getBytes()));
            //测试输入为 50 时
            actual = dog.getVerifiedPower(50);
        }finally {
            System.setIn(stdin);
        }
        assertEquals(5,actual);
    }

    @Test
    public void getVerifiedPower_MaxPower2() {
//        fail();
        String trueInput = "5";
        int actual;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(trueInput.getBytes()));
            //测试输入为 51 时
            actual = dog.getVerifiedPower(51);
        }finally {
            System.setIn(stdin);
        }
        assertEquals(5,actual);
    }

    //以下是等价类测试
    @Test
    public void getUserInput_InputZero() {
//        fail();
        String input = "0";
        int actual;
        InputStream stdin = System.in;
        try{
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            actual = dog.getUserInput();
        }finally {
            System.setIn(stdin);
        }
        assertEquals(0,actual);
    }


    //测试无效输入
    @Test
    public void getUserInput_InvalidInput() {
//        fail();
        String input = "P";
        int actual;
        InputStream stdin = System.in;
        try{
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            actual = dog.getUserInput();
        }finally {
            System.setIn(stdin);
        }
        assertEquals(-1,actual);
    }


}