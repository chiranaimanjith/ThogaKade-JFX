package controller;

import DBConnection.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.util.List;

public class ViewCustomerFormController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNumber;

    @FXML
    private TableView<Customer> tblCustemers;

    @FXML
    void RealodeOnAction(ActionEvent event) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirthday"));

        List<Customer> customerList = DBConnection.getInstance().getConnetion();
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList(customerList);
        tblCustemers.setItems(customerObservableList);
    }

}
