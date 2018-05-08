import card.Deck;
import org.junit.Before;
import org.junit.Test;
import card.Card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class DeckTest {
    private Deck deck;

    @Before
    public void setup(){
        deck = new Deck();
    }

    @Test
    public void deckHas52Cards(){
        assertEquals(52, deck.getNumberOfCards());
    }

    @Test
    public void canGetCard() {
        Card card = deck.getCard();
       assertNotNull(card);
    }
}
