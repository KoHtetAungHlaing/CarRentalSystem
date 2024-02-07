package Controller;

import Helper.MyDialog;
import Model.Car;
import Model.Driver;
import Model.Rent;
import Model.User;
import Service.CarService;
import Service.DriverService;
import Service.RentService;
import Service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;

public class UserViewController implements Initializable {

    private Stage stage;
    Node node;
    private Scene scene;
    private Parent action_user_login;
    int id, cID, totalPrice;
    String regNo, driverName;
    User user;
    Driver driver;
    Rent rent;
    Car car;
    UserService userservice = new UserService();
    CarService carService = new CarService();
    DriverService driverService = new DriverService();
    RentService rentService = new RentService();
    boolean flag = false;
    ObservableList<String> carRegNoList = FXCollections.observableArrayList(); //create list that assign to Combo Box
    ObservableList<String> driverNameList = FXCollections.observableArrayList(); //create list that assign to Combo Box

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnRent;

    @FXML
    private Button btnUpdate;

    @FXML
    private Pane paneRent;

    @FXML
    private Pane paneUpdate;

    @FXML
    private Pane paneStart;

    @FXML
    private ComboBox<String> rent_form_car_register_no;

    @FXML
    private TextField rent_form_car_available;

    @FXML
    private TextField rent_form_cus_name;

    @FXML
    private TextField rent_form_car_model;

    @FXML
    private TextField rent_form_car_seat;

    @FXML
    private TextField rent_form_driver_available;

    @FXML
    private ComboBox<String> rent_form_driver_name;

    @FXML
    private DatePicker rent_form_fromDate;

    @FXML
    private TextField rent_form_price;

    @FXML
    private DatePicker rent_form_toDate;

    @FXML
    private TextField tfCustomerAddress;

    @FXML
    private TextField tfCustomerEmail;

    @FXML
    private TextField tfCustomerNRC;

    @FXML
    private TextField tfCustomerName;

    @FXML
    private PasswordField tfCustomerPassword;

    @FXML
    private TextField tfCustomerPhoneNo;

    @FXML
    private Button btnRentCar;

    //clear rent car form fields
    @FXML
    void cancelRentCar(ActionEvent event) {
        clearRentForm();
    }

    //assign data that gets from car register no and driver name-- combobox
    @FXML
    void assignCarToTextField(ActionEvent event) {
        regNo = rent_form_car_register_no.getSelectionModel().getSelectedItem();
        driverName = rent_form_driver_name.getSelectionModel().getSelectedItem();
        driver = driverService.getDriverByName(driverName);
        Car carObj = carService.getCarByRegNo(regNo);
        if (driver.isAvailable()) {
            if (driver.getId() == 1 && driver.isAvailable()) {
                rent_form_driver_available.setText("Yes");
                rent_form_price.setText(carObj.getPrice() + "");
            } else {
                rent_form_driver_available.setText("Yes");
                rent_form_price.setText((carObj.getPrice() + 50000) + "");
                //btnRentCar.setDisable(false);
            }
        } else {
            rent_form_driver_available.setText("No");
            rent_form_price.setText(carObj.getPrice() + "");
            //btnRentCar.setDisable(true);
        }
        setUpCarInfo();
    }

    @FXML
    void checkEmailFromDB(MouseEvent event) {
        String inputEmail = tfCustomerEmail.getText();
        UserService userService = new UserService();
        if (userService.getUserByID(id).getEmail().equals(inputEmail)) {
            MyDialog.show("No changes for user Email??");
        } else {
            if (userService.checkEmail(inputEmail)) {
                MyDialog.show("This mail is alreay exist");
                tfCustomerEmail.setText("");
            }
        }
    }

    @FXML
    void checkNameFromDB(MouseEvent event) {
        String inputName = tfCustomerName.getText();
        UserService userService = new UserService();

            if (userService.getUserByID(id).getName().equals(inputName)) {
                MyDialog.show("No changes for user name??");
            } else {
                if (userService.checkName(inputName)) {
                    MyDialog.show("This Name is already have in DB, Try another Name!!!");
                    tfCustomerName.setText("");
                } else {
                    //MyDialog.show("Name isn't have in DB");
                }
            }
        }

    //calculate price and driver available or not
    @FXML
    void assignDriverTextField(ActionEvent event) {

        userservice = new UserService();
        User userObj = userservice.getUserByID(id);
        if (userObj.isRenting()) {
            btnRentCar.setDisable(true);
            MyDialog.show("Can't Rent Car Right Now, Please Back Later!!");
        }

        driverName = rent_form_driver_name.getSelectionModel().getSelectedItem();
        driver = driverService.getDriverByName(driverName);
        Car carObj = carService.getCarByRegNo(regNo);
        if (driver.isAvailable()) {
            if (driver.getId() == 1 && driver.isAvailable()) {
                rent_form_driver_available.setText("Yes");
                rent_form_price.setText(carObj.getPrice() + "");
            } else {
                rent_form_driver_available.setText("Yes");
                rent_form_price.setText((carObj.getPrice() + 50000) + "");
                //btnRentCar.setDisable(false);
            }
        } else {
            rent_form_driver_available.setText("No");
            rent_form_price.setText(carObj.getPrice() + "");
            //btnRentCar.setDisable(true);
        }
        if (!driver.isAvailable()) {
            if (rent_form_driver_name.getSelectionModel().isSelected(0)) {
                btnRentCar.setDisable(false);
            } else {
                btnRentCar.setDisable(true);
            }
        } else btnRentCar.setDisable(false);
    }

    //handle button click event for Rent page, Update page and logout
    @FXML
    void handleClicks(ActionEvent event) throws IOException {

        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        id = (int) stage.getUserData();
        userservice = new UserService();
        user = userservice.getUserByID(id);
        rent_form_cus_name.setText(user.getName());
        if (event.getSource() == btnRent) {
            paneRent.setVisible(true);
            paneUpdate.setVisible(false);
            paneStart.setVisible(false);
            paneRent.toFront();
        }
        if (event.getSource() == btnUpdate) {
            paneUpdate.setVisible(true);
            paneRent.setVisible(false);
            paneStart.setVisible(false);
            paneUpdate.toFront();
            if (id != 0) {
                tfCustomerName.setText(user.getName());
                tfCustomerNRC.setText(user.getNrc());
                tfCustomerEmail.setText(user.getEmail());
                tfCustomerPassword.setText(user.getPassword());
                tfCustomerAddress.setText(user.getAddress());
                tfCustomerPhoneNo.setText(String.valueOf(user.getPhone()));
            } else {
                MyDialog.show("ID is 0");
            }
        }
        if (event.getSource() == btnLogout) {
            action_user_login = FXMLLoader.load(getClass().getResource("../View/login.fxml"));
            scene = new Scene(action_user_login);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
    }

    //clear user form fields
    @FXML
    void cancelUpdateProfile(ActionEvent event) {
        clearUpdateForm();
    }

    //user profile update
    @FXML
    void startUpdateProfile(ActionEvent event) {
        String updateName = tfCustomerName.getText();
        String updateNrc = tfCustomerNRC.getText();
        String updateEmail = tfCustomerEmail.getText();
        String updatePassword = tfCustomerPassword.getText();
        String updateAddresss = tfCustomerAddress.getText();
        tfCustomerPhoneNo.setText("25");
        int updatePhone = Integer.parseInt(tfCustomerPhoneNo.getText());
        String phone = String.valueOf(updatePhone);

        user = new User(id, updatePhone, updateName, updateNrc, updateEmail, updatePassword, updateAddresss, false);

        //MyDialog.show(name + " "+ nrc);
        userservice = new UserService();
        if (updateName.equals("") || updateNrc.equals("") || updateEmail.equals("") || updatePassword.equals("") || updateAddresss.equals("") || phone.equals("")) {
            MyDialog.show("Please Fill All Fields!!!");
        } else {
            if (userservice.updateUser(user)) {
                MyDialog.show("Information is Successfully Update!!!!");
                clearUpdateForm();
            } else MyDialog.show("Update Error!!!");
        }
    }

    //rent car by user
    @FXML
    void startRentCar(ActionEvent event) {

        CarService car_service = new CarService();
        Car car = car_service.getCarByRegNo(regNo);

        String name = rent_form_cus_name.getText();
        UserService user_service = new UserService();

        driver = driverService.getDriverByName(driverName);
        cID = car.getId();
        int custID = user_service.getIdByName(name);
        int driverID = driver.getId();
        String fromDate = null;
        String toDate = null;

        //rent_form_fromDate.setValue(LocalDate.now());
        //rent_form_toDate.setValue(LocalDate.now());
        if((rent_form_fromDate.getValue()!=null) && rent_form_toDate.getValue() != null ){
            fromDate = rent_form_fromDate.getValue().toString();
            toDate = rent_form_toDate.getValue().toString();
        }else{
            MyDialog.show("Please Choose Date!!!");
        }

        // MyDialog.show(driverID + "\n" + custID + "\n" + cID + "\n" + totalPrice + "\n" + fromDate + "\n" + toDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        LocalDate date1 = LocalDate.parse(fromDate, formatter);
        LocalDate date2 = LocalDate.parse(toDate, formatter);
        Long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        int day = Math.toIntExact(daysBetween);

        //MyDialog.show(rent_form_price.getText());
        if (date1.compareTo(date2) == 0) {
            totalPrice = Integer.parseInt(rent_form_price.getText());
            // MyDialog.show(String.valueOf(totalPrice));
        } else if (date1.compareTo(date2) < 0) {
            totalPrice = day * (Integer.parseInt(rent_form_price.getText()));
            //MyDialog.show(String.valueOf(totalPrice));
        }

        int price = Integer.parseInt(rent_form_price.getText());
        Rent rent = new Rent(0, driverID, custID, cID, price, day, totalPrice, fromDate, toDate, false);

       if(rent_form_fromDate.getValue()==null || rent_form_toDate.getValue()==null){
           MyDialog.show("Please Fill All Fields!!!!");
       }else{
           if (rentService.saveRentInfo(rent)) {
               MyDialog.show("Rent Successfully!!");
               clearRentForm();
               carService = new CarService();
               Car carObj = carService.getCarByID(cID);
               carObj.setAvailable(false);
               if (carService.updateCarForAvailable(carObj)) {
                   //MyDialog.show("Set Available To 0!!!!");
               } else MyDialog.show("Error Set Up to 0");

               driverService = new DriverService();
               Driver driverObj = driverService.getDriverByID(driverID);

               if (driverObj.getId() == 1) {
                   // MyDialog.show("No changes for driver id 1");
               } else {
                   driverObj.setAvailable(false);
                   if (driverService.updateDriverForAvailable(driverObj)) {
                       // MyDialog.show("Set Available To 0!!!!");
                   } else MyDialog.show("Error Set Up to 0");
               }

               userservice = new UserService();
               User userObj = userservice.getUserByID(custID);
               userObj.setRenting(true);
               if (userservice.updateUserForRenting(userObj)) {
                   //MyDialog.show("Set Renting To 1!!!!");
               } else MyDialog.show("Error Set Renting to 1");
           } else MyDialog.show("Rent Error!!");
       }
    }

    //close app
    @FXML
    void close_app_rent(MouseEvent event) {
        System.exit(0);
    }

    //close app
    @FXML
    void close_app_update(MouseEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneStart.setVisible(true);
        paneRent.setVisible(false);
        paneUpdate.setVisible(false);
        tfCustomerNRC.setDisable(true);

        carService = new CarService();
        List<Car> car = carService.getCarRegNo();
        for (Car cars : car) {
            regNo = cars.getRegNo();
            carRegNoList.addAll(regNo);
        }
        rent_form_car_register_no.setItems(carRegNoList);
        rent_form_car_register_no.getSelectionModel().select(0);
        setUpCarInfo();

        driverService = new DriverService();
        List<Driver> driverObjList = driverService.getAllDriver();
        for (Driver drivers : driverObjList) {
            driverNameList.addAll(drivers.getName());
        }
        rent_form_driver_name.setItems(driverNameList);
        rent_form_driver_name.getSelectionModel().select(0);
        driverName = rent_form_driver_name.getSelectionModel().getSelectedItem();
        driver = driverService.getDriverByName(driverName);
        Car carObj = carService.getCarByRegNo(regNo);

        if (driver.isAvailable()) {
            if (driver.getId() == 1 && driver.isAvailable()) {
                rent_form_driver_available.setText("Yes");
                rent_form_price.setText(carObj.getPrice() + "");
            } else {
                rent_form_driver_available.setText("Yes");
                rent_form_price.setText((carObj.getPrice() + 50000) + "");
                //btnRentCar.setDisable(false);
            }
        } else {
            rent_form_driver_available.setText("No");
            rent_form_price.setText(carObj.getPrice() + "");
            //btnRentCar.setDisable(true);
        }
    }

    //clear rent form fields
    private void clearRentForm() {
        rent_form_car_register_no.getSelectionModel().selectFirst();
        rent_form_car_available.setText("");
        rent_form_car_model.setText("");
        rent_form_car_seat.setText("");
        rent_form_driver_name.getSelectionModel().selectFirst();
        rent_form_driver_available.setText("");
        rent_form_price.setText("");
        rent_form_fromDate.setValue(null);
        rent_form_toDate.getEditor().clear();
    }

    //clear update form fields
    private void clearUpdateForm() {
        tfCustomerName.setText("");
        tfCustomerNRC.setText("");
        tfCustomerEmail.setText("");
        tfCustomerPassword.setText("");
        tfCustomerAddress.setText("");
        tfCustomerPhoneNo.setText("");
    }

    //setup car info
    private void setUpCarInfo() {
        regNo = rent_form_car_register_no.getSelectionModel().getSelectedItem();
        Car carObj = carService.getCarByRegNo(regNo);

        if (carObj.isAvailable()) {
            rent_form_car_available.setText("Yes");
            rent_form_car_model.setDisable(false);
            rent_form_car_seat.setDisable(false);
            rent_form_car_model.setText(carObj.getModel());
            rent_form_car_seat.setText(String.valueOf(carObj.getSeat()));
            btnRentCar.setDisable(false);

        } else {
            rent_form_car_available.setText("No");
            rent_form_car_model.setDisable(true);
            rent_form_car_seat.setDisable(true);
            rent_form_car_model.setText(carObj.getModel());
            rent_form_car_seat.setText(String.valueOf(carObj.getSeat()));
            btnRentCar.setDisable(true);
        }
    }
}
