package weapon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarpetBombingTest
{
    private CarpetBombing weapon;

    @Before
    public void setUp() throws Exception {
        weapon=new CarpetBombing();
    }

    @After
    public void tearDown() throws Exception {
        weapon=null;
    }

    @Test
    public void checkFlag(){
        int actual= weapon.getFlag();
        int expected=3;
        assertEquals(actual,expected);
    }
}