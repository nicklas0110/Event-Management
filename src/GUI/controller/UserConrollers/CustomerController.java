package GUI.controller.UserConrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import java.io.IOException;



public class CustomerController {
    @FXML
    private Button myTickets;
    @FXML
    private Button logOutCustomer;

    public void logOutCustomerBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) logOutCustomer.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/MainLoginView.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);
    }

    public void buyTicketsBtn(ActionEvent actionEvent) {
    }

    public void myTicketsBtn(ActionEvent actionEvent) throws IOException {
        Stage switcher = (Stage) myTickets.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/CustomerViews/MyTickets.fxml"));
        Scene scene = new Scene(root);
        switcher.setTitle("EventCoordinatorManagement");
        switcher.setScene(scene);

    }
}
