package controller;

import DBConnection.DBConnection;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Customer;

import java.util.List;

public class DeleteCustomerFormController {

    public JFXTextArea txtSearch;
    @FXML
    private Label lblAddress;

    @FXML
    private Label lblBirthday;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblNumber;

    public void searchOnAction(ActionEvent actionEvent) {
        if (txtSearch.getText() != null) {
            List<Customer> customerList = DBConnection.getInstance().getConnetion();
            customerList.forEach(obj -> {
                if (obj.getId().equals(txtSearch.getText())) {
                    LoadSearch(obj);
                }
            });

        } else {
            System.out.println("error");
        }
    }

    private void LoadSearch(Customer obj) {
        lblId.setText(obj.getId());
        lblName.setText(obj.getName());
        lblAddress.setText(obj.getAddress());
        lblNumber.setText(obj.getNumber());
        lblBirthday.setText(obj.getDateOfBirthday().toString());
    }

    @FXML
    void deleteOnAction(ActionEvent event) {
        if (txtSearch.getText() != null && !txtSearch.getText().isEmpty()) {
            List<Customer> customerList = DBConnection.getInstance().getConnetion();  // Assuming this returns a List<Customer>
            Customer toDelete = null;

            for (Customer obj : customerList) {
                if (obj.getId().equals(txtSearch.getText())) {
                    toDelete = obj;  // Mark the object to be deleted
                    break;  // Exit the loop once the object is found
                }
            }

            if (toDelete != null) {
                customerList.remove(toDelete);  // Remove the object from the list
                // Optionally, update the data source (e.g., database) to reflect the deletion
               // DBConnection.getInstance().updateDatabase(customerList);  // This is a placeholder; implement as needed
                System.out.println("Customer removed successfully.");
            } else {
                System.out.println("Customer not found.");
            }

        } else {
            System.out.println("Error: Search text is empty.");
        }


    }
}
