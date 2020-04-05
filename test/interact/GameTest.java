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

public class GameTest {
    private Game game;
    @Before
    public void setUp() throws Exception {
        game=new Game();
    }

    @After
    public void tearDown() throws Exception {
        game=null;
    }

    @Test
    public void round() {
        Player player=new Cat("CAT");
        Player player2=new Dog("DOG");
        game.controller.setAttacker(player2);
        game.controller.setVictim(player);
        boolean actual;
        String data = "1";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            actual=game.round();
        } finally {
            System.setIn(stdin);
        }

        boolean expected=true;
        assertEquals(expected,actual);

    }

    @Test
    public void getController() {
        Controller controller=new Controller();
        game.setController(controller);
        Controller expected=controller;
        Controller actual=game.getController();
        assertEquals(expected,actual);


    }
}