package cinema.dao;

import cinema.model.Role;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {
    Role add(Role role);

    Optional<Role> getByName(String roleName);
}
