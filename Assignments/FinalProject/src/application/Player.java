package application;

import java.util.*;
import customExceptions.*;

public class Player {
	// Class Properties
	private LinkedList<Card> cards = new LinkedList<Card>();
	private String playerName;
	
	// Class Constructor
	public Player(String playerName) {
		this.playerName = playerName;
	}
	
	// Getters
	public LinkedList<Card> getCards() {
		return cards;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public int howManyCards() {
		return cards.size();
	}
	
	// Class Methods
	public void addToCards(Card card) {
		int randomPosition = (int)Math.floor(Math.random() * cards.size());
		cards.add(randomPosition, card);
	}
	
	public Card playCard() throws PlayerNoCardsException {
		if(cards.size() > 0) {
			return cards.removeLast();
		} else {
			throw new PlayerNoCardsException();
		}
	}
	
	public boolean hasCards() {
		if(cards.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void print() {
		for(Card card : getCards()) {
			card.print();
		}
		System.out.println();
	}
}
