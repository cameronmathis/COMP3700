package sample;

public class AccountController {
    public static boolean checkCredentials(javafx.scene.control.TextField username, javafx.scene.control.TextField email, javafx.scene.control.TextField password) {
        for (int i = 0; i < Accounts.accountArrayLength; i++) {
            if (Accounts.checkUsername(username) || Accounts.checkEmail(email)) {
                return false;
            }
        }

        if (Accounts.checkPassword(password)) {
            return false;
        }

        return true;
    }
}