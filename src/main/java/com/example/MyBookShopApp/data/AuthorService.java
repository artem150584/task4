package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAuthorData() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors ORDER BY name", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setId(rs.getInt("author_id"));
            author.setName(rs.getString("name"));

            return author;
        });

        return new ArrayList<>(authors);
    }
}
