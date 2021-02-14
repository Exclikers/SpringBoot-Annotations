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
 
import net.spring.boot.model.Role;
 
@RestController
@RequestMapping("/api")
public class RoleResource {

	@Autowired
	private RoleService roleService;

	//list role
    @GetMapping("/role")
    public List<Role> getAllRole() {
      return roleService.getAllRole();
    }

    //add role
    @PostMapping("/role")
    public Role createRole(@Valid @RequestBody Role role) {
        return roleService.createRole(role);
    }

    //update role
    @PutMapping("/role/{id}")
    public Role updateRole(@PathVariable Long id, @Valid @RequestBody Role roleUpdated) {
        return roleService.updateRole(id, roleUpdated);
    }

    //delete role
    @DeleteMapping("/role/{id}")
    public String deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }	
}