package br.ucsal.ucsalnews.repository;

import br.ucsal.ucsalnews.entity.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepository extends JpaRepository<New, Long> {
}
