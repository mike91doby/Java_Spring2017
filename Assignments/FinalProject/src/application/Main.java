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


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Initialize the war game
			WarCardGame war = new WarCardGame(new Player("Human"), new Player("Computer"));
			
			// Set the page title
			primaryStage.setTitle("War!");
			
			// Initialize and configure the grid
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25,25,25,25));
			
			// Set title and text
			VBox header = new VBox(10);
			Label title = new Label("War!");
			Label winner = new Label();
			header.getChildren().add(title);
			header.getChildren().add(winner);
			header.setAlignment(Pos.TOP_CENTER);
			grid.add(header, 1, 0, 3, 1);
		
			// Set the humans cards
			Image facedownDeck = new Image("playingCards/facedownDeck.jpg");
			ImageView facedownDeckView = new ImageView();
			facedownDeckView.setImage(facedownDeck);
			facedownDeckView.setFitWidth(150);
			facedownDeckView.setPreserveRatio(true);
			facedownDeckView.setSmooth(true);
			facedownDeckView.setCache(true);
			VBox vbFacedownDeck = new VBox(10);
			Label humanName = new Label(war.getHumanPlayer().getPlayerName());
			vbFacedownDeck.getChildren().add(facedownDeckView);
			vbFacedownDeck.getChildren().add(humanName);
			vbFacedownDeck.setAlignment(Pos.CENTER);
			grid.add(vbFacedownDeck, 1, 1);
			
			VBox vbWinner = new VBox(10);
			vbWinner.setAlignment(Pos.CENTER);
			grid.add(vbWinner, 2, 2);
			
			// Set the computers cards
			Image computerFacedown = new Image("playingCards/computerFacedown.jpg");
			ImageView computerFacedownView = new ImageView();
			computerFacedownView.setImage(computerFacedown);
			computerFacedownView.setFitWidth(150);
			computerFacedownView.setPreserveRatio(true);
			computerFacedownView.setSmooth(true);
			computerFacedownView.setCache(true);
			VBox vbcomputerFacedown = new VBox(10);
			vbcomputerFacedown.setAlignment(Pos.CENTER);
			Label computerName = new Label(war.getComputerPlayer().getPlayerName());
			vbcomputerFacedown.getChildren().clear();
			vbcomputerFacedown.getChildren().add(computerFacedownView);
			vbcomputerFacedown.getChildren().add(computerName);
			grid.add(vbcomputerFacedown, 3, 1);
			
			// Mouse pressed event to draw a new card
			vbFacedownDeck.setOnMousePressed(new EventHandler<MouseEvent>(){
				public void handle(MouseEvent me) {
					war.playRound();
					
					Image humansCard = new Image("playingCards/" + war.getHumanCardImg().toLowerCase());
					Image computersCard = new Image("playingCards/" + war.getComputerCardImg().toLowerCase());
					
					ImageView humansCardView = new ImageView();
					humansCardView.setImage(humansCard);
					humansCardView.setFitWidth(150);
					humansCardView.setPreserveRatio(true);
					humansCardView.setSmooth(true);
					humansCardView.setCache(true);
					
					ImageView computersCardView = new ImageView();
					computersCardView.setImage(computersCard);
					computersCardView.setFitWidth(150);
					computersCardView.setPreserveRatio(true);
					computersCardView.setSmooth(true);
					computersCardView.setCache(true);
					
					HBox hbCards = new HBox(10);
					hbCards.getChildren().add(humansCardView);
					hbCards.getChildren().add(computersCardView);
					
					grid.add(hbCards, 2, 1);
					
					Label humanName = new Label(war.getHumanPlayer().getPlayerName());
					Label humanNumCards = new Label(war.getNumHumanCards());
					vbFacedownDeck.getChildren().clear();
					vbFacedownDeck.getChildren().add(facedownDeckView);
					vbFacedownDeck.getChildren().add(humanName);
					vbFacedownDeck.getChildren().add(humanNumCards);
					
					Label winner = new Label(war.getRoundWinner());
					vbWinner.getChildren().clear();
					vbWinner.getChildren().add(winner);
					
					if(war.getGameWinner().length() > 0) {
						header.getChildren().clear();
						Label title = new Label("War!");
						Label gameWinner = new Label(war.getGameWinner());
						header.getChildren().add(title);
						header.getChildren().add(gameWinner);
						header.setAlignment(Pos.TOP_CENTER);
					}
					
					Label computerName = new Label(war.getComputerPlayer().getPlayerName());
					Label computerNumCards = new Label(war.getNumComputerCards());
					vbcomputerFacedown.getChildren().clear();
					vbcomputerFacedown.getChildren().add(computerFacedownView);
					vbcomputerFacedown.getChildren().add(computerName);
					vbcomputerFacedown.getChildren().add(computerNumCards);
					
				}
			});
			
			// Set the scene and show the stage
			Scene scene = new Scene(grid,800,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
