package xyz.vegaone.sixteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.vegaone.sixteen.dto.Comment;
import xyz.vegaone.sixteen.service.CommentService;

@RestController
@RequestMapping(value = "/sixteen/comment")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Comment getComment(@PathVariable(value = "id") Long id) {
        Comment comment = commentService.getComment(id);

        return comment;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment comment) {
        Comment createComment = commentService.createComment(comment);

        return createComment;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable(value = "id") Long id) {
        commentService.deleteComment(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Comment updateComment(@RequestBody Comment comment) {
        Comment updateComment = commentService.updateComment(comment);

        return updateComment;
    }
}
