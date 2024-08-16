package controller;

import DBConnection.DBConnection;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Customer;
import java.util.List;

public class SearchCustomerFormController {

    public JFXTextArea txtSearch;
    @FXML
    private Label lblAddress;

    @FXML
    private Label lblDOB;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblNumber;

    @FXML
    void SerachOnAction(ActionEvent event) {
        if (txtSearch.getText() != null) {
            List<Customer> customerList = DBConnection.getInstance().getConnetion();
            customerList.forEach(obj -> {
                if (obj.getId().equals(txtSearch.getText())) {
                    LoadSearch(obj);
                }
            });

        }else{
            System.out.println("error");
        }
    }

    private void LoadSearch(Customer obj) {
        lblId.setText(obj.getId());
        lblName.setText(obj.getName());
        lblAddress.setText(obj.getAddress());
        lblNumber.setText(obj.getNumber());
        lblDOB.setText(obj.getDateOfBirthday().toString());
    }
}
