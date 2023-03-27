package com.ismailboukoti.phonebook.dao;

import com.ismailboukoti.phonebook.dto.request.ContactRequestDto;
import com.ismailboukoti.phonebook.dto.response.ContactNoEmailResponseDto;
import com.ismailboukoti.phonebook.dto.response.ContactResponseDto;
import com.ismailboukoti.phonebook.model.Contact;

import java.util.List;

/**
 * The interface ContactDAO.
 */
public interface ContactDAO {

   /**
    * Saves a contact.
    *
    * @param contactRequestDto the contact
    */
   void save(ContactRequestDto contactRequestDto);

   /**
    * Gets a list of all the contact.
    *
    * @return the all
    */
   List<ContactNoEmailResponseDto> getAll();

   /**
    * Gets contact by id.
    *
    * @param id the id of the contact
    * @return the by id contact
    */
   ContactResponseDto getById(int id);

   /**
    * Update a contact by id.
    *
    * @param contactRequestDto the contact
    * @param id      the id
    */
   void update (ContactRequestDto contactRequestDto, int id);

   /**
    * Delete by id.
    *
    * @param id the id
    */
   void delete (int id);







}


