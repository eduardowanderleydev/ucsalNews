package br.ucsal.ucsalnews.repository;

import br.ucsal.ucsalnews.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
