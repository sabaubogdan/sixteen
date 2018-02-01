package xyz.vegaone.sixteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.sixteen.domain.UserEntity;
import xyz.vegaone.sixteen.dto.User;
import xyz.vegaone.sixteen.mapper.UserMapper;
import xyz.vegaone.sixteen.repo.UserRepo;

@Service
public class UserService {

    private UserMapper userMapper;

    private UserRepo userRepo;

    @Autowired
    public UserService(UserMapper userMapper, UserRepo userRepo) {
        this.userMapper = userMapper;
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        UserEntity userEntity = userMapper.dtoToDomain(user);
        UserEntity savedUserEntity = userRepo.save(userEntity);

        return userMapper.domainToDto(savedUserEntity);
    }

    public User getUser(Long id) {

        UserEntity foundUserEntity = userRepo.findOne(id);
        User user = userMapper.domainToDto(foundUserEntity);

        return user;

    }

    public void deleteUser(Long id) {
        userRepo.delete(id);

    }

    public User updateUser(User user) {
        UserEntity userEntity = userMapper.dtoToDomain(user);
        UserEntity savedUserEntity = userRepo.save(userEntity);

        User updatedUser = userMapper.domainToDto(savedUserEntity);

        return updatedUser;

    }
}
