package model.factory;

import model.person.Card;
import model.person.RegistrationData;

public class DataFactory {
    public RegistrationData createRegistrationData(){
        return RegistrationData.builder()
                .name("IvanTest")
                .email("IvanTest@test.com")
                .password("123456")
                .address("some adress")
                .city("some city")
                .firstName("name")
                .lastName("lastName")
                .phoneNumber("1234")
                .state("asd")
                .zipCode("1234")
                .title(RegistrationData.Title.MR)
                .build();
    }

    public RegistrationData getExistingAccountData(){
        return RegistrationData.builder()
                .email("IvanPersisted@test.com")
                .password("123456")
                .build();
    }

    public Card getCard(){
        return Card.builder()
                .name("Ivan")
                .number("13243145154")
                .ccv("123")
                .expirationMonth("11")
                .expirationYear("2025")
                .build();
    }
}
