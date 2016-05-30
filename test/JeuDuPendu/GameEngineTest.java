package JeuDuPendu;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by Ludovic on 30/05/2016.
 */
public class GameEngineTest {

    @Test
    public void testNewGameEngine(){
        GameEnginer ge = new GameEnginer();
    }

    @Test
    public void testGame() throws IOException {
        GameEnginer ge = new GameEnginer();
        ge.getMotSecret();
    }

    @Test
    public void testGamelettre() throws IOException {
        GameEnginer ge = new GameEnginer();
        ge.getMotSecret();
        ge.nextGame("a");
    }

}
