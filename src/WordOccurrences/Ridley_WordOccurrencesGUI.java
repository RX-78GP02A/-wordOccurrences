//Author: Marcus Ridley
//Date: 7/18/2021
//Program Name: Ridley_WordOccurrencesGUI
//Purpose: Displays the output of Ridley_WordOccurrences in a GUI

//Declaration of imported classes are shared with Ridley_WordOccurrences,
import java.io.IOException;
import java.util.ArrayList;
import javafx.util.Pair;

//Declaration of imported classes and packages are used to create the GUI.
import javafx.application.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/** Displays the output in a GUI. */
public class Ridley_WordOccurrencesGUI extends Application {

	/** Default start method used by JavaFX to create and modify the stage.
	 *  @param stage Stage object used to display output.
	 *  @throws IOException Needed if the file to be analyzed can't be found. */
	@Override
	public void start(Stage stage) throws IOException {

		//Creates a launch button
		Button button = new Button();
		button.setText("Start Text Analyzer");

		//Creates StackPane object layout and adds launch button
		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		//Creates Scene object startScene to display layout with its size
		Scene startScene = new Scene(layout, 200, 100);

		//Sets title of stage to "Start".
		stage.setTitle("Start");

		//Sets stage's scene to startScene.
		stage.setScene(startScene);

		//Launches stage.
		stage.show();

		//Sets button to call Ridley_WordOccurrences
		button.setOnAction(showTop20 -> {

			//try used here to catch Ridley_WordOccurrences's thrown IOException.
			try {

				//Calls the Ridley_WordOccurrences and stores its output.
				Ridley_WordOccurrences analyzer = new Ridley_WordOccurrences();
				ArrayList<Pair<String, Integer>> top20 = analyzer.main();

				//Text displayed at the top of the results screen.
				Text resultsText = new Text("Top 20 words in text by count:\n");

				//Creates TextFlow object resultsFlow to display results
				TextFlow resultsFlow = new TextFlow();
				resultsFlow.setLayoutX(10);
				resultsFlow.setLayoutY(10);
				resultsFlow.getChildren().add(resultsText);

				//For each of the pairs of data returned from Ridley_TextAnalyzer,
				//displays the information within that pair.
				for (Pair<String, Integer> top : top20) {

					Text countText = new Text("\nCount: ");

					//Count variable in green text
					Text valueText = new Text("" + top.getValue());
					valueText.setFill(Color.GREEN);

					//Inserts tab for readability
					Text wordText = new Text("\tWord: \"");

					//Word variable in red text
					Text keyText = new Text("" + top.getKey());
					keyText.setFill(Color.RED);

					//Ending quote for word variable.
					Text endText = new Text("\"");

					//Adds all created Text objects to resultsFlow.
					resultsFlow.getChildren().addAll(countText, valueText, wordText, keyText, endText);
				}

				//Creates Group object resultsGroup to display resultsFlow.
				Group resultsGroup = new Group(resultsFlow);

				//Creates Scene object resultsScene to display resultsGroup.
				Scene resultsScene = new Scene(resultsGroup, 250, 375);

				//Sets title of stage to "Results" when it displays the results.
				stage.setTitle("Results");

				//Sets stage's scene to resultsScene.
				stage.setScene(resultsScene);

			}

			//Catches the IOException thrown by Ridley_TextAnalyzer.
			//Since the file is hardcoded, this is filled out
			//mostly for the sake of completion.
			catch (IOException e) {

				//Creates Text object errorText used to display error message.
				Text errorText = new Text("IOException has occurred. Can't find file.");

				//Creates TextFlow object errorFlow to display errorText.
				TextFlow errorFlow = new TextFlow();

				//Adds offsets to errorFlow.
				errorFlow.setLayoutX(10);
				errorFlow.setLayoutY(10);

				//Creates Group object errorGroup to display errorFlow.
				Group errorGroup = new Group(errorFlow);

				//Adds errorText to errorFlow.
				errorFlow.getChildren().add(errorText);

				//Creates Scene object errorScene using errorGroup.
				//Also specifies size of errorScene.
				Scene errorScene = new Scene(errorGroup, 225, 50);

				//Sets title of stage to "Error".
				stage.setTitle("Error");

				//Sets stage's scene to errorScene.
				stage.setScene(errorScene);
			}
		});
	}

	/** Launches the start method.
	 *  @param args Default args parameter included in main method. Not used here. */
	public static void main(String[] args) {
		launch(args);
	}
}
