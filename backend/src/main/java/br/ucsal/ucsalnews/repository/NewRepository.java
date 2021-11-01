package br.ucsal.ucsalnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.ucsalnews.entity.New;

@Repository
public interface NewRepository extends JpaRepository<New, Long> {
}
