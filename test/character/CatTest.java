package character;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void getWeaponChoice() {
//        fail();
//        System.out.println(cat.getWeaponChoice());
        assertTrue(cat.getWeaponChoice()>=0&&cat.getWeaponChoice()<2);
    }

    @Test
    public void getPowerByPlayer() {
//        System.out.println(cat.getPowerByPlayer());
        assertTrue(cat.getPowerByPlayer()>=0&&cat.getPowerByPlayer()<50);
    }
}