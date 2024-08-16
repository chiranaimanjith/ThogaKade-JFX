package DBConnection;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection instance;
    private List<Customer> customerList;
    
    private DBConnection(){
        this.customerList=new ArrayList<>();
    }

    public List<Customer> getConnetion(){
        return customerList;
    }

    public static DBConnection getInstance() {
        return instance==null?instance=new DBConnection():instance;
    }
}
