package com.ismailboukoti.phonebook.dto.request;

import lombok.Data;

@Data
public class ContactRequestDto {

    private String name;
    private String email;
    private String phoneNumber;

}
