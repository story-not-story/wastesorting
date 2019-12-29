package school.wastesorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import school.wastesorting.domain.ThirdClass;

public interface ThirdClassRepository extends JpaRepository<ThirdClass, Integer> {
    /**
     * 根据物品名查找物品
     * @param name
     * @return User
     */
    @Query(value = "from ThirdClass where name = :name and parentId = :parentId")
    ThirdClass findByNameParentId(@Param(value = "name") String name, @Param(value = "parentId") Integer parentId);
}
