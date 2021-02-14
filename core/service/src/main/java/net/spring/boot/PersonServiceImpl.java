package net.spring.boot;

import java.util.List;
import java.util.Set;
import java.util.Optional;
import java.util.Iterator;

import net.spring.boot.PersonRepository;
import net.spring.boot.RoleRepository;
import net.spring.boot.model.Person;
import net.spring.boot.model.Role;
import net.spring.boot.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
  	private PersonRepository personRepository;

  	@Autowired
    private RoleRepository roleRepository;


  	public List<Person> getPerson() {	
  		return personRepository.findAll();
  	}

  	public Person getPersonById(Long id) {
  	  Optional<Person> optPerson = personRepository.findById(id);
      if(optPerson.isPresent()) {
        return optPerson.get();
      }else {
        throw new NotFoundException("Person not found with id " + id);
      }

  	}

  	public String createPerson(Person person) {
  		personRepository.save(person);
        return "Person Successfully Added!";
  	}

  	public String updatePerson(Long id, Person personUpdated) {

  		personRepository.findById(id)
                .map(person -> {
                    person.setTitle(personUpdated.getTitle());
                    person.setFirstName(personUpdated.getFirstName());
                    person.setLastName(personUpdated.getLastName());
                    person.setMiddleName(personUpdated.getMiddleName());
                    person.setSuffix(personUpdated.getSuffix());
                    person.setStreetNumber(personUpdated.getStreetNumber());
                    person.setBarangay(personUpdated.getBarangay());
                    person.setMunicipality(personUpdated.getMunicipality());
                    person.setZipcode(personUpdated.getZipcode());
                    person.setBirthdate(personUpdated.getBirthdate());
                    person.setFirstName(personUpdated.getFirstName());
                    person.setGradeWeightedAverage(personUpdated.getGradeWeightedAverage());
                    person.setDateHired(personUpdated.getDateHired());
                    person.setEmploymentStatus(personUpdated.getEmploymentStatus());
                    return personRepository.save(person);
                }).orElseThrow(() -> new NotFoundException("Person not found with id " + id));
        return	"Person Updated Successfully";
  	}

  	public String deletePerson(Long id) {

  		personRepository.findById(id)
                .map(person -> {
                    personRepository.delete(person);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new NotFoundException("Person not found with id " + id));
        return "Delete Successfully!";
  	}

  	public String addPersonRole(Long personId, Long roleId) {

		boolean existingRole = false;

		Optional<Role> roleOptional = roleRepository.findById(roleId);
		if(!roleOptional.isPresent()) {
		throw new IllegalStateException("Role id " + roleId + " does not exists");
		}
		Role personRole = roleOptional.get();
		Optional<Person> optPerson = personRepository.findById(personId);

		if(!optPerson.isPresent()) {
		throw new IllegalStateException("Person id " + personId + " does not exists");
		}

		Set<Role> roles = optPerson.get().getRole();
		for(Role role : roles) {
		existingRole = (role.getId() == personRole.getId() ? true : false);
		}
		if(existingRole) {
		throw new IllegalStateException("Person has existing roles!");
		}

		roles.add(personRole);
		Person persons = optPerson.get();
		persons.setRole(roles);
		personRepository.save(persons);

        return "Person Role Added Successfully!";

  	}

  	public String deletePersonRole(Long personId, Long roleId) {

	  	boolean existingRole = false;
	    Optional<Role> roleOptional = roleRepository.findById(roleId);
	    if(!roleOptional.isPresent()) {
	      throw new IllegalStateException("Role id " + roleId + " does not exists");
	    }
	    Role personRole = roleOptional.get();
	    Optional<Person> optPerson = personRepository.findById(personId);
	    if(!optPerson.isPresent()) {
	      throw new IllegalStateException("Person id " + personId + " does not exists");
	    }

	    Set<Role> roles = optPerson.get().getRole(); 
	    for(Role role : roles) {
	      existingRole = (role.getId() == personRole.getId() ? true : false);
	    }
	    if(!existingRole) {
	      throw new IllegalStateException("Person doesn't have roles with " + roleId + " id!");
	    }
	    Iterator<Role> itr = roles.iterator();
	    while (itr.hasNext()) { 
	      Role roleToBeDeleted = itr.next(); 
	      if (roleToBeDeleted.getId() == roleId) { 
	        itr.remove(); 
	      } 
	    }
	    
	    Person person = optPerson.get();
	    person.setRole(roles);
	    personRepository.save(person);

	    return "Person Role Deleted Successfully!";

  	}


}