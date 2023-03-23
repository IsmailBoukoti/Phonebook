package com.ismailboukoti.phonebook.dao;

import com.ismailboukoti.phonebook.dto.request.ContactRequestDto;
import com.ismailboukoti.phonebook.dto.response.ContactNoEmailResponseDto;
import com.ismailboukoti.phonebook.dto.response.ContactResponseDto;
import com.ismailboukoti.phonebook.mapper.ContactMapper;
import com.ismailboukoti.phonebook.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(ContactRequestDto contactRequestDto) {
        String sql = "INSERT INTO contacts (name, email, phonenumber) VALUES (?,?,?)";
        jdbcTemplate.update(sql, contactRequestDto.getName(),contactRequestDto.getEmail(),contactRequestDto.getPhoneNumber());
    }

    @Override
    public List<ContactNoEmailResponseDto> getAll() {
        String sql = "SELECT * FROM contacts";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new ContactNoEmailResponseDto(
                                rs.getString("name"),
                                rs.getString("phonenumber")
                        )
        );
    }

    @Override
    public ContactResponseDto getById(int id) {
        String sql = "SELECT * FROM contacts WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new ContactResponseDto(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phonenumber")
                ), id);
    }

    @Override
    public void update(ContactRequestDto contactRequestDto, int id) {
        jdbcTemplate.update("UPDATE contacts SET name=?, email=?, phonenumber=? WHERE id =?",
                contactRequestDto.getName(),contactRequestDto.getEmail(),contactRequestDto.getPhoneNumber(),id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM contacts WHERE id=?", id);
    }
}
