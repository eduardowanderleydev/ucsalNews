package br.ucsal.ucsalnews.repository;

import br.ucsal.ucsalnews.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
