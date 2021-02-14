package net.spring.boot;

import org.springframework.data.jpa.repository.JpaRepository;
import net.spring.boot.model.Person;
 
public interface PersonRepository extends JpaRepository<Person, Long> {
}