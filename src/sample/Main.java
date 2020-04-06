package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    //Variables
    private Stage primaryStage;
    private AnchorPane openingPane;
    private Scene openingScene;
    private Popup PopUp;

    // GUI Interface
    @Override
    public void start(Stage primaryStage) throws Exception {

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
        newOrReturningUserPopUp(); // ask user if they are a new or returning user

    }

    /**
     * HIDE POPUP METHOD
     * Resumes the game
     */
    private void hidePopUp() {
        try {
            PopUp.hide();
            PopUp = null;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * NEW OR RETURNING ACCOUNT POPUP
     * PopUp to ask user if they are new or not
     */
    private void newOrReturningUserPopUp() {
        PopUp = new Popup(); //creates new popup

        TitledPane newOrReturningUserPopUpPane = null; //calls popup menu created in 'newOrReturningUserPopUp.fxml' file

        try {
            newOrReturningUserPopUpPane = FXMLLoader.load(getClass().getResource("newOrReturningUserPopUp.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        PopUp.getContent().add(newOrReturningUserPopUpPane); //adds the popup (child) created in fxml file to the popup (parent) created

        //show popup on primaryStage
        PopUp.show(primaryStage);

        openingPane.requestFocus();

        Button onePlayerBtn = (Button) newOrReturningUserPopUpPane.lookup("#createAccount");
        onePlayerBtn.setOnAction(event -> {
            hidePopUp();
            accountTypePopUp();

        });

        Button twoPlayersBtn = (Button) newOrReturningUserPopUpPane.lookup("#login");
        twoPlayersBtn.setOnAction(event -> {
            hidePopUp();
        });
    }

    /**
     * ACCOUNT TYPE POPUP
     * PopUp to ask user to select an account type
     */
    private void accountTypePopUp() {
        PopUp = new Popup(); //creates new popup

        TitledPane accountTypePopUpPane = null; //calls popup menu created in 'accountTypePopUp.fxml' file

        try {
            accountTypePopUpPane = FXMLLoader.load(getClass().getResource("accountTypePopUp.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        PopUp.getContent().add(accountTypePopUpPane); //adds the popup (child) created in fxml file to the popup (parent) created

        //show popup on primaryStage
        PopUp.show(primaryStage);

        openingPane.requestFocus();

        Button operatorBtn = (Button) accountTypePopUpPane.lookup("#operator");
        operatorBtn.setOnAction(event -> {
            hidePopUp();
            createAccountPopUp();

        });

        Button leagueOwnerBtn = (Button) accountTypePopUpPane.lookup("#leagueOwner");
        leagueOwnerBtn.setOnAction(event -> {
            hidePopUp();
            createAccountPopUp();
        });

        Button playerBtn = (Button) accountTypePopUpPane.lookup("#player");
        playerBtn.setOnAction(event -> {
            hidePopUp();
            createAccountPopUp();
        });

        Button spectatorBtn = (Button) accountTypePopUpPane.lookup("#spectator");
        spectatorBtn.setOnAction(event -> {
            hidePopUp();
            createAccountPopUp();
        });

        Button advertiserBtn = (Button) accountTypePopUpPane.lookup("#advertiser");
        advertiserBtn.setOnAction(event -> {
            hidePopUp();
            createAccountPopUp();
        });
    }

    /**
     * CREATE ACCOUNT POPUP
     * PopUp to create new account
     */
    private void createAccountPopUp() {
        PopUp = new Popup(); //creates new popup

        TitledPane createAccountPopUpPane = null; //calls popup menu created in 'accountInfoPopUp.fxml' file

        try {
            createAccountPopUpPane = FXMLLoader.load(getClass().getResource("accountInfoPopUp.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        PopUp.getContent().add(createAccountPopUpPane); //adds the popup (child) created in fxml file to the popup (parent) created

        //show popup on primaryStage
        PopUp.show(primaryStage);

        TextField t1 = ((TextField) createAccountPopUpPane.lookup("#email"));
        t1.requestFocus();

        Button enterBtn = (Button) createAccountPopUpPane.lookup("#enter");
        TitledPane finalCreateAccountPopUpPane = createAccountPopUpPane;
        enterBtn.setOnAction(event -> {
            if (!(((TextField) finalCreateAccountPopUpPane.lookup("#email")).getText().equals(""))) {
                TextField email = (TextField) finalCreateAccountPopUpPane.lookup("#email");
                // user.setEmail(email.getText());
            }
            if (!(((TextField) finalCreateAccountPopUpPane.lookup("#username")).getText().equals(""))) {
                TextField username = (TextField) finalCreateAccountPopUpPane.lookup("#username");
            }
            if (!(((TextField) finalCreateAccountPopUpPane.lookup("#password")).getText().equals(""))) {
                TextField password = (TextField) finalCreateAccountPopUpPane.lookup("#password");
            }
            hidePopUp();
        });
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
