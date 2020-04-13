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
    private Account[] accounts = new Account[100];
    private int accountArrayLength = 5; // Initialize to 5 for the 5 demo accounts created
    private Account accountLoggedIn;

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

        /** Create 5 demo accounts */
        // Demo operator account
        accounts[0] = AccountFactory.buildAccount(AccountType.OPERATOR);
        accounts[0].setEmail("operator@email.com");
        accounts[0].setUsername("operator");
        accounts[0].setPassword("password");
        // Demo league owner account
        accounts[1] = AccountFactory.buildAccount(AccountType.LEAGUEOWNER);
        accounts[1].setEmail("leagueowner@email.com");
        accounts[1].setUsername("leagueowner");
        accounts[1].setPassword("password");
        // Demo league owner account
        accounts[2] = AccountFactory.buildAccount(AccountType.PLAYER);
        accounts[2].setEmail("player@email.com");
        accounts[2].setUsername("player");
        accounts[2].setPassword("password");
        // Demo league owner account
        accounts[3] = AccountFactory.buildAccount(AccountType.SPECTATOR);
        accounts[3].setEmail("spectator@email.com");
        accounts[3].setUsername("spectator");
        accounts[3].setPassword("password");
        // Demo league owner account
        accounts[4] = AccountFactory.buildAccount(AccountType.ADVERTISER);
        accounts[4].setEmail("advertiser@email.com");
        accounts[4].setUsername("advertiser");
        accounts[4].setPassword("password");
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
     * NEW OR RETURNING USER POPUP
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

        Button createAccountBtn = (Button) newOrReturningUserPopUpPane.lookup("#createAccount");
        createAccountBtn.setOnAction(event -> {
            hidePopUp();
            accountTypePopUp();

        });

        Button loginBtn = (Button) newOrReturningUserPopUpPane.lookup("#login");
        loginBtn.setOnAction(event -> {
            hidePopUp();
            accountLoginPopUp();
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
            accounts[accountArrayLength] = AccountFactory.buildAccount(AccountType.OPERATOR);
            createAccountPopUp();

        });

        Button leagueOwnerBtn = (Button) accountTypePopUpPane.lookup("#leagueOwner");
        leagueOwnerBtn.setOnAction(event -> {
            hidePopUp();
            accounts[accountArrayLength] = AccountFactory.buildAccount(AccountType.LEAGUEOWNER);
            createAccountPopUp();
        });

        Button playerBtn = (Button) accountTypePopUpPane.lookup("#player");
        playerBtn.setOnAction(event -> {
            hidePopUp();
            accounts[accountArrayLength] = AccountFactory.buildAccount(AccountType.PLAYER);
            createAccountPopUp();
        });

        Button spectatorBtn = (Button) accountTypePopUpPane.lookup("#spectator");
        spectatorBtn.setOnAction(event -> {
            hidePopUp();
            accounts[accountArrayLength] = AccountFactory.buildAccount(AccountType.SPECTATOR);
            createAccountPopUp();
        });

        Button advertiserBtn = (Button) accountTypePopUpPane.lookup("#advertiser");
        advertiserBtn.setOnAction(event -> {
            hidePopUp();
            accounts[accountArrayLength] = AccountFactory.buildAccount(AccountType.ADVERTISER);
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
                accounts[accountArrayLength].setEmail(email.getText());
            }
            if (!(((TextField) finalCreateAccountPopUpPane.lookup("#username")).getText().equals(""))) {
                TextField username = (TextField) finalCreateAccountPopUpPane.lookup("#username");
                accounts[accountArrayLength].setUsername(username.getText());
            }
            if (!(((TextField) finalCreateAccountPopUpPane.lookup("#password")).getText().equals(""))) {
                TextField password = (TextField) finalCreateAccountPopUpPane.lookup("#password");
                accounts[accountArrayLength].setPassword(password.getText());
            }
            accountLoggedIn = accounts[accountArrayLength];
            hidePopUp();
            accountArrayLength++;
        });
    }

    /**
     * ACCOUNT LOGIN POPUP
     * PopUp to login to account
     */
    private void accountLoginPopUp() {
        PopUp = new Popup(); //creates new popup

        TitledPane accountLoginPopUpPane = null; //calls popup menu created in 'accountLoginPopUp.fxml' file

        try {
            accountLoginPopUpPane = FXMLLoader.load(getClass().getResource("accountLoginPopUp.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        PopUp.getContent().add(accountLoginPopUpPane); //adds the popup (child) created in fxml file to the popup (parent) created

        //show popup on primaryStage
        PopUp.show(primaryStage);

        TextField t1 = ((TextField) accountLoginPopUpPane.lookup("#username"));
        t1.requestFocus();

        Button enterBtn = (Button) accountLoginPopUpPane.lookup("#enter");
        TitledPane finalCreateAccountPopUpPane = accountLoginPopUpPane;
        enterBtn.setOnAction(event -> {
            TextField username = new TextField();
            TextField password = new TextField();
            ;
            if (!(((TextField) finalCreateAccountPopUpPane.lookup("#username")).getText().equals(""))) {
                username = (TextField) finalCreateAccountPopUpPane.lookup("#username");
            } else {
                accountLoginPopUp();
            }
            if (!(((TextField) finalCreateAccountPopUpPane.lookup("#password")).getText().equals(""))) {
                password = (TextField) finalCreateAccountPopUpPane.lookup("#password");
            } else {
                accountLoginPopUp();
            }

            for (int i = 0; i < accountArrayLength; i++) {
                if (accounts[i].getUsername().equals(username.getText()) && accounts[i].getPassword().equals(password.getText())) {
                    accountLoggedIn = accounts[i];
                    hidePopUp();
                    return;
                }
            }
            hidePopUp();
            incorrectLoginPopUp();
        });
    }

    /**
     * NAME TOO LONG POPUP
     * PopUp for when a player tries to enter an invalid username
     */
    private void incorrectLoginPopUp() {
        PopUp = new Popup(); //creates new popup

        TitledPane incorrectLoginPopUp = null; //calls popup menu created in 'incorrectLoginPopUp.fxml' file

        try {
            incorrectLoginPopUp = FXMLLoader.load(getClass().getResource("incorrectLoginPopUp.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        PopUp.getContent().add(incorrectLoginPopUp); //adds the popup (child) created in fxml file to the popup (parent) created

        //show popup on primaryStage
        PopUp.show(primaryStage);

        Button dismissBtn = (Button) incorrectLoginPopUp.lookup("#dismiss");

        dismissBtn.setOnAction(event -> {
            hidePopUp();
            accountLoginPopUp();
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
