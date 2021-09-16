package pdp.uz.appcodingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appcodingbat.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
