package controller;

import DBConnection.DBConnection;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private DatePicker dpDOB;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("Mr");
        titles.add("Miss");
        cmbTitle.setItems(titles);
    }

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {
        List<Customer> customerList= DBConnection.getInstance().getConnetion();
        customerList.add(
                new Customer(
                        txtId.getText(),
                        cmbTitle.getValue(),
                        txtName.getText(),
                        txtAddress.getText(),
                        txtNumber.getText(),
                        dpDOB.getValue()
                )
        );
        fieldClear();
   }

    private void fieldClear() {
                txtId.setText("");
                cmbTitle.setValue("");
                txtName.setText("");
                txtAddress.setText("");
                txtNumber.setText("");
                dpDOB.setValue(null);
    }


}
