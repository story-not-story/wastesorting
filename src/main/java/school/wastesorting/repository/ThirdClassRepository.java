package school.wastesorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.wastesorting.domain.ThirdClass;

public interface ThirdClassRepository extends JpaRepository<ThirdClass, Integer> {
}
