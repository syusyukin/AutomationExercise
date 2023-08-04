package model.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Card {
    private String name;
    private String number;
    private String ccv;
    private String expirationMonth;
    private String expirationYear;
}
