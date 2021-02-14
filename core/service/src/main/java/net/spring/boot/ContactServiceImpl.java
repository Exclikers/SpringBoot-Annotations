package net.spring.boot;

import java.util.List;
import net.spring.boot.model.Contact;

import net.spring.boot.exception.NotFoundException;
import net.spring.boot.ContactRepository;
import net.spring.boot.PersonRepository;
import net.spring.boot.model.Contact;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ContactServiceImpl implements ContactService {

  @Autowired
  private ContactRepository contactRepository;
  
  @Autowired
  private PersonRepository personRepository;

  public List<Contact> getAllContacts() {
  	return contactRepository.findAll();
  }

  public List<Contact> getContactByPersonId(Long personId) {

        if(!personRepository.existsById(personId)) {
            throw new NotFoundException("Person not found!");
        }
        return contactRepository.findByPersonId(personId);
  }

  public Contact addContact(Long personId, Contact contact) {

	  	if(!personRepository.existsById(personId)) {
	       throw new NotFoundException("Person not found!");
	    }
  	        return personRepository.findById(personId)
                .map(person -> {
                    contact.setPerson(person);
                    return contactRepository.save(contact);
                }).orElseThrow(() -> new NotFoundException("Person not found!"));
  }

  public Contact updateContact(Long personId, Long contactId, Contact contactUpdated) {

  	  if(!personRepository.existsById(personId)) {
        	throw new NotFoundException("Person not found!");
      }
      
      return contactRepository.findById(contactId)
                .map(contact -> {
                    contact.setLandline(contactUpdated.getLandline());
                    contact.setMobile(contactUpdated.getMobile());
                    contact.setEmail(contactUpdated.getEmail());
                    return contactRepository.save(contact);
                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
  }

  public String deleteContact(Long personId, Long contactId) {

  	  if(!personRepository.existsById(personId)) {
        throw new NotFoundException("Person not found!");
      }
      
        return contactRepository.findById(contactId)
                .map(contact -> {
                    contactRepository.delete(contact);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
  }
}