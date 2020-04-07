package weapon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrdinaryTest {
    private Ordinary weapon;

    @Before
    public void setUp() throws Exception {
        weapon=new Ordinary();
    }

    @After
    public void tearDown() throws Exception {
        weapon=null;
    }
    @Test
    public void checkFlag(){
        int actual=weapon.getFlag();
        int expected=0;
        assertEquals(actual,expected);
    }

}