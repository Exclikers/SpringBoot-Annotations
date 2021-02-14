package net.spring.boot;

import java.util.List;
import net.spring.boot.model.Contact;

public interface ContactService {

	List<Contact> getAllContacts();
	List<Contact> getContactByPersonId(Long personId);
	Contact addContact(Long personId, Contact contact);
	Contact updateContact(Long personId, Long contactId, Contact contactUpdated);
	String deleteContact(Long personId, Long contactId);
}