package com.example.allymcgilloway.blackjack_solution;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Runner {

    public static void main(String[] args) {
        Ui ui = new Ui();
        Deck deck = new Deck();
        String name = ui.getPlayerName();
        Player player = new Player(name);
        Game game = new Game(deck, ui, player);
        String option = ui.greet(player);
        if(option.equals("q")){
            ui.goodbye();
            System.exit(0);
        }
        game.play();

    }
}
