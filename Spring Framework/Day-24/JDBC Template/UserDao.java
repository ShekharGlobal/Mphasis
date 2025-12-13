package com.example.jdbctemplate;
import java.util.List;

public interface UserDao {
    void createUser(String name);
    List<String> getUsers();
    void updateUser(int id, String name);
    void deleteUser(int id);
}
