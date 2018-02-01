package xyz.vegaone.sixteen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.sixteen.domain.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
//    List<UserEntity> findAllById();
    //TODO how to connect and find users
}
