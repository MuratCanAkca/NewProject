package com.murat.backend.service;

import com.murat.backend.domain.ContactMessage;
import com.murat.backend.exception.ResourceNotFoundException;
import com.murat.backend.exception.message.ErrorMessage;
import com.murat.backend.repository.ContactMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactMessageService {

    // constructın olarak almamız lazım boyle yazdık ama sınıfbase'de allarg olduğu ucun bu contructor oldu
    @Autowired
    private ContactMessageRepository repository;

    public void saveContactMessage(ContactMessage contactMessage) {
        repository.save(contactMessage);
    }

    public List<ContactMessage> getAllContactMessages() {
        return repository.findAll();
    }

    public ContactMessage getContactMessage(Long id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));
    }

    public void deleteContactMessage(Long id) throws ResourceNotFoundException {
        ContactMessage contactMessage = getContactMessage(id);
        repository.deleteById(contactMessage.getId());
        //repository.delete(contactMessage);
    }

    public void updateContactMessage(Long id, ContactMessage newContactMesssage) {
        ContactMessage contactMessage = getContactMessage(id);
        contactMessage.setName(newContactMesssage.getName());
        contactMessage.setEmail(newContactMesssage.getEmail());
        contactMessage.setSubject(newContactMesssage.getSubject());
        contactMessage.setBody(newContactMesssage.getBody());
        repository.save(contactMessage);
    }


}
