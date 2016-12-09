package de.kevcodez.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AbstractEntity {

    private String name;
    private String street;
    private String zipCode;

}
