package model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Customer {
    private String id;
    private String title;
    private String name;
    private String address;
    private String number;
    private LocalDate dateOfBirthday;

    public Customer(String id, String title, String name, String address, String number, LocalDate dateOfBirthday) {
        this.id = id;
        this.name = title+". "+name;
        this.address = address;
        this.number = number;
        this.dateOfBirthday = dateOfBirthday;
    }
}
