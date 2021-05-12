package Test;

import Game.Game;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;


public class TestGame {

    private Game game;

    @Before
    public void setGame(){
        game = new Game();
    }

    @Test
    public void testScoreGame(){
        game.roll(4);
        game.roll(5);
        game.roll(6);
        game.roll(7);
        assertThat("For 4 rolls without any Spare or Strike passed",game.score()==22);
    }

    @Test
    public void testScoreGameStrike(){
        game.roll(4);
        game.roll(1);
        game.roll(10);
        game.roll(6);
        game.roll(7);
        assertThat("For 5 rolls with a Strike passed",game.score()==41);
    }

    @Test
    public void testScoreGameSpare(){
        game.roll(4);
        game.roll(1);
        game.roll(5);
        game.roll(5);
        game.roll(1);
        game.roll(7);
        assertThat("For 6 rolls with a Spare passed",game.score()==24);
    }
}
