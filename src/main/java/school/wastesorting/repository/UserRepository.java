package school.wastesorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.wastesorting.domain.User;

public interface UserRepository  extends JpaRepository<User, Integer> {
}
