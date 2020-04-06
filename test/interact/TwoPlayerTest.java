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

public class TwoPlayerTest {

    private TwoPlayer game;
    @Before
    public void setUp() throws Exception {
        game=new TwoPlayer();
    }

    @After
    public void tearDown() throws Exception {
        game=null;
    }
    @Test
    public  void check(){
        Player actual= game.controller.getAttacker();
        Player expected=actual;
        assertEquals(expected,actual);
    }

}