package com.example.allymcgilloway.blackjack_solution;

import java.util.ArrayList;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Game {

    private Deck deck;
    private Dealer dealer;
    private Player player;
    private Ui ui;

    public Game(Deck deck, Ui ui, Player player) {
        this.deck = deck;
        this.dealer = new Dealer();
        this.player = player;
        this.ui = ui;
    }


    public void play() {
        dealer.startGame(this.dealer, this.deck);
        dealer.startGame(this.player, this.deck);
        ui.dealCards(this.dealer, this.player);
        if (this.dealer.hasBlackJack() || this.player.hasBlackJack()){
            checkWinner();
        }
        if (this.player.checkAce()) {
            String choice = ui.hasAce(player);
            if (choice.toLowerCase().equals("y")){
                this.player.changeAceValue();
            }
        }
        String option = ui.stickOrTwist(this.player);
        stickOrTwist(option.toLowerCase());
        dealerPlay();

    }



    private void stickOrTwist(String option){
        while (!this.player.isBust() && option.equals("t")) {
            twist(this.player);
            option = ui.stickOrTwist(this.player);
        }
    }

    private void twist(Participant player){
        dealer.dealCard(player, this.deck);
        ui.dealtCard(player);
        if(checkBust(player)){
            ui.bust(player);
        }
    }

    private boolean checkBust(Participant player){
        if (player.getHandValue() > 21){
            player.setBust(true);
        }
        return player.isBust();
    }

    public void dealerPlay(){
        if(this.dealer.checkAce() && this.dealer.getHandValue() < 10) {
            this.dealer.changeAceValue();
        }
        ui.dealerPlay(this.dealer);
        ui.showValue(this.dealer);
        if(this.dealer.getHandValue() < 16){
            this.dealer.dealCard(this.dealer, this.deck);
            ui.dealtCard(this.dealer);
            if(checkBust(this.dealer)){
                ui.showValue(this.dealer);
                ui.dealerBust(this.player.getName());
            } else{
                dealerPlay();
            }
        } else {
            checkWinner();
        }
        ui.dealerPlay(this.dealer);
    }


    public void checkWinner(){
        ui.showResults(this.player, this.dealer);
        if ((this.dealer.getHandValue() == this.player.getHandValue()) || this.dealer.hasBlackJack() && this.player.hasBlackJack()){
            ui.showDraw();
        }
        if (this.dealer.getHandValue() < this.player.getHandValue() || player.hasBlackJack()){
            ui.showWinner(this.player);
        } else {
            ui.showWinner(this.dealer);
        }
    }
}
