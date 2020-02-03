package guru.springframework.repositories;

import guru.springframework.domain.UnityOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnityOfMeasure, Long> {

    Optional<UnityOfMeasure> findByDescription(String description);

}
