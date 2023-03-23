package com.ismailboukoti.phonebook.mapper;

import com.ismailboukoti.phonebook.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The class ContactMapper that implements a JdbcTemplate interface for mapping the rows of a resultset.
 */
public class ContactMapper implements RowMapper<Contact> {

    //The mapRow method maps the values of the current row using resultset.
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setId(rs.getInt("id"));
        contact.setName(rs.getString("name"));
        contact.setEmail(rs.getString("email"));
        contact.setPhoneNumber(rs.getString("phonenumber"));
        return contact;
    }
}
