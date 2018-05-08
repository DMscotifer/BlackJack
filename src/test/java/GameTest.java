import card.*;
import game.Game;
import org.junit.Before;
import org.junit.Test;
import player.Dealer;
import player.Player;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Deck deck;
    Dealer dealer;
    Player player1;
    Player player2;
    ArrayList<Player> players;
    Game game;

    @Before
    public void before(){
        dealer = new Dealer("Dealer", new Hand());
        player1 = new Player("player.Player 1", new Hand());
        player2 = new Player("player.Player 2", new Hand());
        players = new ArrayList<>();
        players.add(dealer);
        players.add(player1);
        players.add(player2);
        deck = new Deck();
        game = new Game( deck, players);
    }


    @Test
    public void checkDeal(){
        game.deal();
        assertEquals(2, player1.getHand().getNumberOfCards());
        assertEquals(2, player2.getHand().getNumberOfCards());
    }
    @Test
    public void player1Wins(){
        player1.addCardToHand(new Card(Suit.CLUBS, Rank.ACE));
        player2.addCardToHand(new Card(Suit.DIAMONDS, Rank.EIGHT));
        Player winner = game.checkWinner();
        assertEquals("player.Player 1", winner.getName());
    }

    @Test
    public void canBlackjack() {
        player1.addCardToHand(new Card(Suit.CLUBS, Rank.ACE));
        player1.addCardToHand(new Card(Suit.CLUBS, Rank.KING));
        assertEquals(21, player1.getHandValue());
    }

    //
//    @Test
//    public void player2Wins(){
//        player1.addCardToHand(new Card(Suit.CLUBS, Rank.THREE));
//        player2.addCardToHand(new Card(Suit.DIAMONDS, Rank.EIGHT));
//        Player winner = game.checkWinner();
//        assertEquals("player.Player 2", winner.getName());
//    }
//
//    @Test
//    public void checkDraw(){
//        player1.addCardToHand(new Card(Suit.CLUBS, Rank.ACE));
//        player2.addCardToHand(new Card(Suit.DIAMONDS, Rank.ACE));
//        Player winner = game.checkWinner();
//        assertEquals(null, winner);
//    }


    @Test
    public void canTwist() {
        game.deal();
        game.twist(player1);
        assertEquals(3, player1.getHand().getNumberOfCards());
    }

    @Test
    public void canStick() {
        player1.setStick();
        assertEquals(true, player1.getStick());
    }

    @Test
    public void checkIfPlayerIsBust() {
        game.deal();
        player1.addCardToHand(new Card(Suit.DIAMONDS, Rank.EIGHT));
        player1.addCardToHand(new Card(Suit.DIAMONDS, Rank.EIGHT));
        player1.addCardToHand(new Card(Suit.DIAMONDS, Rank.EIGHT));
        assertEquals(true, game.checkForBust(player1));
    }

    @Test
    public void dealerCanBlackjack() {
        dealer.addCardToHand(new Card(Suit.DIAMONDS, Rank.KING));
        dealer.addCardToHand(new Card(Suit.DIAMONDS, Rank.ACE));
        player1.addCardToHand(new Card(Suit.DIAMONDS, Rank.EIGHT));
        assertEquals(dealer, game.checkWinner());
    }
}
