package com.ismailboukoti.phonebook.dao;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;
import static org.junit.jupiter.api.Assertions.*;


public class ContactDAOImplTest {

    @Test
    public void getAll() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:Mockschema.sql")
                .addScript("classpath:test-data.sql")
                .build();
        ContactDAOImpl contactDAO = new ContactDAOImpl();
        contactDAO.setDataSource(dataSource);
        assertEquals(4, contactDAO.getAll().size());
    }
}