package model.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationData {
    public enum Title {
        MR, MRS
    }
    private Title title;
    private String name;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private String city;
    private String zipCode;
    private String phoneNumber;
}
