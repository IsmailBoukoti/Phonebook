package com.ismailboukoti.phonebook.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponseDto {
    private String name;
    private String email;
    private String phoneNumber;
}

