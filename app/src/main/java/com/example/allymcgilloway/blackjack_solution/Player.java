package com.example.allymcgilloway.blackjack_solution;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Player implements Participant {
    private Hand hand;
    private String name;
    private boolean isBust;
    private boolean blackJack;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.isBust = false;
        this.blackJack = false;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isBust() {
        return isBust;
    }

    public boolean hasBlackJack(){return blackJack;};

    @Override
    public void addCardToHand(Card card) {
        this.hand.addCard(card);
    }

    @Override
    public int getHandValue() {
        return this.hand.getHandValue();
    }

    public boolean checkAce() {
        for (Card card : this.hand.getCards()) {
            if (card.getRank().equals(Rank.ACE)) {
                return true;
            }
        }
        return false;
    }

    public void changeAceValue() {
        this.hand.changeAceValue();
    }

    @Override
    public String describeHand() {
        String handText = this.name + " has:";
        for (Card card : this.hand.getCards()) {
            handText += "\n" + card.prettyName();
        }
        return handText;
    }

    public Card latestCard() {
        return this.hand.getCards().get(this.hand.getCards().size() - 1);
    }

    public void setBust(boolean bust) {
        this.isBust = bust;
    }

    public void setBlackJack(boolean blackjack){
        this.blackJack = blackjack;
    }
}
