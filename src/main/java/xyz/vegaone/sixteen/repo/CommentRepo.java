package xyz.vegaone.sixteen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.sixteen.domain.CommentEntity;

@Repository
public interface CommentRepo extends JpaRepository<CommentEntity, Long> {
}
