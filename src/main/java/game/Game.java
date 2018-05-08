package game;

import card.Deck;
import player.Dealer;
import player.Player;

import java.util.ArrayList;

public class Game {
    private Deck deck;
    private ArrayList<Player> players;

    public Game( Deck deck, ArrayList<Player> players) {
        this.deck = deck;
        this.players = players;
    }

    public void playBlackjack() {
        deal();
        Player winner = checkWinner();

    }

    public void twist(Player player){
        player.addCardToHand(deck.getCard());
    }

//    public void play() {
//        deal();
//        Player winner = checkWinner();
//
//    }


    public void deal(){
        for (Player player : players){
            for(int i = 0; i<2; i++) {
                player.addCardToHand(deck.getCard());
            }
        }
    }

    public Player checkWinner(){
        Player dealer1 = players.get(0);
        Player player2 = players.get(1);
        if (dealer1.getHandValue() == player2.getHandValue()){
            return null;
        } else {
            return dealer1.getHandValue() > player2.getHandValue() ?  dealer1 :  player2;
        }

    }
}
