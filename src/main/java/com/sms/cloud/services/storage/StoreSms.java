package com.sms.cloud.services.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreSms {

    @Autowired
    private StoreToFile storeToFile;

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    @RequestMapping(path = "/sms", method = RequestMethod.POST)
    public ResponseEntity<Message> storeSMS(@RequestBody Message entity) {
        Message body = entity;
        Message message = messageCrudRepository.save(body);
        return new ResponseEntity(message, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/sms", method = RequestMethod.GET)
    public ResponseEntity<List<Message>> getSMSData() {
        Iterable<Message> messages = messageCrudRepository.findAll();
        List<Message> msgs = new ArrayList<>();
        messages.forEach(msgs::add);
        return new ResponseEntity<>(msgs, HttpStatus.OK);
    }
}
