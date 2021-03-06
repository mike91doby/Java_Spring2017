package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	// Initialize the war game
	Player playerOne = new Player("Human");
	Player playerTwo = new Player("Computer");
	WarCardGame war = new WarCardGame(playerOne, playerTwo);
				
	@Override
	public void start(Stage primaryStage) {
		try {
			// Set the page title
			primaryStage.setTitle("War!");
			
			// Initialize and configure the grid
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25,25,25,25));
			
			// Set title and text
			VBox vbHeader = new VBox(10);
			Text title = new Text("War!");
			Text space = new Text("");
			title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
			vbHeader.getChildren().add(title);
			vbHeader.getChildren().add(space);
			vbHeader.setAlignment(Pos.TOP_CENTER);
			grid.add(vbHeader, 1, 0, 3, 1);
		
			// Set player one's face-down deck
			Image playerOneDeck = new Image("playingCards/blueDeck.png");
			ImageView playerOneDeckView = new ImageView();
			playerOneDeckView.setImage(playerOneDeck);
			playerOneDeckView.setFitWidth(150);
			playerOneDeckView.setPreserveRatio(true);
			playerOneDeckView.setSmooth(true);
			playerOneDeckView.setCache(true);
			
			// Add player one's face-down deck to the view
			VBox vbPlayerOneDeck = new VBox(10);
			Label playerOneName = new Label(playerOne.getPlayerName());
			Label playerOneNumberOfCards = new Label();
			vbPlayerOneDeck.getChildren().add(playerOneDeckView);
			vbPlayerOneDeck.getChildren().add(playerOneName);
			vbPlayerOneDeck.getChildren().add(playerOneNumberOfCards);
			vbPlayerOneDeck.setAlignment(Pos.CENTER);
			grid.add(vbPlayerOneDeck, 1, 1);
			
			// Add in container for the player's cards
			VBox vbCardsHolder = new VBox();
			grid.add(vbCardsHolder, 2, 1);
			
			// Add information on the last move made
			VBox vbMessage = new VBox(10);
			Label message = new Label();
			vbMessage.getChildren().add(message);
			vbMessage.setAlignment(Pos.CENTER);
			grid.add(vbMessage, 2, 2);
			
			// Set the second player's face-down deck
			Image playerTwoDeck = new Image("playingCards/redDeck.png");
			ImageView playerTwoDeckView = new ImageView();
			playerTwoDeckView.setImage(playerTwoDeck);
			playerTwoDeckView.setFitWidth(150);
			playerTwoDeckView.setPreserveRatio(true);
			playerTwoDeckView.setSmooth(true);
			playerTwoDeckView.setCache(true);
			
			// Add player two's face-down deck to the view
			VBox vbPlayerTwoDeck = new VBox(10);
			Label playerTwoName = new Label(playerTwo.getPlayerName());
			Label playerTwoNumberOfCards = new Label();
			vbPlayerTwoDeck.getChildren().add(playerTwoDeckView);
			vbPlayerTwoDeck.getChildren().add(playerTwoName);
			vbPlayerTwoDeck.getChildren().add(playerTwoNumberOfCards);
			vbPlayerTwoDeck.setAlignment(Pos.CENTER);
			grid.add(vbPlayerTwoDeck, 3, 1);
			
			// Set the scene and show the stage
			Scene scene = new Scene(grid, 800, 800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			// Mouse pressed event to draw a new card
			vbPlayerOneDeck.setOnMousePressed(new EventHandler<MouseEvent>(){
				public void handle(MouseEvent me) {
					// If war is going on
					if(war.getWarDeclared()) {
						// Play a round of war
						war.war();
						
						// Set containers to hold war cards
						HBox hbCards = setCardsView();
						HBox hbFacedownCards = setFacedownCardsView();
						
						// Add both views to primary view
						vbCardsHolder.getChildren().add(hbFacedownCards);
						vbCardsHolder.getChildren().add(hbCards);
					} else {
						// Play a normal round
						war.playRound();
						
						// Set a container with the card's views
						HBox hbCards = setCardsView();
						
						// Clear previous cards and add the new ones
						vbCardsHolder.getChildren().clear();
						vbCardsHolder.getChildren().add(hbCards);
					}
					
					// Update how many cards player one has
					Label playerOneNumberOfCards = new Label(Integer.toString(playerOne.howManyCards()));
					vbPlayerOneDeck.getChildren().remove(2);
					vbPlayerOneDeck.getChildren().add(playerOneNumberOfCards);
					
					// Update the message
					Label message = new Label(war.getOutputMessage());
					vbMessage.getChildren().clear();
					vbMessage.getChildren().add(message);
					
					// Update how many cards player two has
					Label playerTwoNumberOfCards = new Label(Integer.toString(playerTwo.howManyCards()));
					vbPlayerTwoDeck.getChildren().remove(2);
					vbPlayerTwoDeck.getChildren().add(playerTwoNumberOfCards);
					
					// If the game is over then clear cards and output message
					if(war.gameOver()) {
						vbCardsHolder.getChildren().clear();
						message = new Label(war.getOutputMessage());
						vbMessage.getChildren().clear();
						vbMessage.getChildren().add(message);
					}
					
				}
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// Helper methods
	private HBox setCardsView() {
		// Get card images for both players
		Image playerOneCard = new Image("playingCards/" + playerOne.getPathToLastCardImage().toLowerCase());
		Image playerTwoCard = new Image("playingCards/" + playerTwo.getPathToLastCardImage().toLowerCase());
		
		// Create image view for player one's card
		ImageView playerOneCardView = new ImageView();
		playerOneCardView.setImage(playerOneCard);
		playerOneCardView.setFitWidth(150);
		playerOneCardView.setPreserveRatio(true);
		playerOneCardView.setSmooth(true);
		playerOneCardView.setCache(true);
		
		// Create image view for player two's card
		ImageView playerTwoCardView = new ImageView();
		playerTwoCardView.setImage(playerTwoCard);
		playerTwoCardView.setFitWidth(150);
		playerTwoCardView.setPreserveRatio(true);
		playerTwoCardView.setSmooth(true);
		playerTwoCardView.setCache(true);
		
		// Add image views to an hbox
		HBox hbCards = new HBox(10);
		hbCards.getChildren().add(playerOneCardView);
		hbCards.getChildren().add(playerTwoCardView);
		
		// return the hbox
		return hbCards;
	}
	
	private HBox setFacedownCardsView() {
		// Create hbox to hold face down cards
		HBox hbFacedownCards = new HBox(10);
		
		// Create and define player one's face down card
		Image playerOneFacedown = new Image("playingCards/blueDeck.png");
		ImageView playerOneFacedownView = new ImageView();
		playerOneFacedownView.setImage(playerOneFacedown);
		playerOneFacedownView.setFitWidth(150);
		playerOneFacedownView.setPreserveRatio(true);
		playerOneFacedownView.setSmooth(true);
		playerOneFacedownView.setCache(true);
		
		// Create and define player two's face down card
		Image playerTwoFacedown = new Image("playingCards/redDeck.png");
		ImageView playerTwoFacedownView = new ImageView();
		playerTwoFacedownView.setImage(playerTwoFacedown);
		playerTwoFacedownView.setFitWidth(150);
		playerTwoFacedownView.setPreserveRatio(true);
		playerTwoFacedownView.setSmooth(true);
		playerTwoFacedownView.setCache(true);
		
		// Add the face down cards to the hbox
		hbFacedownCards.getChildren().add(playerOneFacedownView);
		hbFacedownCards.getChildren().add(playerTwoFacedownView);
		
		// Return the hbox
		return hbFacedownCards;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
