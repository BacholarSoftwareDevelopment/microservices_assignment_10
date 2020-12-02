package dk.si.task1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Long>
{
    // Here are additional customer defined search methods
    User findByFullname(String name);
}
