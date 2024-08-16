package controller;

import DBConnection.DBConnection;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Customer;

import java.util.List;

public class UpdateCustomerFormController {

    public TextField txtNumber;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtDOB;
    public TextField txtId;
    public JFXTextArea txtSearch;


    public void SearchOnAction(ActionEvent actionEvent) {
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
        txtId.setText(obj.getId());
        txtName.setText(obj.getName());
        txtAddress.setText(obj.getAddress());
        txtNumber.setText(obj.getNumber());
        txtDOB.setText(obj.getDateOfBirthday().toString());
    }

    @FXML
    void UpdateOnAction(ActionEvent event) {
//        String id = txtId.getText().trim();
//        String name = txtName.getText().trim();
//        String address = txtAddress.getText().trim();
//        String number = txtNumber.getText().trim();
//        String dob = txtDOB.getText().trim(); // Parse to Date if necessary
//
//        if (id.isEmpty() || name.isEmpty() || address.isEmpty() || number.isEmpty() || dob.isEmpty()) {
//            System.out.println("All fields must be filled.");
//            return;
//        }
//
//        Customer updatedCustomer = new Customer(id, name, address, number, dob); // Adjust constructor
//        boolean success = DBConnection.getInstance().getConnetion(updatedCustomer);
//
//        if (success) {
//            System.out.println("Customer updated successfully.");
//        } else {
//            System.out.println("Failed to update customer.");
//        }
    }
}
