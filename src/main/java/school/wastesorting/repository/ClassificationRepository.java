package school.wastesorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import school.wastesorting.domain.FirstClass;
import school.wastesorting.domain.SecondClass;
import school.wastesorting.domain.ThirdClass;

import java.util.List;

public interface ClassificationRepository extends JpaRepository<FirstClass, Integer> {
    /**
     * 根据一级类目id查找二级类目
     * @param id
     * @return List<SecondClass>
     */
    @Query(value = "select s from FirstClass f,SecondClass s where f.id = :id and f.id = s.parentId order by s.id")
    List<SecondClass> findSecondByFirst(@Param(value = "id") Integer id);
    /**
     * 根据二级类目id查找一级类目
     * @param id
     * @return FirstClass
     */
    @Query(value = "select f from FirstClass f,SecondClass s where s.id = :id and f.id = s.parentId")
    FirstClass findFirstBySecond(@Param(value = "id") Integer id);
    /**
     * 根据二级类目id查找三级类目
     * @param id
     * @return List<ThirdClass>
     */
    @Query(value = "select t from SecondClass s,ThirdClass t where s.id = :id and s.id = t.parentId order by t.id")
    List<ThirdClass> findThirdBySecond(@Param(value = "id") Integer id);
    /**
     * 根据三级类目id查找二级类目
     * @param id
     * @return SecondClass
     */
    @Query(value = "select s from SecondClass s,ThirdClass t where t.id = :id and s.id = t.parentId order by t.id")
    SecondClass findSecondByThird(@Param(value = "id") Integer id);

    /**
     * 根据三级类目name查找一级类目id
     * @param name
     * @return Integer
     */
    @Query(value = "select f.id from FirstClass f,SecondClass s,ThirdClass t where t.name = :name and f.id = s.parentId and s.id = t.parentId")
    Integer findFirstIdByThirdName(@Param(value = "name") String name);

}
