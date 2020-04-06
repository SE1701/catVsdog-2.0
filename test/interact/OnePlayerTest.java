package interact;

import character.Cat;
import character.Dog;
import character.Player;
import controller.Controller;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class OnePlayerTest {
    OnePlayer onegame;
    @Before
    public void setUp() throws Exception {
        onegame=new OnePlayer();
    }

    @After
    public void tearDown() throws Exception {
        onegame=null;
    }
    @Test
    public  void check(){
        Player actual= onegame.controller.getAttacker();
        Player expected=actual;
        assertEquals(expected,actual);
    }

}