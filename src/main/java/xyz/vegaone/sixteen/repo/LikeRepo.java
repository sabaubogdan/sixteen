package xyz.vegaone.sixteen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.vegaone.sixteen.domain.LikeEntity;

public interface LikeRepo extends JpaRepository<LikeEntity, Long> {
}
