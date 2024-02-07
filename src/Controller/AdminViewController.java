package Controller;

import Helper.MyDialog;
import Model.*;
import Service.*;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;

public class AdminViewController implements Initializable {

    //start of Controller Skeleton From Scene Builder(UI)
    @FXML
    private Button btnCustomerList;

    @FXML
    private Button btnReturnList;

    @FXML
    private Button btnLogout;

    @FXML
    private TextField customerList_form_address;

    @FXML
    private TextField customerList_form_email;

    @FXML
    private TextField customerList_form_name;

    @FXML
    private TextField customerList_form_nrc;

    @FXML
    private PasswordField customerList_form_password;

    @FXML
    private TextField customerList_form_phone;

    @FXML
    private TableView<String> customerList_table_view;

    @FXML
    private Pane paneCustomerLists;

    @FXML
    private Pane paneReturnLists;

    @FXML
    private TextField return_form_extra_day;

    @FXML
    private TextField return_form_extra_money;

    @FXML
    private ComboBox<String> return_form_rent_id;

    @FXML
    private DatePicker return_form_return_date;

    @FXML
    private TableView<Received> return_list_table_view;

    @FXML
    private TableColumn<Received, Integer> table_col_extraDay;

    @FXML
    private TableColumn<Received, Integer> table_col_extraMoney;

    @FXML
    private TableColumn<Received, Integer> table_col_rentID;

    @FXML
    private TableColumn<Received, Integer> table_col_returnID;

    @FXML
    private TableColumn<Received, String> table_col_return_date;

    @FXML
    private TableColumn<Received, Integer> table_col_totalPrice;

    @FXML
    private TableColumn<User, String> tableView_customerList_address;

    @FXML
    private TableColumn<User, String> tableView_customerList_email;

    @FXML
    private TableColumn<User, Integer> tableView_customerList_id;

    @FXML
    private TableColumn<User, String> tableView_customerList_name;

    @FXML
    private TableColumn<User, String> tableView_customerList_nrc;

    @FXML
    private TableColumn<User, String> tableView_customerList_password;

    @FXML
    private TableColumn<User, Integer> tableView_customerList_phone;

    @FXML
    private TableColumn<User, Boolean> tableView_customerList_renting;

    @FXML
    private TableView<User> table_view_customerList;

    @FXML
    private Button btnCarList;

    @FXML
    private Button btnDriverList;

    @FXML
    private Button btnRentActiveList;

    @FXML
    private Button btnoverallList;

    @FXML
    private Pane paneCarLists;

    @FXML
    private Pane paneDriverLists;

    @FXML
    private Pane paneOverallLists;

    @FXML
    private Pane paneActiveRentLists;

    @FXML
    private TableColumn<Car, Boolean> table_col_car_available;

    @FXML
    private TableColumn<Car, Integer> table_col_car_id;

    @FXML
    private TableColumn<Car, String> table_col_car_model;

    @FXML
    private TableColumn<Car, Integer> table_col_car_price;

    @FXML
    private TableColumn<Car, Integer> table_col_car_regNo;

    @FXML
    private TableColumn<Car, Integer> table_col_car_seat;

    @FXML
    private TableView<Car> tableView_car_list;

    @FXML
    private TextField car_form_model;

    @FXML
    private TextField car_form_price;

    @FXML
    private TextField car_form_registration_no;

    @FXML
    private TextField car_form_seat;

    @FXML
    private TextField driver_form_address;

    @FXML
    private TextField driver_form_name;

    @FXML
    private TextField driver_form_nrc;

    @FXML
    private TextField driver_form_phone;

    @FXML
    private TableView<Driver> tableView_driver_list;

    @FXML
    private TableColumn<Driver, String> table_col_driver_address;

    @FXML
    private TableColumn<Driver, Boolean> table_col_driver_available;

    @FXML
    private TableColumn<Driver, Integer> table_col_driver_id;

    @FXML
    private TableColumn<Driver, String> table_col_driver_name;

    @FXML
    private TableColumn<Driver, String> table_col_driver_nrc;

    @FXML
    private TableColumn<Driver, Integer> table_col_driver_phone;

    @FXML
    private TableView<Rent> tableView_active_rent_list;

    @FXML
    private TableColumn<Rent, Integer> table_col_active_rent_car_id;

    @FXML
    private TableColumn<Rent, Integer> table_col_active_rent_customer_id;

    @FXML
    private TableColumn<Rent, Integer> table_col_active_rent_driver_id;

    @FXML
    private TableColumn<Rent, String> table_col_active_rent_fromDate;

    @FXML
    private TableColumn<Rent, Integer> table_col_active_rent_noOfDay;

    @FXML
    private TableColumn<Rent, Integer> table_col_active_rent_price;

    @FXML
    private TableColumn<Rent, Integer> table_col_active_rent_rent_id;

    @FXML
    private TableColumn<Rent, Boolean> table_col_active_rent_returnCar;

    @FXML
    private TableColumn<Rent, String> table_col_active_rent_toDate;

    @FXML
    private TableColumn<Rent, Integer> table_col_active_rent_totalPrice;

    @FXML
    private TableView<History> tableView_overall_history;

    @FXML
    private TableColumn<History, Integer> table_col_overall_count;

    @FXML
    private TableColumn<History, String> table_col_overall_history_fromDate;

    @FXML
    private TableColumn<History, String> table_col_overall_history_name;

    @FXML
    private TableColumn<History, String> table_col_overall_history_toDate;

    @FXML
    private TableColumn<History, Integer> table_col_overall_history_totalPrice;
    //end of Controller Skeleton From Scene Builder(UI)

    //varialbe declaration for All
    private Stage stage;
    Node node;
    private Scene scene;
    private Parent action_user_login;
    RentService rentService;
    ReceivedService receivedService;
    DriverService driverService;
    CarService carService;
    UserService userService;
    HistoryService historyService;
    Rent rent_obj;
    int rentID, rent_id, edit_returnID, selectedIndex, customerID, carID, driverID;
    String returnDate;
    boolean flag = false, flagForCar = false, userRenting, carAvailable, flagForDriver = false, driverAvailable, flagForUser = false, flagForActiveList = false, flagForOverAll = false, flagForCustomer = false, flagForCarList = false, flagForDriverList = false;
    ObservableList<String> rentIdListFalse = FXCollections.observableArrayList();//create list for rent that assign to Combo Box
    ObservableList<Received> obReceived = FXCollections.observableArrayList();//create list for return_car
    ObservableList<Received> obReceivedAdd = FXCollections.observableArrayList();//create list for return_car adding
    ObservableList<User> obUser = FXCollections.observableArrayList();//create list for user
    ObservableList<Car> obCar = FXCollections.observableArrayList();//create list for car
    ObservableList<Driver> obDriver = FXCollections.observableArrayList();//create list for driver
    ObservableList<Rent> obRent = FXCollections.observableArrayList();//create list for rent
    ObservableList<History> obHistory = FXCollections.observableArrayList();//create list for history that shows history by each driver

    //clear Customer list form
    @FXML
    void cancelCustomerLists(ActionEvent event) {
        clearFormCustomerList();
    }

    //clear ReturnCar list form
    @FXML
    void cancelReturnCar(ActionEvent event) {
        clearReturnCarForm();
    }

    //clear Car list form
    @FXML
    void cancelCarLists(ActionEvent event) {
        clearFormCarList();
    }

    //save or update car in admin side
    @FXML
    void saveCarLists(ActionEvent event) {
        String regNo = car_form_registration_no.getText();//get registration no from textfield
        String model = car_form_model.getText();//get car model from textfield
        int seat = Integer.parseInt(car_form_seat.getText());//get seat no from textfield
        int price = Integer.parseInt(car_form_price.getText());//get price from textfield

        carService = new CarService();//create service for car

        if (flagForCar) { // if true => car update else insert new car
            Car car_obj = new Car(carID, seat, price, regNo, model, carAvailable);//create car object for update car
            //car update start
            if (carService.updateCar(car_obj)) {
                MyDialog.show("Update Car Successfully!!!");
                //remove data from list and tableview
                tableView_car_list.getItems().clear();
                obCar.remove(0, obCar.size());
                //reload data from list and tableview
                carService = new CarService();
                List<Car> addCar = carService.getCarRegNo();
                //obReceivedAdd.remove(0, obReceivedAdd.size());
                for (Car add_car : addCar) {
                    obCar.add(add_car);
                }
                //MyDialog.show(obReceived.toString());
                tableView_car_list.getItems().addAll(obCar);
                flagForCar = false;
                clearFormCarList();
            } else {
                MyDialog.show("Update Car Error!!!!");
            }
        } else {
            //insert car start
            Car car_obj = new Car(0, seat, price, regNo, model, true);//create car object for insert car
            if (carService.saveCar(car_obj)) {
                MyDialog.show("Save Car Successfully!!!!");
                //remove data from list and tableview
                tableView_car_list.getItems().clear();
                obCar.remove(0, obCar.size());
                //reload data from list and tableview
                carService = new CarService();
                List<Car> addcar = carService.getCarRegNo();
                //obReceivedAdd.remove(0, obReceivedAdd.size());
                for (Car add_car : addcar) {
                    obCar.add(add_car);
                }
                //MyDialog.show(obReceived.toString());
                tableView_car_list.getItems().addAll(obCar);
                flag = false;
                clearFormCarList();
            } else {
                MyDialog.show("Save Car Error!!");
            }
        }
    }

    @FXML
    void startSaveDriver(ActionEvent event) {
        String name = driver_form_name.getText();//get driver name from textfield
        String nrc = driver_form_nrc.getText();//get nrc from textfield
        int phone = Integer.parseInt(driver_form_phone.getText());//get phone no from textfield
        String address = driver_form_address.getText();//get address from textfield

        driverService = new DriverService();//create service for driver

        // if true => driver update else insert new driver
        if (flagForDriver) {
            //driver update start
            Driver driver_obj = new Driver(driverID, phone, name, nrc, address, driverAvailable);//create driver object for update driver
            if (driverService.updateDriver(driver_obj)) {
                MyDialog.show("Update Driver Successfully!!!");
                clearFormDriverList();
                //remove data from list and tableview
                tableView_driver_list.getItems().clear();
                obDriver.remove(0, obDriver.size());
                //reload data from list and tableview
                driverService = new DriverService();
                List<Driver> addDriver = driverService.getAllDriver();
                //obReceivedAdd.remove(0, obReceivedAdd.size());
                for (Driver add_driver : addDriver) {
                    obDriver.add(add_driver);
                }
                //MyDialog.show(obReceived.toString());
                tableView_driver_list.getItems().addAll(obDriver);
                flagForDriver = false;
                clearFormDriverList();
            } else {
                MyDialog.show("Update Driver Error!!!!");
            }
        } else {
            //insert driver start
            Driver driver_obj = new Driver(0, phone, name, nrc, address, true);//create driver object for insert driver
            if (driverService.saveDriver(driver_obj)) {
                MyDialog.show("Save Driver Successfully!!!!");
                //remove data from list and tableview
                tableView_driver_list.getItems().clear();
                obDriver.remove(0, obDriver.size());
                //reload data from list and tableview
                driverService = new DriverService();
                List<Driver> addDriver = driverService.getAllDriver();
                //obReceivedAdd.remove(0, obReceivedAdd.size());
                for (Driver add_driver : addDriver) {
                    obDriver.add(add_driver);
                }
                //MyDialog.show(obReceived.toString());
                tableView_driver_list.getItems().addAll(obDriver);
                flagForDriver = false;
                clearFormDriverList();
            } else {
                MyDialog.show("Save Car Error!!");
            }
        }
    }

    //clear driver list form
    @FXML
    void cancelSaveDriver(ActionEvent event) {
        clearFormDriverList();
    }

    @FXML
    void saveCustomerLists(ActionEvent event) {
        //get values from textfield
        String name = customerList_form_name.getText();
        String nrc = customerList_form_nrc.getText();
        String email = customerList_form_email.getText();
        String password = customerList_form_password.getText();
        String address = customerList_form_address.getText();
        int phone = Integer.parseInt(customerList_form_phone.getText());

        userService = new UserService();
        // if true => user update else insert new user
        if (flagForUser) {
            //user update start
            User userObj = new User(customerID, phone, name, nrc, email, password, address, userRenting);//create user object for update user
            if (userService.updateUser(userObj)) {
                MyDialog.show("Update User Successfully!!!");
                clearFormCustomerList();
                //remove data from list and tableview
                table_view_customerList.getItems().clear();
                obUser.remove(0, obUser.size());
                //reload data from list and tableview
                userService = new UserService();
                List<User> addUser = userService.getAllUser();
                //obReceivedAdd.remove(0, obReceivedAdd.size());
                for (User add_user : addUser) {
                    obUser.add(add_user);
                }
                //MyDialog.show(obReceived.toString());
                table_view_customerList.getItems().addAll(obUser);
                flagForUser = false;
                clearFormCustomerList();
            } else {
                MyDialog.show("Update User Error!!!!");
            }
        } else {
            //user insert start
            User userObj = new User(0, phone, name, nrc, email, password, address, false);//create user object for insert user
            if (userService.saveUser(userObj)) {
                MyDialog.show("Save User Successfully!!!!");
                //remove data from list and tableview
                table_view_customerList.getItems().clear();
                obUser.remove(0, obUser.size());
                //reload data from list and tableview
                userService = new UserService();
                List<User> addUser = userService.getAllUser();
                //obReceivedAdd.remove(0, obReceivedAdd.size());
                for (User add_user : addUser) {
                    obUser.add(add_user);
                }
                //MyDialog.show(obReceived.toString());
                table_view_customerList.getItems().addAll(obUser);
                flagForUser = false;
                clearFormCustomerList();
            } else {
                MyDialog.show("Save User Error!!");
            }
        }
    }

    //calculate extra day and extra price from returnDate field
    @FXML
    void setTextToExtraDay(ActionEvent event) {

        rentService = new RentService();//create service for rent
        rent_id = Integer.parseInt(return_form_rent_id.getSelectionModel().getSelectedItem());//get id from combobox that have rent data
        rent_obj = rentService.getRentByID(rent_id);//get rent object by rent_id
        String toDate = rent_obj.getToDate();//get toDate from rent object

        checkDate();

        //returnDate = return_form_return_date.getValue().toString();//get date from textfield
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        LocalDate date1 = LocalDate.parse(toDate, formatter);//format date
        LocalDate date2 = LocalDate.parse(returnDate, formatter);//format date
        Long daysBetween = ChronoUnit.DAYS.between(date1, date2);//get number of day between two dates
        int day = Math.toIntExact(daysBetween);//convert to int

        //no of day > 0
        if (daysBetween > 0) {
            return_form_extra_day.setText(String.valueOf(daysBetween));
            return_form_extra_money.setText(String.valueOf((rent_obj.getPrice() * day)));
        }
        //two dates are equal
        if (date1.compareTo(date2) == 0) {
            return_form_extra_day.setText(0 + "");
            return_form_extra_money.setText(0 + "");
        }
    }

    private void checkDate() {
        if (return_form_return_date.getValue() != null) {
            returnDate = return_form_return_date.getValue().toString();
        } else {
            MyDialog.show("Please Choose Date!!!");
        }
    }

    @FXML
    void saveReturnCar(ActionEvent event) {
        //get value from textfields
        int extra_day = Integer.parseInt(return_form_extra_day.getText());
        int extra_money = Integer.parseInt(return_form_extra_money.getText());
        int total_price = (rent_obj.getTotalPrice() + extra_money);

        Received return_obj = new Received(edit_returnID, rent_id, extra_day, extra_money, total_price, returnDate);//create received object for update car return
        ReceivedService returnService = new ReceivedService();//create service from received
        if (flag) {
            //return car update start
            if (returnService.updateCarForReturnCar(return_obj)) {
                MyDialog.show("Received Car Update Successfully!!");
                //remove data from list and combobox
                return_list_table_view.getItems().clear();
                obReceivedAdd.remove(0, obReceivedAdd.size());
                //reload data from list and combobox
                receivedService = new ReceivedService();
                List<Received> addReceived = receivedService.getAllReceivedForUpdate();
                //obReceivedAdd.remove(0, obReceivedAdd.size());
                for (Received add_received : addReceived) {
                    obReceivedAdd.add(add_received);
                }
                //MyDialog.show(obReceived.toString());
                return_list_table_view.getItems().addAll(obReceivedAdd);
                flag = false;
                clearReturnCarForm();
            } else {
                MyDialog.show(" Error Received Car Update!!!!!!!!");
            }
        } else {
            Received returnO = new Received(0, rent_id, extra_day, extra_money, total_price, returnDate);
            if (returnService.saveReturnInfo(returnO)) {
                MyDialog.show("Received Car Save Successfully!!!");
                clearReturnCarForm();//clear return car field

                //remove data from list and tableview
                return_list_table_view.getItems().clear();
                obReceivedAdd.remove(0, obReceivedAdd.size());
                //reload data from list and tableview
                receivedService = new ReceivedService();
                List<Received> addReceived = receivedService.getAllReceivedForUpdate();
                //obReceivedAdd.remove(0, obReceivedAdd.size());
                for (Received add_received : addReceived) {
                    obReceivedAdd.add(add_received);
                }
                //MyDialog.show(obReceived.toString());
                return_list_table_view.getItems().addAll(obReceivedAdd);

                /*
                 return car's setReturnCar = true;
                */
                rentService = new RentService();
                Rent rent_obj = rentService.getRentByID(rent_id);
                rent_obj.setReturnCar(true);
                //after then update data
                if (rentService.updateRentIsAvailable(rent_obj)) {
                    //MyDialog.show("Set to 1");
                } else {
                    //MyDialog.show(rent_obj.toString());
                    MyDialog.show("Error Set to 1");
                }

                //update dID,
                rentService = new RentService();
                int rentID = Integer.parseInt(return_form_rent_id.getSelectionModel().getSelectedItem());
                Rent rentObj = rentService.getRentByID(rentID);
                int dID = rentObj.getdID();
                int custID = rentObj.getCustID();
                int cID = rentObj.getcID();

                driverService = new DriverService();
                Driver d = driverService.getDriverByID(dID);
                d.setAvailable(true);
                if (driverService.updateDriverForAvailable(d)) {
                    // MyDialog.show("Driver Available set to 1");
                }

                userService = new UserService();
                User u = userService.getUserByID(custID);
                u.setRenting(false);
                if (userService.updateUserForRenting(u)) {
                    // MyDialog.show("User Available set to 0");
                }

                carService = new CarService();
                Car c = carService.getCarByID(cID);
                c.setAvailable(true);
                if (carService.updateCarForAvailable(c)) {
                    //MyDialog.show("Car Available set to 1");
                }

                return_form_rent_id.getItems().clear();
                rentService = new RentService();
                List<Rent> rentList = rentService.getAllRentForReturnCarFalse();
                for (Rent rentLists : rentList) {
                    rentID = rentLists.getRentID();
                    rentIdListFalse.addAll(String.valueOf(rentID));
                }
                return_form_rent_id.setItems(rentIdListFalse);
            } else {
                MyDialog.show("Received Car Save Error!!!");
            }
        }
    }

    @FXML
    void checkNameFromDB(MouseEvent event) {
        String inputName = customerList_form_name.getText();
        UserService userService = new UserService();
        if (flagForUser == true) {
            if (userService.getUserByID(customerID).getName().equals(inputName)) {
                MyDialog.show("No changes for user name??");
            } else {
                if (userService.checkName(inputName)) {
                    MyDialog.show("This Name is already have in DB, Try another Name!!!");
                    customerList_form_name.setText("");
                } else {
                    //MyDialog.show("Name isn't have in DB");
                }
            }
        } else {
            if (userService.checkName(inputName)) {
                MyDialog.show("This Name is already have in DB, Try another Name!!!");
                customerList_form_name.setText("");
            }
        }
//        if (userService.checkName(inputName)) {
//            MyDialog.show("This Name is already have in DB, Try another Name!!!");
//            customerList_form_name.setText("");
//        } else {
//            //MyDialog.show("Name isn't have in DB");
//        }
    }

    //handle panels click
    @FXML
    void handleClicks(ActionEvent event) throws IOException {
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();

        if (event.getSource() == btnReturnList) {
            paneReturnLists.setVisible(true);
            paneCustomerLists.setVisible(false);
            paneCarLists.setVisible(false);
            paneDriverLists.setVisible(false);
            paneActiveRentLists.setVisible(false);
            paneOverallLists.setVisible(false);
        }
        if (event.getSource() == btnCustomerList) {
            paneCustomerLists.setVisible(true);
            paneReturnLists.setVisible(false);
            paneCarLists.setVisible(false);
            paneDriverLists.setVisible(false);
            paneActiveRentLists.setVisible(false);
            paneOverallLists.setVisible(false);
            flagForCustomer = true;
            refreshTableForCustomerList();
        }
        if (event.getSource() == btnCarList) {
            paneCarLists.setVisible(true);
            paneCustomerLists.setVisible(false);
            paneReturnLists.setVisible(false);
            paneDriverLists.setVisible(false);
            paneActiveRentLists.setVisible(false);
            paneOverallLists.setVisible(false);
            flagForCarList = true;
            refreshTableForCarList();
        }
        if (event.getSource() == btnDriverList) {
            paneDriverLists.setVisible(true);
            paneCarLists.setVisible(false);
            paneCustomerLists.setVisible(false);
            paneReturnLists.setVisible(false);
            paneActiveRentLists.setVisible(false);
            paneOverallLists.setVisible(false);
            flagForDriverList = true;
            refreshTableForDriverList();
        }
        if (event.getSource() == btnRentActiveList) {
            paneActiveRentLists.setVisible(true);
            paneDriverLists.setVisible(false);
            paneCarLists.setVisible(false);
            paneCustomerLists.setVisible(false);
            paneReturnLists.setVisible(false);
            paneOverallLists.setVisible(false);
            flagForActiveList = true;
            refreshTableForActiveRentList();
        }
        if (event.getSource() == btnoverallList) {
            paneOverallLists.setVisible(true);
            paneActiveRentLists.setVisible(false);
            paneDriverLists.setVisible(false);
            paneCarLists.setVisible(false);
            paneCustomerLists.setVisible(false);
            paneReturnLists.setVisible(false);
            flagForOverAll = true;
            refreshTableForOverrAll();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneReturnLists.setVisible(true);
        paneCustomerLists.setVisible(false);
        paneCarLists.setVisible(false);
        paneDriverLists.setVisible(false);
        paneActiveRentLists.setVisible(false);
        paneOverallLists.setVisible(false);
        setUpRentID();
        return_form_extra_day.setText("0");
        return_form_extra_money.setText("0");
        loadTableViewForCustomerList();
        loadTableViewForCarList();
        loadTableViewForDriver();
        loadTableViewForActiveRent();
        loadTableViewForOverAllHistory();
    }

    //setup rent id
    private void setUpRentID() {
        rentService = new RentService();
        List<Rent> rentList = rentService.getAllRentForReturnCarFalse();
        for (Rent rentLists : rentList) {
            rentID = rentLists.getRentID();
            rentIdListFalse.addAll(String.valueOf(rentID));
        }
        return_form_rent_id.setItems(rentIdListFalse);
        return_form_rent_id.getSelectionModel().select(0);

        loadTableViewForRent();
    }

    //clear customer list form
    private void clearFormCustomerList() {
        customerList_form_name.setText("");
        customerList_form_nrc.setText("");
        customerList_form_email.setText("");
        customerList_form_password.setText("");
        customerList_form_address.setText("");
        customerList_form_phone.setText("");
    }

    //clear  driver list form
    private void clearFormDriverList() {
        driver_form_name.setText("");
        driver_form_nrc.setText("");
        driver_form_phone.setText("");
        driver_form_address.setText("");
    }

    //clear return car form
    private void clearReturnCarForm() {
        return_form_rent_id.getSelectionModel().select(0);
        return_form_return_date.getEditor().clear();
        return_form_extra_day.setText("");
        return_form_extra_money.setText("");
    }

    //clear car list form
    private void clearFormCarList() {
        car_form_registration_no.setText("");
        car_form_model.setText("");
        car_form_seat.setText("");
        car_form_price.setText("");
    }

    //refresh tableview for active rent list
    private void refreshTableForActiveRentList() {
        if (flagForActiveList) {
            tableView_active_rent_list.getItems().clear();
            obRent.remove(0, obRent.size());
            rentService = new RentService();
            List<Rent> rentList = rentService.getAllRent();

            for (Rent rents : rentList) {
                obRent.add(rents);
            }
            tableView_active_rent_list.getItems().addAll(obRent);
            flagForActiveList = false;
        }
    }

    // //refresh tableview for history by each driver
    private void refreshTableForOverrAll() {
        if (flagForOverAll) {
            tableView_overall_history.getItems().clear();
            obHistory.remove(0, obHistory.size());
            historyService = new HistoryService();
            List<History> historyList = historyService.getAllHistory();

            for (History histories : historyList) {
                obHistory.add(histories);
            }
            tableView_overall_history.getItems().addAll(obHistory);
            flagForOverAll = false;
        }
    }

    //refresh tableview for customer list
    private void refreshTableForCustomerList() {
        if (flagForCustomer) {
            table_view_customerList.getItems().clear();
            obUser.remove(0, obUser.size());
            userService = new UserService();
            List<User> userList = userService.getAllUser();
            for (User users : userList) {
                obUser.add(users);
            }
            table_view_customerList.getItems().addAll(obUser);
            flagForCustomer = false;
        }
    }

    //refresh tableview for car list
    private void refreshTableForCarList() {
        if (flagForCarList) {
            tableView_car_list.getItems().clear();
            obCar.remove(0, obCar.size());
            carService = new CarService();
            List<Car> carList = carService.getCarRegNo();
            for (Car cars : carList) {
                obCar.add(cars);
            }
            tableView_car_list.getItems().addAll(obCar);
            flagForCarList = false;
        }
    }

    //refresh tableview for driver list
    private void refreshTableForDriverList() {
        if (flagForDriverList) {
            tableView_driver_list.getItems().clear();
            obDriver.remove(0, obDriver.size());
            driverService = new DriverService();
            List<Driver> driverList = driverService.getAllDriver();
            for (Driver drivers : driverList) {
                obDriver.add(drivers);
            }
            tableView_driver_list.getItems().addAll(obDriver);
            flagForDriverList = false;
        }
    }

    public void addEditDeleteColumnForCustomer(String columnName, String buttonName) {
        TableColumn<User, Void> actionColumn = new TableColumn<>(columnName);
        Callback<TableColumn<User, Void>, TableCell<User, Void>> factory = new Callback<TableColumn<User, Void>, TableCell<User, Void>>() {
            @Override
            public TableCell<User, Void> call(TableColumn<User, Void> param) {
                final TableCell<User, Void> cell = new TableCell<User, Void>() {
                    final Button button = new Button(buttonName);

                    {
                        button.setOnAction(e -> {
                            User item_click_user = table_view_customerList.getSelectionModel().getSelectedItem();
                            int ind = table_view_customerList.getSelectionModel().getSelectedIndex();
                            if (ind != -1) {
                                // MyDialog.show(item_click_received.toString());
                                if (buttonName.contentEquals("edit")) {
                                    flagForUser = true;
                                    customerID = item_click_user.getId();
                                    userRenting = item_click_user.isRenting();
                                    customerList_form_name.setText(item_click_user.getName());
                                    customerList_form_nrc.setText(item_click_user.getNrc());
                                    customerList_form_email.setText(item_click_user.getEmail());
                                    customerList_form_password.setText(item_click_user.getPassword());
                                    customerList_form_address.setText(item_click_user.getAddress());
                                    customerList_form_phone.setText(String.valueOf(item_click_user.getPhone()));
                                } else {
                                    UserService userService = new UserService();
                                    User user_delete = userService.getUserByID(item_click_user.getId());
                                    if (!user_delete.isRenting()) {
                                        if (userService.deleteUser(obUser.get(ind).getId())) {
                                            MyDialog.show("Delete User Successfully!!!");

                                            table_view_customerList.getItems().clear();
                                            obUser.remove(0, obUser.size());
                                            userService = new UserService();
                                            List<User> user_list = userService.getAllUser();
                                            for (User users : user_list) {
                                                obUser.add(users);
                                            }
                                            table_view_customerList.getItems().addAll(obUser);
                                        } else {
                                            MyDialog.show("Delete User Fail!!!");
                                        }
                                    } else {
                                        MyDialog.show("Can't delete right now, it's renting!!");
                                    }
                                }
                            } else {
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
                return cell;
            }
        };
        actionColumn.setCellFactory(factory);
        table_view_customerList.getColumns().add(actionColumn);
    }

    public void addEditDeleteColumnForDriver(String columnName, String buttonName) {
        TableColumn<Driver, Void> actionColumn = new TableColumn<>(columnName);
        Callback<TableColumn<Driver, Void>, TableCell<Driver, Void>> factory = new Callback<TableColumn<Driver, Void>, TableCell<Driver, Void>>() {
            @Override
            public TableCell<Driver, Void> call(TableColumn<Driver, Void> param) {
                final TableCell<Driver, Void> cell = new TableCell<Driver, Void>() {
                    final Button button = new Button(buttonName);

                    {
                        button.setOnAction(e -> {
                            Driver item_click_driver = tableView_driver_list.getSelectionModel().getSelectedItem();
                            int ind = tableView_driver_list.getSelectionModel().getSelectedIndex();
                            if (ind != -1) {
                                if (buttonName.contentEquals("edit")) {

                                    if (item_click_driver.getId() == 1) {
                                        MyDialog.show("Can't Edit No-Driver!!!");
                                    } else {
                                        flagForDriver = true;
                                        driverID = item_click_driver.getId();
                                        driverAvailable = item_click_driver.isAvailable();
                                        driver_form_name.setText(item_click_driver.getName());
                                        driver_form_nrc.setText(item_click_driver.getNrc());
                                        driver_form_phone.setText(String.valueOf(item_click_driver.getPhone()));
                                        driver_form_address.setText(item_click_driver.getAddress());
                                    }
                                } else {
                                    if (item_click_driver.getId() == 1) {
                                        MyDialog.show("Can't Delete No-Driver");
                                    } else {
                                        driverService = new DriverService();
                                        Driver driver_delete = driverService.getDriverByID(item_click_driver.getId());
                                        if (driver_delete.isAvailable()) {
                                            if (driverService.deleteDriver(obDriver.get(ind).getId())) {
                                                MyDialog.show("Delete Driver Successfully!!!");

                                                tableView_driver_list.getItems().clear();
                                                obDriver.remove(0, obDriver.size());
                                                driverService = new DriverService();
                                                List<Driver> driver_list = driverService.getAllDriver();
                                                for (Driver drivers : driver_list) {
                                                    obDriver.add(drivers);
                                                }
                                                tableView_driver_list.getItems().addAll(obDriver);
                                            } else {
                                                MyDialog.show("Delete Driver Fail!!!");
                                            }
                                        } else {
                                            MyDialog.show("Can't delete right now, it's renting!!");
                                        }
                                    }
                                }
                            } else {
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
                return cell;
            }
        };
        actionColumn.setCellFactory(factory);
        tableView_driver_list.getColumns().add(actionColumn);
    }

    public void addEditDeleteColumnForCar(String columnName, String buttonName) {
        TableColumn<Car, Void> actionColumn = new TableColumn<>(columnName);
        Callback<TableColumn<Car, Void>, TableCell<Car, Void>> factory = new Callback<TableColumn<Car, Void>, TableCell<Car, Void>>() {
            @Override
            public TableCell<Car, Void> call(TableColumn<Car, Void> param) {
                final TableCell<Car, Void> cell = new TableCell<Car, Void>() {
                    final Button button = new Button(buttonName);

                    {
                        button.setOnAction(e -> {
                            Car item_click_car = tableView_car_list.getSelectionModel().getSelectedItem();
                            int ind = tableView_car_list.getSelectionModel().getSelectedIndex();
                            if (ind != -1) {
                                if (buttonName.contentEquals("edit")) {
                                    flagForCar = true;
                                    carID = item_click_car.getId();
                                    carAvailable = item_click_car.isAvailable();
                                    car_form_registration_no.setText(item_click_car.getRegNo());
                                    car_form_model.setText(item_click_car.getModel());
                                    car_form_seat.setText(String.valueOf(item_click_car.getSeat()));
                                    car_form_price.setText(String.valueOf(item_click_car.getPrice()));
                                } else {
                                    carService = new CarService();
                                    Car car_delete = carService.getCarByID(item_click_car.getId());
                                    if (car_delete.isAvailable()) {
                                        if (carService.deleteCar(obCar.get(ind).getId())) {
                                            MyDialog.show("Delete Car Successfully!!!");

                                            tableView_car_list.getItems().clear();
                                            obCar.remove(0, obCar.size());
                                            carService = new CarService();
                                            List<Car> car_list = carService.getCarRegNo();
                                            for (Car cars : car_list) {
                                                obCar.add(cars);
                                            }
                                            tableView_car_list.getItems().addAll(obCar);
                                        } else {
                                            MyDialog.show("Delete Car Fail!!!");
                                        }
                                    } else {
                                        MyDialog.show("Can't delete right now, it's renting!!");
                                    }
                                }
                            } else {
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
                return cell;
            }
        };
        actionColumn.setCellFactory(factory);
        tableView_car_list.getColumns().add(actionColumn);
    }

    public void addEditColumnForReturn(String columnName, String buttonName) {
        TableColumn<Received, Void> actionColumn = new TableColumn<>(columnName);
        Callback<TableColumn<Received, Void>, TableCell<Received, Void>> factory = new Callback<TableColumn<Received, Void>, TableCell<Received, Void>>() {
            @Override
            public TableCell<Received, Void> call(TableColumn<Received, Void> param) {
                final TableCell<Received, Void> cell = new TableCell<Received, Void>() {
                    final Button button = new Button(buttonName);

                    {
                        button.setOnAction(e -> {
                            Received item_click_received = return_list_table_view.getSelectionModel().getSelectedItem();

                            if (item_click_received.getReturnID() != -1) {
                                // MyDialog.show(item_click_received.toString());
                                if (buttonName.contentEquals("edit")) {
                                    flag = true;

                                    edit_returnID = item_click_received.getReturnID();
                                    selectedIndex = return_list_table_view.getSelectionModel().getSelectedIndex();

                                    return_form_rent_id.setValue(item_click_received.getRentID() + "");
                                    return_form_return_date.getEditor().setText(item_click_received.getReturnDate());
                                    return_form_extra_day.setText(item_click_received.getExtraDay() + "");
                                    return_form_extra_money.setText(item_click_received.getExtraMoney() + "");
                                }
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
                return cell;
            }
        };
        actionColumn.setCellFactory(factory);
        return_list_table_view.getColumns().add(actionColumn);
    }

    private void loadTableViewForRent() {
        table_col_returnID.setCellValueFactory(new PropertyValueFactory<>("returnID"));
        table_col_rentID.setCellValueFactory(new PropertyValueFactory<>("rentID"));
        table_col_return_date.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        table_col_extraDay.setCellValueFactory(new PropertyValueFactory<>("extraDay"));
        table_col_extraMoney.setCellValueFactory(new PropertyValueFactory<>("extraMoney"));
        table_col_totalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        receivedService = new ReceivedService();
        List<Received> receivedList = receivedService.getAllReceivedForReturnList();

        for (Received received : receivedList) {
            obReceived.add(received);
        }
        return_list_table_view.getItems().addAll(obReceived);
        addEditColumnForReturn("Edit", "edit");
    }

    private void loadTableViewForCarList() {
        table_col_car_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        table_col_car_regNo.setCellValueFactory(new PropertyValueFactory<>("regNo"));
        table_col_car_model.setCellValueFactory(new PropertyValueFactory<>("Model"));
        table_col_car_seat.setCellValueFactory(new PropertyValueFactory<>("Seat"));
        table_col_car_price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        table_col_car_available.setCellValueFactory(new PropertyValueFactory<>("Available"));

        carService = new CarService();
        List<Car> carList = carService.getCarRegNo();

        for (Car cars : carList) {
            obCar.add(cars);
        }
        tableView_car_list.getItems().addAll(obCar);
        addEditDeleteColumnForCar("Edit", "edit");
        addEditDeleteColumnForCar("Delete", "delete");
    }

    private void loadTableViewForActiveRent() {
        table_col_active_rent_rent_id.setCellValueFactory(new PropertyValueFactory<>("rentID"));
        table_col_active_rent_driver_id.setCellValueFactory(new PropertyValueFactory<>("driverID"));
        table_col_active_rent_customer_id.setCellValueFactory(new PropertyValueFactory<>("custID"));
        table_col_active_rent_car_id.setCellValueFactory(new PropertyValueFactory<>("carID"));
        table_col_active_rent_price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        table_col_active_rent_noOfDay.setCellValueFactory(new PropertyValueFactory<>("noOfDay"));
        table_col_active_rent_totalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        table_col_active_rent_fromDate.setCellValueFactory(new PropertyValueFactory<>("fromDate"));
        table_col_active_rent_toDate.setCellValueFactory(new PropertyValueFactory<>("toDate"));
        table_col_active_rent_returnCar.setCellValueFactory(new PropertyValueFactory<>("returnCar"));

        rentService = new RentService();
        List<Rent> rentList = rentService.getAllRent();

        for (Rent rents : rentList) {
            obRent.add(rents);
            //MyDialog.show(rents.getdID()+"\n"+rents.getcID());
        }
        tableView_active_rent_list.getItems().addAll(obRent);
    }

    private void loadTableViewForDriver() {
        table_col_driver_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        table_col_driver_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        table_col_driver_nrc.setCellValueFactory(new PropertyValueFactory<>("Nrc"));
        table_col_driver_phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        table_col_driver_address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        table_col_driver_available.setCellValueFactory(new PropertyValueFactory<>("Available"));

        driverService = new DriverService();
        List<Driver> driversList = driverService.getAllDriver();

        for (Driver drivers : driversList) {
            obDriver.add(drivers);
        }
        tableView_driver_list.getItems().addAll(obDriver);
        addEditDeleteColumnForDriver("Edit", "edit");
        addEditDeleteColumnForDriver("Delete", "delete");
    }

    private void loadTableViewForCustomerList() {
        tableView_customerList_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tableView_customerList_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tableView_customerList_nrc.setCellValueFactory(new PropertyValueFactory<>("Nrc"));
        tableView_customerList_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tableView_customerList_password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        tableView_customerList_address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        tableView_customerList_phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        tableView_customerList_renting.setCellValueFactory(new PropertyValueFactory<>("Renting"));

        userService = new UserService();
        List<User> userList = userService.getAllUser();

        for (User users : userList) {
            obUser.add(users);
        }
        table_view_customerList.getItems().addAll(obUser);
        addEditDeleteColumnForCustomer("Edit", "edit");
        addEditDeleteColumnForCustomer("Delete", "delete");
    }

    private void loadTableViewForOverAllHistory() {
        table_col_overall_history_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        table_col_overall_count.setCellValueFactory(new PropertyValueFactory<>("Count"));
        table_col_overall_history_totalPrice.setCellValueFactory(new PropertyValueFactory<>("TotalPrice"));
        table_col_overall_history_fromDate.setCellValueFactory(new PropertyValueFactory<>("FromDate"));
        table_col_overall_history_toDate.setCellValueFactory(new PropertyValueFactory<>("ToDate"));

        historyService = new HistoryService();
        List<History> historyList = historyService.getAllHistory();

        for (History histories : historyList) {
            obHistory.add(histories);
        }
        tableView_overall_history.getItems().addAll(obHistory);
    }
}
