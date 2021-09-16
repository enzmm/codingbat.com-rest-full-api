package pdp.uz.appcodingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appcodingbat.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
