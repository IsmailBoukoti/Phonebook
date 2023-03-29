package com.ismailboukoti.phonebook.controller;
import com.ismailboukoti.phonebook.dao.ContactDAO;
import com.ismailboukoti.phonebook.dto.ContactDTO;
import com.ismailboukoti.phonebook.dto.response.ContactNameSurnameDto;
import com.ismailboukoti.phonebook.model.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Contact controller.
 */
@RestController
@RequestMapping("/phonebook")
public class ContactController {

    @Autowired
    private ContactDAO contactDAO;

    @Autowired
    ModelMapper modelMapper;

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
    public List<ContactNameSurnameDto> getContacts(){
      return  contactDAO.getAll().stream().map(contact -> modelMapper.map(contact, ContactNameSurnameDto.class))
              .collect(Collectors.toList());
    }

    /**
     * Retrieves a single contact by passing an id number as path variable.
     *
     * @param id the id of the contact
     * @return the contact
     */
    @GetMapping("/contacts/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable int id){
        Contact contact = contactDAO.getById(id);
        ContactDTO contactDTO = modelMapper.map(contact,ContactDTO.class);
       return ResponseEntity.status(HttpStatus.OK).body(contactDTO);
    }

    /**
     * Saves a contact.
     *
     * @param contactDTO the contact
     * @return The HTTP 201 Created status code and contact as body.
     */
    @PostMapping("/contacts")
    public ResponseEntity<ContactDTO> saveContact(@RequestBody ContactDTO contactDTO){
        Contact contactRequest = modelMapper.map(contactDTO, Contact.class);
        Contact contact = contactDAO.save(contactRequest);
        ContactDTO contactResponse = modelMapper.map(contact,ContactDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(contactResponse);
    }

    /**
     * Updates a contact.
     *
     * @param id      the id of the contact
     * @param contactDTO the contact
     * @return void
     */
    @PutMapping("/contacts/{id}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable int id,@RequestBody Contact contactDTO){
        Contact contactRequest = modelMapper.map(contactDTO, Contact.class);
        Contact contact = contactDAO.save(contactRequest);
        ContactDTO contactResponse = modelMapper.map(contact,ContactDTO.class);
        contactDAO.update(contactDTO,id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(contactResponse);
    }

    /**
     * Deletes a contact by passing an id number as path variable.
     *
     * @param id the id of the contact
     * @return void
     */
    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable int id) {
        contactDAO.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
