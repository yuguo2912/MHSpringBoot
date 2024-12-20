package com.example.accessing_data_mysql;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.accessing_data_mysql.Message;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MessageRepository extends CrudRepository<Message, Integer> {
    @Query(value = "SELECT * FROM Message ORDER BY id DESC LIMIT 10", nativeQuery = true)
    List<Message>findLast10Messages(int id);
    //List<Message>findByidRecever(int id);
}