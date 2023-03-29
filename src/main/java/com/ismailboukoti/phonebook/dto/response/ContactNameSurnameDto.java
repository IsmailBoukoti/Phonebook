package com.ismailboukoti.phonebook.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactNameSurnameDto {

    private int id;
    private String name;
    private String surname;


}
