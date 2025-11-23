package com.murat.backend.controller;

import com.murat.backend.domain.ContactMessage;
import com.murat.backend.service.ContactMessageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contactmessage")
@AllArgsConstructor
public class ContactMessageController {

    @Autowired
    ContactMessageService contactMessageService;

    // burayı securityden dısarı açacağız
    @PostMapping("/visitor")
    public ResponseEntity<Map<String, String>> createMessage(@Valid @RequestBody ContactMessage contactMessage) {

        contactMessageService.saveContactMessage(contactMessage);

        Map<String, String> map = new HashMap<>();
        map.put("message", "Contact Message Succesfully Created");
        map.put("Status", "True");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAllContactMessages() {
        List<ContactMessage> list = contactMessageService.getAllContactMessages();
        return ResponseEntity.ok(list);
    }


}
