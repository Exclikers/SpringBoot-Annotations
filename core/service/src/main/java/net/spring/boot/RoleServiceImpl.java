package net.spring.boot;

import java.util.List;

import net.spring.boot.exception.NotFoundException;
import net.spring.boot.RoleRepository;
import net.spring.boot.model.Role;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

	public Role updateRole(Long id, Role roleUpdated) {
        return roleRepository.findById(id)
        .map(role -> {
            role.setRole(roleUpdated.getRole());
            return roleRepository.save(role);
        }).orElseThrow(() -> new NotFoundException("Person not found with id " + id));
	}

	public String deleteRole (Long id) {
	    return roleRepository.findById(id)
            .map(role -> {
                roleRepository.delete(role);
                return "Delete Successfully!";
            }).orElseThrow(() -> new NotFoundException("Person not found with id " + id));
	}


}