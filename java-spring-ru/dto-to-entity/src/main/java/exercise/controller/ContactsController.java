package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO contactData) {
        var contact = toEntity(contactData);
        contactRepository.save(contact);

        var contactDTO = toDTO(contact);
        return contactDTO;
    }

    private Contact toEntity(ContactCreateDTO contactData) {
        var contact = new Contact();
        contact.setLastName(contactData.getLastName());
        contact.setFirstName(contactData.getFirstName());
        contact.setPhone(contactData.getPhone());
        return contact;
    }

    private ContactDTO toDTO(Contact contact) {
        var contactDTO = new ContactDTO();
        contactDTO.setId(contact.getId());
        contactDTO.setLastName(contact.getLastName());
        contactDTO.setFirstName(contact.getFirstName());
        contactDTO.setPhone(contact.getPhone());
        contactDTO.setCreatedAt(contact.getCreatedAt());
        contactDTO.setUpdatedAt(contact.getUpdatedAt());

        return contactDTO;
    }
    // END
}
