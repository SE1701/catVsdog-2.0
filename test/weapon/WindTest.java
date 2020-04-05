package weapon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WindTest {
    private  Wind wind;

    @Before
    public void setUp() throws Exception {
        wind=new Wind();

    }

    @After
    public void tearDown() throws Exception {
        wind=null;
    }

    @Test
    public void getWindSpeed() {
        wind.setWindSpeed(10);
        int expected=10;
        int actual=wind.getWindSpeed();
        assertEquals(expected,actual);
    }

    @Test
    public void getWindRange() {
        wind.setWindRange(10);
        int expected=10;
        int actual=wind.getWindRange();
        assertEquals(expected,actual);
    }

}