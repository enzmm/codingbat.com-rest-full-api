package pdp.uz.appcodingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appcodingbat.entity.Example;

public interface ExampleRepository extends JpaRepository<Example, Integer> {
}
