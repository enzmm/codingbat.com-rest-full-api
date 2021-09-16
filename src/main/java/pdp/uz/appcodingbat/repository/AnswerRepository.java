package pdp.uz.appcodingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appcodingbat.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
