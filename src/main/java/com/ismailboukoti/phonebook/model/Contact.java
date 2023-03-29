package com.ismailboukoti.phonebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The class Contact.
 */
@Data
@NoArgsConstructor
public class Contact {

    private int id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String phoneNumber;

    public Contact(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Contact(int id, String name, String surname, String address, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
