package com.example.accessing_data_mysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    // Récupérer tous les messages

    @GetMapping
    public Iterable<Message> getAllMessages() {
        return messageRepository.findAll(); 
    }
    

    // Récupérer un message par ID
    @GetMapping("/filter")
    public List<Message> findByidRecever(@RequestParam int id){
        return messageRepository.findLast10Messages(id);
    }
        
    /*public ResponseEntity<Message> getMessageById(@PathVariable Integer id) {
        return messageRepository.findById(id)
                .map(message -> ResponseEntity.ok().body(message))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }*/

    // Créer un nouveau message
    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message savedMessage = messageRepository.save(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMessage);
    }

    // Mettre à jour un message
    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Integer id, @RequestBody Message messageDetails) {
        return messageRepository.findById(id)
                .map(message -> {
                    message.setMessage_object(messageDetails.getMessage_object());
                    message.setMessage_body(messageDetails.getMessage_body());
                    message.setidSender(messageDetails.getidSender());
                    message.setidRecever(messageDetails.getidRecever());
                    message.setSender_timestamp(messageDetails.getSender_timestamp());
                    message.setReceiver_timestamp(messageDetails.getReceiver_timestamp());
                    Message updatedMessage = messageRepository.save(message);
                    return ResponseEntity.ok(updatedMessage);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Supprimer un message
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Integer id) {
        return messageRepository.findById(id)
                .map(message -> {
                    messageRepository.delete(message);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}