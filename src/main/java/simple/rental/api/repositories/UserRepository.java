package simple.rental.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import simple.rental.api.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM user u WHERE u.user_name = ?1 and password = ?2", nativeQuery = true )
    User findByUserNameAndPassword(String userName, String password);

    Optional<User> findByEmail(String email);
}
