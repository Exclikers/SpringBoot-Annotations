package net.spring.boot;

import java.util.List;
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import net.spring.boot.model.Contact;
 
@RestController
@RequestMapping("/api")
public class ContactResource {

    @Autowired
    private ContactService contactService;  

    //List All Contacts
    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    //List Contact by Person
    @GetMapping("/person/{personId}/contact")
    public List<Contact> getContactByPersonId(@PathVariable Long personId) {
        return contactService.getContactByPersonId(personId);
    }
    
    //Add Contact
    @PostMapping("/person/{personId}/contact")
    public Contact addContact(@PathVariable Long personId, @Valid @RequestBody Contact contact) {
        return contactService.addContact(personId, contact);
    }
    
    //Update Contact by Person
    @PutMapping("/person/{personId}/contact/{contactId}")
    public Contact updateContact(@PathVariable Long personId, @PathVariable Long contactId, @Valid @RequestBody Contact contactUpdated) {
        return contactService.updateContact(personId, contactId, contactUpdated);        
    }
    
    //Delete Contact by Person
    @DeleteMapping("/person/{personId}/contact/{contactId}")
    public String deleteContact(@PathVariable Long personId, @PathVariable Long contactId) {
        return contactService.deleteContact(personId, contactId);
    }
}