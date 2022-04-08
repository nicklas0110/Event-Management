package GUI.controller.EventCoordinatorControllers;

import BE.Customer;
import BE.Event;
import GUI.Model.CustomerModel;
import GUI.controller.SimpleDialogController;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateCustomerController implements Initializable {
    public CustomerModel customerModel;
    public Customer selectedCustomer;
    public PieChart overOrUnder12YearsPieChart;
    public Text eventNameTxt;
    public JFXButton printTicket;
    private int over12;
    private int under12;


    public TableView<Customer> tvCustomers;
    public TableColumn<Customer, String> tcCustomerID;
    public TableColumn<Customer, String> tcFirstName;
    public TableColumn<Customer, String> tcLastName;
    public TableColumn<Customer, String> tcPhoneNumber;
    public TableColumn<Customer, String> tcEmail;

    public TextField customerNameTxt;
    public TextField customerLastNameTxt;
    public TextField customerPhoneNumberTxt;
    public TextField customerEmailTxt;

    public JFXButton addCustomer;
    public JFXButton btnBack;
    public JFXButton deleteCustomer;
    public JFXButton editCustomer;
    public CheckBox checkBoxOver12Years;

    public Text under12YearsTxt;
    public Text over12YearsTxt;

    private Event selectedEvent;

    public CreateCustomerController() {
        customerModel = new CustomerModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tvCustomers.setOnMouseClicked((MouseEvent event) -> {
            setSelectedItems();
        });
    }


    public void addCustomerBtn(ActionEvent event) throws SQLException {
        String uploadName = customerNameTxt.getText().replaceAll(" ", "");
        String uploadLastName = customerLastNameTxt.getText().replaceAll(" ", "");
        String uploadPhoneNumber = customerPhoneNumberTxt.getText().replaceAll(" ", "");
        uploadPhoneNumber = uploadPhoneNumber.replaceAll(" ", "");
        uploadPhoneNumber = uploadPhoneNumber.replaceAll("\\+", "");
        uploadPhoneNumber = uploadPhoneNumber.replaceAll("-", "");
        String uploadEmail = customerEmailTxt.getText().replaceAll(" ", "");
        boolean uploadOver12År = checkBoxOver12Years.isSelected();
        uploadCustomerInfo(uploadName, uploadLastName, uploadPhoneNumber, uploadEmail, uploadOver12År, selectedEvent.getEventId());
        setAge();
    }

    private void uploadCustomerInfo(String name, String lastName, String phoneNumber, String email, boolean uploadOver12År, int eventID) throws SQLException {
        customerModel.addCustomer(name, lastName, phoneNumber, email, uploadOver12År, eventID);
        customerNameTxt.clear();
        customerLastNameTxt.clear();
        customerPhoneNumberTxt.clear();
        customerEmailTxt.clear();
        checkBoxOver12Years.setSelected(false);
        tvCustomers.refresh();
    }

    public void handleBtnBack(ActionEvent event) throws IOException {
        backEventCoordinator(event);
    }

    public void deleteCustomerBtn(ActionEvent event) {
        if (SimpleDialogController.delete() && selectedCustomer != null) {
            customerModel.removeCustomer(selectedCustomer);
            tvCustomers.refresh();
        }
    }

    public void EditCustomerBtn(ActionEvent event) {
    }

    private void backEventCoordinator(ActionEvent event) throws IOException {
        Stage switcher = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/EventCoordinatorViews/EventCoordinator.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    /**
     * m
     * Method used for initializing the Customers table.
     */
    private void setCustomersView() throws IOException {

        tcCustomerID.setCellValueFactory(new PropertyValueFactory<>("id"));

        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("Name"));

        tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tcPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));


        tvCustomers.setItems(customerModel.getCustomers(selectedEvent.getEventId()));

    }


    /**
     * Changes selected Name  in the adminEventMangerTableViewName
     */
    private void setSelectedItems() {
        if (tvCustomers.getSelectionModel().getSelectedItem() != null) {
            selectedCustomer = tvCustomers.getSelectionModel().getSelectedItem();
        }

    }

    public int setAgeOver12() {
        over12 = customerModel.getAgeUnderOrOver12(true);
        return over12;
    }

    public int setAgeUnder12() {
        under12 = customerModel.getAgeUnderOrOver12(false);
        return under12;
    }

    public void setAge() {
        String under12InProcentString = "", over12InProcentString = "";
        setAgeOver12();
        setAgeUnder12();
        int total = under12 + over12;
        if(total > 0){
            double under12Procent = Math.round((Double.valueOf(under12) / total) * 100);
            double over12Procent = Math.round((over12 / Double.valueOf(total)) * 100); //Dividing 2 ints did not allow < 0, if casting 1 to double then it worked...
            under12InProcentString = "(" + under12Procent + "%)";
            over12InProcentString = "(" + over12Procent + "%)";
        }
        under12YearsTxt.setText(under12 + " " + under12InProcentString);
        over12YearsTxt.setText(over12 + " " + over12InProcentString);

        initPieChartUnderAndOver12();
    }

    public void initPieChartUnderAndOver12() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Under 12", under12),
                        new PieChart.Data("Over 12", over12)
                );
        overOrUnder12YearsPieChart.setTitle("Aldersfordeling");
        overOrUnder12YearsPieChart.setData(pieChartData);
    }

    public void setEventID(Event event){
        selectedEvent = event;
        eventNameTxt.setText(event.getEventName());
        try {
            setCustomersView();
            setAge();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printTicketBtn(ActionEvent actionEvent) {
    }
}
