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

public class UserRegisterController {

    @FXML
    private TextField registration_form_address;

    @FXML
    private TextField registration_form_email;

    @FXML
    private TextField registration_form_name;

    @FXML
    private TextField registration_form_nrc;

    @FXML
    private PasswordField registration_form_password;

    @FXML
    private TextField registration_form_phone;

    //check user input name and name in DB
    @FXML
    void checkNameFromDB(MouseEvent event) {
        String inputName = registration_form_name.getText();
        UserService userService = new UserService();
        if (userService.checkName(inputName)) {
            MyDialog.show("This Name is already have in DB, Try another Name!!!");
            registration_form_name.setText("");
        } else {
            //MyDialog.show("Name isn't have in DB");
        }
    }

    @FXML
    void checkEmailFromDB(MouseEvent event) {
        String inputEmail = registration_form_email.getText();
        UserService userService = new UserService();
        if (userService.checkEmail(inputEmail)) {
            MyDialog.show("This Email is already have in DB, Try another Name!!!");
            registration_form_name.setText("");
        }
    }

    @FXML
    void checkNRCFromDB(MouseEvent event) {
        String inputnrc = registration_form_nrc.getText();
        UserService userService = new UserService();
        if (userService.checkNRC(inputnrc)) {
            MyDialog.show("This NRC is already have in DB, Try another Name!!!");
            registration_form_nrc.setText("");
        }
    }

    //user registration process
    @FXML
    void createUserRegistration(ActionEvent event) throws IOException {
        String name = registration_form_name.getText();
        String nrc = registration_form_nrc.getText();
        String email = registration_form_email.getText();
        String password = registration_form_password.getText();
        String address = registration_form_address.getText();
        String str_phone = registration_form_phone.getText();
        int phone = Integer.parseInt(str_phone);

        UserService userService = new UserService();
        User user = new User(0, phone, name, nrc, email, password, address, false);

        if (name.contentEquals("") || nrc.contentEquals("") || email.contentEquals("") || password.contentEquals("") || address.contentEquals("") || str_phone.contentEquals("")) {
            MyDialog.show("Please Fill All Fields");
        } else {
            if (userService.saveUser(user)) {
                MyDialog.show("User Create Successfully!!");
                registration_form_name.setText("");
                Parent root = FXMLLoader.load(getClass().getResource("../View/login.fxml"));
                Main.stage.getScene().setRoot(root);
            } else MyDialog.show("User Insertion Error!!");
        }
    }

    //go back to login page
    @FXML
    void goLoginPage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/login.fxml"));
        Main.stage.getScene().setRoot(root);
    }

    //go back to login page
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
