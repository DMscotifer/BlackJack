package player;

import card.Card;
import card.Hand;

public class Player {
    private Hand hand;
    private String name;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public int getHandValue() {
        return this.hand.getHandValue();
    }

    public void addCardToHand(Card card) {
        this.hand.addCard(card);
    }





}
