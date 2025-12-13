package com.example.jdbctemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * 
 * CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

 * @author Shekhar
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createUser(String name) {
        String sql = "INSERT INTO students (name) VALUES (?)";
        jdbcTemplate.update(sql, name);
    }

    @Override
    public List<String> getUsers() {
        String sql = "SELECT name FROM students";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public void updateUser(int id, String name) {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
