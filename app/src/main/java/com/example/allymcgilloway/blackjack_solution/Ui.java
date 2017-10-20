package com.example.allymcgilloway.blackjack_solution;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Ui {

    Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public String getPlayerName() {
        System.out.println("Welcome to BlackJack!\n");
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();
        return name;
    }

    public String greet(Participant player) {
        System.out.println("\nHi " + player.getName());
        System.out.println("\nReady to start? Then press enter. Or 'q' to quit");
        String input = sc.nextLine();
        return input;

    }

    public void goodbye() {
        System.out.println("\nSee ya later alligator!");
        System.exit(1);

    }

    public void dealCards(Dealer dealer, Participant player) {
        System.out.println("The dealer deals.....\n");
        System.out.println(dealer.describeFirstCard());
        pause();
        System.out.println(player.describeHand());
        pause();
    }

    public String stickOrTwist(Participant player) {
        showValue(player);
        System.out.println("\nWould you like to Stick (\"s\") or Twist (\"t\") :");
        String input = sc.nextLine();
        return input;
    }

    public void dealtCard(Participant player){
        pause();
        System.out.println("\nDealer deals " + player.getName() + " the " + player.latestCard().prettyName() + "\n");
        pause();
    }

    public void bust(Participant player){
        pause();
        System.out.println("\nOh... bad luck but you are bust");
        goodbye();
    }

    public String hasAce(Participant player){
        System.out.println("\nYou have an ace. \n Would you like to change its value to 11? (y/n)");
        return sc.nextLine();
    }

    public void showValue(Participant player){
        pause();
        System.out.println("\n" + player.getName() + " has a total of " + player.getHandValue());
        pause();
    }

    public void dealerPlay(Participant dealer){
        pause();
        System.out.println(dealer.describeHand());
        pause();

    }

    public void dealerBust(String name){
        pause();
        System.out.println("\nThe dealer is bust. " + name + " wins the big bucks!");
        goodbye();

    }

    public void showResults(Participant player, Participant dealer){

        for(int i = 0; i<50; i++){
            System.out.print("*");
        }
        if (player.hasBlackJack()){
            System.out.println("\n" + player.getName() + " has BlackJack!)");
        }else {
            System.out.println("\n" + player.getName() + " has a total of " + player.getHandValue() + "\n");
        }
        if (dealer.hasBlackJack()){
            System.out.println("\n" + dealer.getName() + " has BlackJack!)");
        }else {
            System.out.println("\n" + dealer.getName() + " has a total of " + dealer.getHandValue() + "\n");
        }
        pause();
    }

    public void showDraw(){
        System.out.println("It's a draw!");
    }

    public void showWinner(Participant winner){
        System.out.println(winner.getName() + " wins all the moolah!");
        goodbye();
    }

    public void pause(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
