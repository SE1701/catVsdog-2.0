package interact;

import character.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class NewGameTest {
    private  NewGame game;

    @Before
    public void setUp() throws Exception {
        game=new NewGame();
    }

    @After
    public void tearDown() throws Exception {
        game=null;
    }


    @Test
    public void getGameByMode(){
        game.setMode(0);
        boolean expected=true;
        Game actual=game.getGamebyMode();
        Boolean result=actual instanceof OnePlayer;
        assertEquals(expected,result);
    }
    @Test
    public void getChooseMode(){
        String input = "0";
        int mode;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            mode = game.getChooseMode();
        } finally {
            System.setIn(stdin);
        }
        assertEquals(mode,0);

    }
    @Test
    public void verChooseMode(){
        // data = “1” 是为了使递归终止
        String data = "1";
        int input = 0;
        int output;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            output = game.verChooseMode(input);
        } finally {
            System.setIn(stdin);
        }
        assertTrue(output==0 || output==1);

    }
    @Test
    public void getUserInput(){
        // 如果输入不是整数，则会返回-1
        // 如何输入是整数，则令inputToInt为input的int形式即可
        String input = "1";
        int inputToInt = 1;
        int output;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            output = game.getUserInput();
        } finally {
            System.setIn(stdin);
        }
        assertEquals(inputToInt,output);


    }

    @Test
    public void getMode() {
        game.setMode(2);
        int expected=2;
        int actual=game.getMode();
        assertEquals(expected,actual);
    }


}