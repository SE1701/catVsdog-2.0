package weapon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeaponTest {
    private Weapon weapon;

    @Before
    public void setUp() throws Exception {
        weapon=new Weapon();
    }

    @After
    public void tearDown() throws Exception {
        weapon=null;
    }

    @Test
    public void getDamage() {
        weapon.setDamage(100);
        int expected=100;
        int actual=weapon.getDamage();
        assertEquals(expected,actual);
    }

    @Test
    public void getRange() {
        weapon.setRange(100);
        int expected=100;
        int actual=weapon.getRange();
        assertEquals(expected,actual);
    }

    @Test
    public void getPosition() {
        weapon.setPosition(100);
        int expected=100;
        int actual=weapon.getPosition();
        assertEquals(expected,actual);
    }

    @Test
    public void getFlag() {
        weapon.setFlag(2);
        int expected=2;
        int actual=weapon.getFlag();
        assertEquals(expected,actual);
    }
}