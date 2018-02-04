package xyz.vegaone.sixteen.mapper;

import org.mapstruct.Mapper;
import xyz.vegaone.sixteen.domain.CommentEntity;
import xyz.vegaone.sixteen.dto.Comment;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface CommentMapper {

    Comment domainToDto(CommentEntity commentEntity);

    CommentEntity dtoToDomain(Comment comment);

    List<Comment> domaintToDtoList(List<CommentEntity> commentEntityList);

    List<CommentEntity> dtoToDomain(List<Comment> commentList);

}
