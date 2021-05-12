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
    public void testScoreGame2Strikes(){
        game.roll(10);
        game.roll(1);
        game.roll(1);
        game.roll(10);
        game.roll(6);
        game.roll(7);
        assertThat("For 5 rolls with a Strike passed",game.score()==50);
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

    @Test
    public void testScoreGameWith11Frame(){
        //1
        game.roll(1);
        game.roll(2);
        //2
        game.roll(2);
        game.roll(5);
        //3
        game.roll(1);
        game.roll(7);
        //4
        game.roll(1);
        game.roll(3);
        //5
        game.roll(1);
        game.roll(2);
        //6
        game.roll(2);
        game.roll(7);
        //7
        game.roll(4);
        game.roll(2);
        //8
        game.roll(1);
        game.roll(7);
        //9
        game.roll(1);
        game.roll(7);
        //10
        //strike
        game.roll(10);
        //11
        //the bonus
        game.roll(1);
        game.roll(2);

        assertThat("For 11 frames ",game.score()==69);
    }
}
