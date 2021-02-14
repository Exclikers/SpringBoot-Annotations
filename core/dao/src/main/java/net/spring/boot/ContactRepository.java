package net.spring.boot;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import net.spring.boot.model.Contact;
 
public interface ContactRepository extends JpaRepository<Contact, Long> {
   List<Contact> findByPersonId(Long personId);
}