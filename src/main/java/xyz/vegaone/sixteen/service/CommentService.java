package xyz.vegaone.sixteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.sixteen.domain.CommentEntity;
import xyz.vegaone.sixteen.dto.Comment;
import xyz.vegaone.sixteen.mapper.CommentMapper;
import xyz.vegaone.sixteen.repo.CommentRepo;

import java.util.Date;

@Service
public class CommentService {

    private CommentMapper commentMapper;

    private CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentMapper commentMapper, CommentRepo commentRepo) {
        this.commentMapper = commentMapper;
        this.commentRepo = commentRepo;
    }

    public Comment createComment(Comment comment) {

        CommentEntity commentEntity = commentMapper.dtoToDomain(comment);
        commentEntity.setCreationDate(new Date());
        CommentEntity savedComment = commentRepo.save(commentEntity);

        return commentMapper.domainToDto(savedComment);

    }

    public Comment getComment(Long id) {
        CommentEntity foundCommentEntity = commentRepo.findOne(id);
        Comment comment = commentMapper.domainToDto(foundCommentEntity);

        return comment;
    }

    public void deleteComment(Long id) {
        commentRepo.delete(id);

    }

    public Comment updateComment(Comment comment) {
        CommentEntity commentEntity = commentMapper.dtoToDomain(comment);
        CommentEntity savedCommentEntity = commentRepo.save(commentEntity);

        Comment updatedComment = commentMapper.domainToDto(savedCommentEntity);

        return updatedComment;

    }
}
