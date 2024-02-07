package Controller;

import Coder.Main;
import Helper.MyDialog;
import Model.User;
import Service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ForgotPasswordController {

    @FXML
    private PasswordField tf_forgot_password_confirm;

    @FXML
    private TextField tf_forgot_password_name;

    @FXML
    private PasswordField tf_forgot_password_new;


    //check user input name and name in DB
    @FXML
    void checkNameFromDB(MouseEvent event) {
        String inputName = tf_forgot_password_name.getText();
        UserService userService = new UserService();
        if (userService.checkName(inputName)) {
            //MyDialog.show("Equals!!!!!!!!!!!!!!!");
        } else {
            MyDialog.show(inputName + " : doesn't have in database!!!");
            tf_forgot_password_name.setText("");
        }
    }

    //change password
    @FXML
    void changePassword(ActionEvent event) throws IOException {
        String name = tf_forgot_password_name.getText();
        String newPassword = tf_forgot_password_new.getText();
        String confirmPassword = tf_forgot_password_confirm.getText();

        if(name.contentEquals("") || newPassword.contentEquals("") || confirmPassword.contentEquals("")){
            MyDialog.show("Please Fill All Fields");
        }else{
            if (newPassword.contentEquals(confirmPassword)) {
                UserService userService = new UserService();
                User user = userService.getUserByName(name);
                user.setPassword(newPassword);
                if (userService.updateUser(user)) {
                    MyDialog.show("Password Change Successfully!!!");
                    Parent root = FXMLLoader.load(getClass().getResource("../View/login.fxml"));
                    Main.stage.getScene().setRoot(root);
                }
            } else {
                MyDialog.show("Passwords are not match!Try again!!");
            }
        }
    }

    //back to login page
    @FXML
    void backToLoginPage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/login.fxml"));
        Main.stage.getScene().setRoot(root);
    }

    //close app
    @FXML
    void close_app(MouseEvent event) {
        System.exit(0);
    }
}
