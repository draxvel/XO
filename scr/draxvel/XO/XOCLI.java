package draxvel.XO;

import draxvel.XO.model.Field;
import draxvel.XO.model.Figure;
import draxvel.XO.model.Game;
import draxvel.XO.model.Player;
import draxvel.XO.view.ConsoleView;

public class XOCLI {
    public static void main(final String[] args) {
        final String name1= "Nazar";
        final String name2= "Max";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);


        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }
}
