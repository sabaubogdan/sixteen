package xyz.vegaone.sixteen.mapper;

import org.mapstruct.Mapper;
import xyz.vegaone.sixteen.domain.PostEntity;
import xyz.vegaone.sixteen.dto.Post;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface PostMapper {
    Post domainToDto(PostEntity postEntity);

    PostEntity dtoToDomain(Post post);

    List<Post> domainToDtoList(List<PostEntity> postEntityList);

    List<PostEntity> dtoToDomainList(List<Post> postList);
}
