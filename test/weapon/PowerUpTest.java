package weapon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PowerUpTest {
    private  PowerUp weapon;
    @Before
    public void setUp() throws Exception {
        weapon=new PowerUp();
    }

    @After
    public void tearDown() throws Exception {
        weapon=null;
    }
    @Test
    public void checkFlag(){
        int actual=weapon.getFlag();
        int expected=1;
        assertEquals(actual,expected);
    }
}