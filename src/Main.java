import Game.Game;

public class Main {

    public static void main(String[] args){
        Game game = new Game();

        game.roll(4);
        game.roll(1);
        game.roll(5);
        game.roll(5);
        game.roll(1);
        game.roll(7);

        System.out.println(game.score());
    }
}
