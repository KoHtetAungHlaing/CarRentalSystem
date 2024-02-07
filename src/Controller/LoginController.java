package Controller;

import Helper.MyDialog;
import Service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent actionGoToUserView;
    static String name, password;
    int id;

    @FXML
    private Pane content_area;

    @FXML
    private ToggleGroup checkAdminOrUser;

    @FXML
    private Label lblForgotPassword;

    @FXML
    private Label lblSignUp;

    @FXML
    private Label lblNewUser;

    @FXML
    private RadioButton rdoAdmin;

    @FXML
    private RadioButton rdoUser;

    @FXML
    private TextField tfUserName;

    @FXML
    private PasswordField tfUserPassword;

    @FXML
    private TextField tfAdminName;

    @FXML
    private PasswordField tfAdminPassword;

    @FXML
    void close_app(MouseEvent event) {
        System.exit(0);
    }

    //check user is admin or not
    @FXML
    void CheckUserToLogin(ActionEvent event) {
        if (rdoAdmin.isSelected()) {
            lblForgotPassword.setVisible(false);
            lblNewUser.setVisible(false);
            lblSignUp.setVisible(false);

            tfAdminName.setVisible(true);
            tfAdminPassword.setVisible(true);
            tfUserName.setVisible(false);
            tfUserPassword.setVisible(false);
        } else {
            lblForgotPassword.setVisible(true);
            lblNewUser.setVisible(true);
            lblSignUp.setVisible(true);

            tfUserName.setVisible(true);
            tfUserPassword.setVisible(true);
            tfAdminName.setVisible(false);
            tfAdminPassword.setVisible(false);
        }
    }

    //check user input name and name in DB
    @FXML
    void checkNameFromDB(MouseEvent event) {
        String inputName = tfUserName.getText();
        UserService userService = new UserService();
        if (userService.checkName(inputName)) {
            //MyDialog.show("Equals!!!!!!!!!!!!!!!");
        } else {
            MyDialog.show(inputName + " : doesn't have in database!!!");
            tfUserName.setText("");
        }
    }

    //go to forgot password page
    @FXML
    void goForgotPasswword(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("../View/forgot_password.fxml"));
        content_area.getChildren().removeAll();
        content_area.getChildren().setAll(fxml);
    }

    //login with user input name and password in both for user and admin
    @FXML
    void startLogin(ActionEvent event) throws IOException {
        name = tfUserName.getText();
        password = tfUserPassword.getText();
        UserService userService = new UserService();
        id = userService.getIdByName(name);
        if (rdoUser.isSelected()) {

            tfAdminName.setText("");
            tfAdminPassword.setText("");
            if (userService.loginUser(name, password)) {
                actionGoToUserView = FXMLLoader.load(getClass().getResource("../View/user_view.fxml"));
                scene = new Scene(actionGoToUserView);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setUserData(id);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } else {
                MyDialog.show("Username or Password is incorrect! Try again!!!!!!");
            }
        } else {
            String adminName = tfAdminName.getText();
            String adminPassword = tfAdminPassword.getText();

            tfUserName.setText("");
            tfUserPassword.setText("");
            if (adminName.contentEquals("admin") && adminPassword.contentEquals("12345")) {
                actionGoToUserView = FXMLLoader.load(getClass().getResource("../View/admin_view.fxml"));
                scene = new Scene(actionGoToUserView);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } else {
                MyDialog.show("Name or Password is incorrect! Try again!!!!!!");
            }
        }
    }

    //go to user register page
    @FXML
    void goUserRegister(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("../View/user_register.fxml"));
        content_area.getChildren().removeAll();
        content_area.getChildren().setAll(fxml);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (rdoAdmin.isSelected()) {
            lblNewUser.setVisible(false);
            lblSignUp.setVisible(false);

            tfAdminName.setVisible(true);
            tfAdminPassword.setVisible(true);
            tfUserName.setVisible(false);
            tfUserPassword.setVisible(false);

        } else {
            lblNewUser.setVisible(true);
            lblSignUp.setVisible(true);

            tfUserName.setVisible(true);
            tfUserPassword.setVisible(true);
            tfAdminName.setVisible(false);
            tfAdminPassword.setVisible(false);
        }
    }
}
