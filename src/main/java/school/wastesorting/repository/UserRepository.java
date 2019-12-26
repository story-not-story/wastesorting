package school.wastesorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import school.wastesorting.domain.User;

public interface UserRepository  extends JpaRepository<User, Integer> {
    /**
     * 根据用户名查找用户
     * @param name
     * @return User
     */
    @Query(value = "from User where name = :name")
    User findByName(@Param(value = "name") String name);
}
