package com.example.allymcgilloway.blackjack_solution;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public interface Participant {

    public void addCardToHand(Card card);

    public int getHandValue();

    public String describeHand();

    public String getName();

    public Card latestCard();

    public Hand getHand();

    public void setBust(boolean bust);

    public boolean isBust();

    public boolean checkAce();

    public boolean hasBlackJack();

    public void setBlackJack(boolean blackJack);

}
