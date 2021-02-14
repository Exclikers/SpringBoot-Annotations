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

import net.spring.boot.model.Person;
import net.spring.boot.model.Role;
import net.spring.boot.PersonService;
 
 
@RestController
@RequestMapping("/api")
public class PersonResource {
  
    @Autowired
    private PersonService personService;  

    //List All Person
    @GetMapping("/person")
    public List<Person> getAllPerson() {
      return personService.getPerson();
    }
    
    //List Person by ID
    @GetMapping("/person/{id}")
    public Person getPersonByID(@PathVariable Long id) {
      return personService.getPersonById(id);
    }
    
    //Create Person
    @PostMapping("/person")
    public String createPerson(@Valid @RequestBody Person person) {
        return personService.createPerson(person);
    }
    
    //Update Person
    @PutMapping("/person/{id}")
    public String updatePerson(@PathVariable Long id, @Valid @RequestBody Person personUpdated) {
        return personService.updatePerson(id, personUpdated);
    }
    
    //Delete Person
    @DeleteMapping("/person/{id}")
    public String deletePerson(@PathVariable Long id) {
        return personService.deletePerson(id);
    }

    //Add Person Role
    @PutMapping("/person/{personId}/role/{roleId}")
    public String addPersonRole(@PathVariable Long personId, @PathVariable Long roleId) {
         return personService.addPersonRole(personId, roleId);
    }

    //Delete Person Role
    @DeleteMapping("/person/{personId}/role/{roleId}")
    public String deletePersonRole(@PathVariable Long personId, @PathVariable Long roleId) {
      return personService.deletePersonRole(personId, roleId);
    }

}