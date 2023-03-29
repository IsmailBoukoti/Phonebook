package com.ismailboukoti.phonebook.controller;
import static org.assertj.core.api.Assertions.assertThat;
import com.ismailboukoti.phonebook.dao.ContactDAO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class ContactControllerTest {

    @InjectMocks
    ContactController contactController;

    @Mock
    ContactDAO contactDAO;

   /* @Test
   public  void getContacts() {
        ContactNoEmailResponseDto contact1 = new ContactNoEmailResponseDto("Mario", "3271318745");
        ContactNoEmailResponseDto contact2 = new ContactNoEmailResponseDto("Luca", "3271318220");

        List<ContactNoEmailResponseDto> contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);
        when(contactDAO.getAll()).thenReturn(contacts);

        List<ContactNoEmailResponseDto> result = contactController.getContacts();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo(contact1.getName());
        assertThat(result.get(1).getName()).isEqualTo(contact2.getName());
    }*/



    @Test
    void getContactById() {
    }

    @Test
    public void saveContact() {
    }

    @Test
    void updateContact() {
    }

    @Test
    void deleteContact() {
    }
}
