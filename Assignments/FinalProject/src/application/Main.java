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
	@Override
	public void start(Stage primaryStage) {
		try {
			// Initialize the war game
			Player human = new Player("Human");
			Player computer = new Player("Computer");
			WarCardGame war = new WarCardGame(human, computer);
			
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
		
			// Set the humans cards
			Image facedownDeck = new Image("playingCards/blueDeck.png");
			ImageView facedownDeckView = new ImageView();
			facedownDeckView.setImage(facedownDeck);
			facedownDeckView.setFitWidth(150);
			facedownDeckView.setPreserveRatio(true);
			facedownDeckView.setSmooth(true);
			facedownDeckView.setCache(true);
			VBox vbFacedownDeck = new VBox(10);
			Label humanName = new Label(human.getPlayerName());
			vbFacedownDeck.getChildren().add(facedownDeckView);
			vbFacedownDeck.getChildren().add(humanName);
			vbFacedownDeck.setAlignment(Pos.CENTER);
			grid.add(vbFacedownDeck, 1, 1);
			
			// Information on move made
			VBox vbMessage = new VBox(10);
			Label message = new Label();
			vbMessage.getChildren().add(message);
			vbMessage.setAlignment(Pos.CENTER);
			grid.add(vbMessage, 2, 2);
			
			// Set the computers cards
			Image computerFacedown = new Image("playingCards/redDeck.png");
			ImageView computerFacedownView = new ImageView();
			computerFacedownView.setImage(computerFacedown);
			computerFacedownView.setFitWidth(150);
			computerFacedownView.setPreserveRatio(true);
			computerFacedownView.setSmooth(true);
			computerFacedownView.setCache(true);
			VBox vbcomputerFacedown = new VBox(10);
			vbcomputerFacedown.setAlignment(Pos.CENTER);
			Label computerName = new Label(computer.getPlayerName());
			vbcomputerFacedown.getChildren().clear();
			vbcomputerFacedown.getChildren().add(computerFacedownView);
			vbcomputerFacedown.getChildren().add(computerName);
			grid.add(vbcomputerFacedown, 3, 1);
			
			VBox cardsHolder = new VBox();
			grid.add(cardsHolder, 2, 1);
			
			// Mouse pressed event to draw a new card
			vbFacedownDeck.setOnMousePressed(new EventHandler<MouseEvent>(){
				public void handle(MouseEvent me) {
					if(war.getWarDeclared()) {
						war.war();
						
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
						
						Image facedownDeck = new Image("playingCards/blueDeck.png");
						ImageView facedownDeckView = new ImageView();
						facedownDeckView.setImage(facedownDeck);
						facedownDeckView.setFitWidth(150);
						facedownDeckView.setPreserveRatio(true);
						facedownDeckView.setSmooth(true);
						facedownDeckView.setCache(true);
						HBox hbCards = new HBox(10);
						hbCards.getChildren().add(humansCardView);
						
						Image computerFacedown = new Image("playingCards/redDeck.png");
						ImageView computerFacedownView = new ImageView();
						computerFacedownView.setImage(computerFacedown);
						computerFacedownView.setFitWidth(150);
						computerFacedownView.setPreserveRatio(true);
						computerFacedownView.setSmooth(true);
						computerFacedownView.setCache(true);
						hbCards.getChildren().add(computersCardView);
						
						HBox hbFacedown = new HBox(10);
						hbFacedown.getChildren().add(facedownDeckView);
						hbFacedown.getChildren().add(computerFacedownView);
						cardsHolder.getChildren().add(hbFacedown);
						cardsHolder.getChildren().add(hbCards);
					} else {
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
						
						cardsHolder.getChildren().clear();
						cardsHolder.getChildren().add(hbCards);
					}
					
					Label humanName = new Label(human.getPlayerName());
					Label humanNumCards = new Label(war.getNumHumanCards());
					vbFacedownDeck.getChildren().clear();
					vbFacedownDeck.getChildren().add(facedownDeckView);
					vbFacedownDeck.getChildren().add(humanName);
					vbFacedownDeck.getChildren().add(humanNumCards);
					
					Label message = new Label(war.getOutputMessage());
					vbMessage.getChildren().clear();
					vbMessage.getChildren().add(message);
					
					Label computerName = new Label(computer.getPlayerName());
					Label computerNumCards = new Label(war.getNumComputerCards());
					vbcomputerFacedown.getChildren().clear();
					vbcomputerFacedown.getChildren().add(computerFacedownView);
					vbcomputerFacedown.getChildren().add(computerName);
					vbcomputerFacedown.getChildren().add(computerNumCards);
					
					if(war.gameOver()) {
						cardsHolder.getChildren().clear();
						message = new Label(war.getOutputMessage());
						vbMessage.getChildren().clear();
						vbMessage.getChildren().add(message);
					}
					
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
