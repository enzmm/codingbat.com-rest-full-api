package pdp.uz.appcodingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appcodingbat.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
