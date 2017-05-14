package application;

import java.util.*;

public class Player {
	// Class Properties
	Stack<Card> cards = new Stack<Card>();
	
	// Class Constructor
	public Player() {}
	
	// Getters
	public Stack<Card> getCards() {
		return cards;
	}
	
	// Class Methods
	public void addToCards(Card card) /*throws Exception*/ {
		if(cards.size() <= (DeckOfCards.DECK_SIZE/2)) {
			cards.push(card);
		} else {
			/*throw new Exception();*/
		}
	}
	
	public Card playCard() /*throws Exception*/ {
		if(cards.size() > 0) {
			return cards.pop();
		} else {
			/*throw new Exception();*/
			return cards.pop();
		}
	}
	
	public void print() {
		for(Card card : getCards()) {
			card.print();
		}
	}
}
