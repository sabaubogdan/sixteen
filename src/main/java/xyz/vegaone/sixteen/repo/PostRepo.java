package xyz.vegaone.sixteen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.sixteen.domain.PostEntity;
import xyz.vegaone.sixteen.domain.UserEntity;

@Repository
public interface PostRepo extends JpaRepository<PostEntity, Long> {
    //TODO how to connect and find users
}
