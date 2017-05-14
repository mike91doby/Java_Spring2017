package application;

import customExceptions.*;

import java.util.*;

public class WarCardGame {
	// Class Properties
	public static final int NUMBER_OF_PLAYERS = 2;
	private int roundsOfWar = 2;
	private Player human = new Player("Human");
	private Player computer = new Player("Computer");
	
	// New game constructor
	public WarCardGame() {
		try {
			DeckOfCards deck = new DeckOfCards();
			deck.shuffle();
			handoutCards(deck);
		} catch(DeckException e) {
			System.out.println("Deck configured incorrectly");
		}
	}
	
	// Helper methods
	private void handoutCards(DeckOfCards deck) {
		for(int i = 0; i < DeckOfCards.DECK_SIZE; i++) {
			if(human.getCards().size() <= computer.getCards().size()) {
				human.addToCards(deck.getDeck().removeLast());
			} else {
				computer.addToCards(deck.getDeck().removeLast());
			}
		}
	}
	
	private boolean gameOver() {
		if(!computer.hasCards()) {
			System.out.println(human.getPlayerName() + " wins game");
			return true;
		} else if(!human.hasCards()) {
			System.out.println(computer.getPlayerName() + " wins game");
			return true;
		} else {
			return false;
		}
	}
	
	private void war(LinkedList<Card> warCardPot) {
		try {
			// Initialize placeholder for cards
			Card humansCard = null;
			Card computersCard = null;
			
			// Put cards into the pot
			for(int i = 0; i < roundsOfWar; i++) {
				// Play cards and add to pot
				humansCard = human.playCard();
				warCardPot.add(humansCard);
				computersCard = computer.playCard();
				warCardPot.add(computersCard);
			}
			
			// Display card names
			printCards(humansCard, computersCard);
			
			// Add card to the pile of the player with the most cards
			// or war if they are equal
			if(humansCard.getValue() > computersCard.getValue()) {
				System.out.println(human.getPlayerName() + " wins War!");
				for(Card card : warCardPot) {
					human.addToCards(card);
				}
			} else if(humansCard.getValue() < computersCard.getValue()) {
				System.out.println(computer.getPlayerName() + " wins War!");
				for(Card card : warCardPot) {
					computer.addToCards(card);
				}
			} else if(humansCard.getValue() == computersCard.getValue()) {
				System.out.println("Another War!");
				
				// Go into war only if both players have enough cards
				if(readyForWar(warCardPot)) {
					war(warCardPot);
				}
			}
		} catch(PlayerNoCardsException e) {
			System.out.println("Player has no card to use");
		}
	}
	
	private boolean readyForWar(LinkedList<Card> warCardPot) {
		// If player does not have enough cards to play a round of war
		// Then take that players cards and give them to the other player
		if(human.howManyCards() < roundsOfWar) {
			for(int i = 0; i < human.howManyCards(); i++) {
				warCardPot.add(human.getCards().removeFirst());
			}
			computer.getCards().addAll(warCardPot);
			System.out.println(human.getPlayerName() + " is not ready for war");
			return false;
		} else if (computer.howManyCards() < roundsOfWar) {
			for(int i = 0; i < computer.howManyCards(); i++) {
				warCardPot.add(human.getCards().removeFirst());
			}
			human.getCards().addAll(warCardPot);
			System.out.println(computer.getPlayerName() + " is not ready for war");
			return false;
		}
		return true;
	}
	
	// Class methods
	public boolean playRound() {
		try{
			if(!gameOver()) {
				// Get a card from each player
				Card humansCard = human.playCard();
				Card computersCard = computer.playCard();
				
				// Display card names
				printCards(humansCard, computersCard);
				
				// Add card to the pile of the player with the most cards
				// or war if they are equal
				if(humansCard.getValue() > computersCard.getValue()) {
					human.addToCards(humansCard);
					human.addToCards(computersCard);
					System.out.println(human.getPlayerName() + " wins round");
				} else if(humansCard.getValue() < computersCard.getValue()) {
					computer.addToCards(humansCard);
					computer.addToCards(computersCard);
					System.out.println(computer.getPlayerName() + " wins round");
				} else if(humansCard.getValue() == computersCard.getValue()) {
					System.out.println("War!");
					LinkedList<Card> warCardPot = new LinkedList<Card>();
					warCardPot.add(humansCard);
					warCardPot.add(computersCard);
					
					// Go into war only if both players have enough cards to do so
					if(readyForWar(warCardPot)) {
						war(warCardPot);
					}
				}
				
				printStats();
			//if(!gameOver()) {
			} else {
				// Return false if game is over
				return false;
			}
			
		} catch(PlayerNoCardsException e) {
			System.out.println("Player has no card to use");
		}
		
		// Return true by default
		return true;
	}
	
	public void printCards(Card humansCard, Card computersCard) {
		System.out.print(human.getPlayerName() + "s Card: ");
		humansCard.print();
		System.out.print(computer.getPlayerName() + "s Card: ");
		computersCard.print();
	}
	
	public void printStats() {
		// Print out results
		System.out.println(human.getPlayerName() + " has " + human.howManyCards() + " cards");
		System.out.println(computer.getPlayerName() + " has " + computer.howManyCards() + " cards");
	}
	
	// Main for WarCardGame testing
	public static void main(String[] args) {
		// Create a deck and use it to play war
		WarCardGame war = new WarCardGame();
		
		while(war.playRound()) {
			System.out.println();
		}
	}
}
