package net.spring.boot;

import java.util.List;
import net.spring.boot.model.Role;

public interface RoleService {

	List<Role> getAllRole();
	Role createRole(Role role);
	Role updateRole(Long id, Role roleUpdated);
	String deleteRole (Long id);

}