package com.ismailboukoti.phonebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The class Contact.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    private int id;
    private String name;
    private String email;
    private String phoneNumber;

}
