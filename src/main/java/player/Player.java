package player;

import card.Card;
import card.Hand;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class Player {
    private Hand hand;
    private String name;
    private Boolean stick;
    private Boolean bust;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
        this.stick = false;
        this.bust = false;
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

    public Boolean getStick(){
        return this.stick;
    }

    public void setStick(){
        this.stick = true;
    }

    public Boolean getBust() {
        return bust;
    }

    public void isBust() {
        this.bust = true;
    }
}
