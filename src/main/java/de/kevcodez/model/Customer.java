package de.kevcodez.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends AbstractEntity {

    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private List<Address> addresses = new ArrayList<>();

}
