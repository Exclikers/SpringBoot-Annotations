package net.spring.boot;

 
import org.springframework.data.jpa.repository.JpaRepository;
import net.spring.boot.model.Role;
 
public interface RoleRepository extends JpaRepository<Role, Long>{
}