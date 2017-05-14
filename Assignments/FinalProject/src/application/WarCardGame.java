package application;

import java.util.*;

public class WarCardGame {
	// Class Properties
	Player player1 = new Player();
	Player player2 = new Player();
	
	// New game constructor
	public WarCardGame(DeckOfCards deck) /*throws Exception*/ {
		for(int i = 0; i < DeckOfCards.DECK_SIZE; i++) {
			if(player1.getCards().size() <= player2.getCards().size()) {
				player1.addToCards(deck.getDeck().removeLast());
			} else {
				player2.addToCards(deck.getDeck().removeLast());
			}
		}
	}
	
	// Main for WarCardGame testing
		public static void main(String[] args) {
			/*try {*/
				// Create a deck and use it to play war
				DeckOfCards deck = new DeckOfCards();
				deck.shuffle();
				WarCardGame war = new WarCardGame(deck);
				
				war.player1.print();
				System.out.println();
				war.player2.print();
			/*} catch(Exception e) {
				System.out.println("Error for some reason.");
			}*/
		}
}
