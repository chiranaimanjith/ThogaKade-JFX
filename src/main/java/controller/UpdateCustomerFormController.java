package controller;

import DBConnection.DBConnection;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Customer;
import java.time.LocalDate;
import java.util.List;

public class UpdateCustomerFormController {

    public TextField txtNumber;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtId;
    public JFXTextArea txtSearch;
    public DatePicker dobDate;
    private ComboBox<String> cmbTitle;


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
        dobDate.setValue(obj.getDateOfBirthday());
    }

    @FXML
    void UpdateOnAction(ActionEvent event) {
        String id= txtId.getText();
        String title= cmbTitle.getValue();
        String name =txtName.getText();
        String address=txtAddress.getText();
        String number =txtNumber.getText();
        LocalDate dob= dobDate.getValue();

        List<Customer> customerList = DBConnection.getInstance().getConnetion();
        customerList.forEach(obj->{
            if(obj.getId().equals(id)){
                obj.setName(name);
                obj.setTitle(title);
                obj.setAddress(address);
                obj.setNumber(number);
                obj.setDateOfBirthday(dob);
            }
        });

        if (customerList!=null) {
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Failed to update customer.");
        }
    }
}
