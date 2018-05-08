import card.Hand;
import card.Rank;
import card.Suit;
import org.junit.Before;
import org.junit.Test;
import card.Card;

import static org.junit.Assert.assertEquals;

public class HandTest {

    Hand hand;
    Card card;
    Card card2;
    @Before
    public void setup(){
        hand = new Hand();
        card = new Card(Suit.CLUBS, Rank.JACK);

    }

    @Test
    public void valueIs0Initially(){
        assertEquals(0, hand.getHandValue());
    }

    @Test
    public void cardIsAdded(){
        hand.addCard(card);
        assertEquals(1, hand.getCards().size());
    }

    @Test
    public void handHasValue(){
        hand.addCard(card);
        assertEquals(10, hand.getHandValue());
    }

    @Test
    public void handHasSuit(){
        hand.addCard(card);
        assertEquals(Suit.CLUBS, hand.getCards().get(0).getSuit());
    }


}
