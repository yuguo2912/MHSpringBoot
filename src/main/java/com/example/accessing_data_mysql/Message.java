package com.example.accessing_data_mysql;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Message {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id_message;
  private String message_object;
  private String message_body;
  private int idSender;
  private int idRecever;
  private LocalDateTime sender_timestamp;
  private LocalDateTime receiver_timestamp;
    

    public Integer getId_message() {
        return id_message;
    }

    public void setId_message(Integer id_message) {
        this.id_message = id_message;
    }

    // Getter et Setter pour message_object
    public String getMessage_object() {
        return message_object;
    }

    public void setMessage_object(String message_object) {
        this.message_object = message_object;
    }

    // Getter et Setter pour message_body
    public String getMessage_body() {
        return message_body;
    }

    public void setMessage_body(String message_body) {
        this.message_body = message_body;
    }

    // Getter et Setter pour idSender
    public int getidSender() {
        return idSender;
    }

    public void setidSender(int idSender) {
        this.idSender = idSender;
    }

    // Getter et Setter pour idRecever
    public int getidRecever() {
        return idRecever;
    }

    public void setidRecever(int idRecever) {
        this.idRecever = idRecever;
    }

    // Getter et Setter pour sender_timestamp
    public LocalDateTime getSender_timestamp() {
        return sender_timestamp;
    }

    public void setSender_timestamp(LocalDateTime sender_timestamp) {
        this.sender_timestamp = sender_timestamp;
    }

    // Getter et Setter pour receiver_timestamp
    public LocalDateTime getReceiver_timestamp() {
        return receiver_timestamp;
    }

    public void setReceiver_timestamp(LocalDateTime receiver_timestamp) {
        this.receiver_timestamp = receiver_timestamp;
    }


  
}