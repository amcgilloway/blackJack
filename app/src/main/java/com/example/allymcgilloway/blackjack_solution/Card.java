package com.example.allymcgilloway.blackjack_solution;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return this.rank.getValue();
    }

    public String prettyName(){
        return (rank.getName() + " of " + suit.getSuit());
    }
}
