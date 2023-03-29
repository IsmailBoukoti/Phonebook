package com.ismailboukoti.phonebook.dao;

import com.ismailboukoti.phonebook.model.Contact;

import java.util.List;

/**
 * The interface ContactDAO.
 */
public interface ContactDAO {

   /**
    * Saves a contact.
    *
    * @param contact the contact
    */
   Contact save(Contact contact);

   /**
    * Gets a list of all the contact.
    *
    * @return the all
    */
   List<Contact> getAll();

   /**
    * Gets contact by id.
    *
    * @param id the id of the contact
    * @return the by id contact
    */
   Contact getById(int id);

   /**
    * Update a contact by id.
    *
    * @param contact the contact
    * @param id      the id
    */
   void update (Contact contact, int id);

   /**
    * Delete by id.
    *
    * @param id the id
    */
   void delete (int id);







}


