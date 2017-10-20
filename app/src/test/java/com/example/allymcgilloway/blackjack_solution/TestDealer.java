package com.example.allymcgilloway.blackjack_solution;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class TestDealer {

    Dealer dealer;
    Dealer spyDealer;
    Deck deck;
    Deck spyDeck;
    Card card1;
    Card card2;

    @Before
    public void setup(){
        deck = new Deck();
        dealer = new Dealer();
        spyDeck = Mockito.spy(deck);
        spyDealer = new Dealer();
        card1 = new Card(Suit.HEARTS, Rank.ACE);
        card2 = new Card(Suit.CLUBS, Rank.QUEEN);
    }

    @Test
    public void dealerCanDeal(){
        Mockito.when(spyDeck.getCard()).thenReturn(new Card(Suit.CLUBS, Rank.ACE));
        spyDealer.dealCard(dealer, spyDeck);
        assertEquals(1, dealer.getHand().getNumberOfCards());
        assertEquals(Suit.CLUBS, dealer.getHand().getCards().get(0).getSuit());
        assertEquals(Rank.ACE, dealer.getHand().getCards().get(0).getRank());

    }

    @Test
    public void dealerHasAce(){
        Mockito.when(spyDeck.getCard()).thenReturn(new Card(Suit.CLUBS, Rank.ACE));
        spyDealer.dealCard(dealer, spyDeck);
        Mockito.when(spyDeck.getCard()).thenReturn(new Card(Suit.CLUBS, Rank.JACK));
        spyDealer.dealCard(dealer, spyDeck);
        assertEquals(true, dealer.checkAce());
    }

    @Test
    public void testBlackJack(){
        dealer.getHand().addCard(card1);
        dealer.getHand().addCard(card2);
        dealer.getHand().checkBlackJack(dealer);
        assertEquals(true, dealer.hasBlackJack());
    }

}
