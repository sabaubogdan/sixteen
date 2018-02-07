package xyz.vegaone.sixteen.mapper;

import org.mapstruct.Mapper;
import xyz.vegaone.sixteen.domain.LikeEntity;
import xyz.vegaone.sixteen.dto.Like;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface LikeMapper {

    Like domainToDto(LikeEntity likeEntity);

    LikeEntity dtoToDomain(Like like);

    List<Like> domainToDtoLike(List<LikeEntity> likeEntityList);

    List<LikeEntity> dtoToDomain(List<Like> likeList);

}
