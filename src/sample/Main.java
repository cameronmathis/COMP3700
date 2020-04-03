package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    //Variables
    private Stage primaryStage;
    private AnchorPane openingPane;
    private Scene openingScene;

    // GUI Interface
    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage; //sets this primaryStage as 'the' primaryStage
        openingPane = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

        /**
         * MAIN STAGE CREATED
         * Main Stage and Scene Created and shown
         */
        openingScene = new Scene(openingPane); //creates a new scene from 'HomePage.fxml'
        primaryStage.setScene(openingScene); //sets the scene on the stage
        primaryStage.setAlwaysOnTop(false); //set to false to show popups
        primaryStage.setResizable(false); //makes app able to be resized
        primaryStage.show(); //shows the primaryStage
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
