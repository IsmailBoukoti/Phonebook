package com.ismailboukoti.phonebook.dao;
import com.ismailboukoti.phonebook.exception.ApiRequestException;
import com.ismailboukoti.phonebook.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;

/**
 * ContactDAOImpl is the implementation class for the ContactDao .
 */
@Repository
public class ContactDAOImpl implements ContactDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Contact save(Contact contact) {
        String sql = "INSERT INTO contacts (name, surname, address, email, phonenumber) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, contact.getName(), contact.getSurname(), contact.getAddress(), contact.getEmail(), contact.getPhoneNumber());
        return contact;
    }

    @Override
    public List<Contact> getAll() {
        String sql = "SELECT * FROM contacts";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new Contact(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("surname")
                        )
        );
    }

    @Override
    public Contact getById(int id) {
        try {
            String sql = "SELECT * FROM contacts WHERE ID = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                    new Contact(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("address"),
                            rs.getString("email"),
                            rs.getString("phonenumber")
                    ), id);
        } catch (DataAccessException e) {
            throw new ApiRequestException("The requested contact cannot be found");
        }
    }

    @Override
    public void update(Contact contact, int id) {
        try {
            jdbcTemplate.update("UPDATE contacts SET name=?,surname=?,address=?, email=?, phonenumber=? WHERE id =?",
                    contact.getName(),contact.getSurname(),contact.getAddress(), contact.getEmail(), contact.getPhoneNumber(), id);
        } catch (DataAccessException e) {
            throw new ApiRequestException("The requested contact that you want to update cannot be found");
        }
    }

    @Override
    public void delete(int id) {
        try {
            jdbcTemplate.update("DELETE FROM contacts WHERE id=?", id);
        } catch (DataAccessException e) {
            throw new ApiRequestException("The requested contact that you want to delete cannot be found");
        }
    }
}
