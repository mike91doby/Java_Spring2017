package application;

import java.util.*;

public class DeckOfCards {
	
	// Class Properties
	public final static int DECK_SIZE = 52;
	private final static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
	private LinkedList<Card> deck = new LinkedList<Card>();
	
	// Class Constructor
	public DeckOfCards() /*throws Exception*/ {
		for(String suit : suits) {
			if(DECK_SIZE % suits.length != 0) {
				/*throw new Exception();*/
			}
			
			for(int rank = 0; rank < (DECK_SIZE/suits.length); rank++) {
				deck.add(new Card(rank, suit));
			}
		}
	}
	
	// Getters
	public LinkedList<Card> getDeck() {
		return deck;
	}
	
	// Methods
	public void print() {
		for(Card card : getDeck()) {
			card.print();
		}
	}
	
	public void shuffle() {
		for(int i = 0; i < DECK_SIZE; i++) {
			int randomPosition = (int)Math.floor(Math.random() * DECK_SIZE);
			deck.add(randomPosition, deck.removeLast());
			deck.add(randomPosition, deck.removeFirst());
		}
	}
	
	public void sort() {
		try {
			DeckOfCards deck = new DeckOfCards();
			this.deck = deck.getDeck();
		} catch(Exception e) {
			System.out.println("Uneven ratio of suits per deck.");
		}
	}
	
	// Main for DeckOfCards testing
	public static void main(String[] args) {
		try {
			// Create a deck and print it out
			DeckOfCards deck = new DeckOfCards();
			deck.print();
			System.out.println();
			
			// Shuffle the deck and print it out
			deck.shuffle();
			deck.print();
			System.out.println();
			
			// Sort the deck and print it out
			deck.sort();
			deck.print();
		} catch(Exception e) {
			System.out.println("Uneven ratio of suits per deck.");
		}
	}
}
