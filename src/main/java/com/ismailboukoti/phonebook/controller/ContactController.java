package com.ismailboukoti.phonebook.controller;

import com.ismailboukoti.phonebook.dao.ContactDAO;
import com.ismailboukoti.phonebook.dto.request.ContactRequestDto;
import com.ismailboukoti.phonebook.dto.response.ContactNoEmailResponseDto;
import com.ismailboukoti.phonebook.dto.response.ContactResponseDto;
import com.ismailboukoti.phonebook.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Contact controller.
 */
@RestController
@RequestMapping("/phonebook")
public class ContactController {

    @Autowired
    private ContactDAO contactDAO;

    /**
     * A welcome message for the /phonebook endpoint.
     *
     * @return the welcome message string
     */
    @GetMapping
    public String welcomeMessage(){
        return "Welcome to your phonebook app!";
    }

    /**
     * Retrieves the list of contacts .
     *
     * @return the list of contacts
     */
    @GetMapping("/contacts")
    public List<ContactNoEmailResponseDto> getContacts(){
      return  contactDAO.getAll();
    }

    /**
     * Retrieves a single contact by passing an id number as path variable.
     *
     * @param id the id of the contact
     * @return the contact
     */
    @GetMapping("/contacts/{id}")
    public ContactResponseDto getContactById(@PathVariable int id){
       return contactDAO.getById(id);
    }

    /**
     * Saves a contact.
     *
     * @param contactRequestDto the contact
     * @return The HTTP 201 Created status code and contact as body.
     */
    @PostMapping("/contacts")
    public ResponseEntity<String> saveContact(@RequestBody ContactRequestDto contactRequestDto){
        contactDAO.save(contactRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(contactRequestDto + "The contact has been saved");
    }

    /**
     * Updates a contact.
     *
     * @param id      the id of the contact
     * @param contactRequestDto the contact
     * @return void
     */
    @PutMapping("/contacts/{id}")
    public ResponseEntity<String> updateContact(@PathVariable int id,@RequestBody ContactRequestDto contactRequestDto){
        contactDAO.update(contactRequestDto,id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("The contact has been updated");
    }

    /**
     * Deletes a contact by passing an id number as path variable.
     *
     * @param id the id of the contact
     * @return void
     */
    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        contactDAO.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("The contact has been deleted");
    }
}
