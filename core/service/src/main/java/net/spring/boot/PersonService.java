package net.spring.boot;

import java.util.List;
import net.spring.boot.model.Person;

public interface PersonService {

	List<Person> getPerson();
	Person getPersonById(Long id);
	String createPerson(Person person);
	String updatePerson(Long id, Person personUpdated);
	String deletePerson(Long id);
	String addPersonRole(Long personId, Long roleId);
	String deletePersonRole(Long personId, Long roleId);

}