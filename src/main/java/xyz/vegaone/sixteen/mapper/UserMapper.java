package xyz.vegaone.sixteen.mapper;

import org.mapstruct.Mapper;
import xyz.vegaone.sixteen.domain.UserEntity;
import xyz.vegaone.sixteen.dto.User;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    User domainToDto(UserEntity userEntity);

    UserEntity dtoToDomain(User user);

    List<User> domainToDtoList(List<UserEntity> userEntityList);

    List<UserEntity> dtoToDomain(List<User> userList);

}
