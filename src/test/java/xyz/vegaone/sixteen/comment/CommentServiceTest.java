package xyz.vegaone.sixteen.comment;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.sixteen.dto.Comment;
import xyz.vegaone.sixteen.service.CommentService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentServiceTest {

    private static final String COMMENT = "comment";
    private static final String NEW_COMMENT = "comment";
    @Autowired
    private CommentService commentService;

    @Test
    public void createCommentTest() {
        //given

        //when
        Comment savedComment = buildAndSaveComment();

        //then
        Assert.assertNotNull("There should have been one comment saved in the database", savedComment);
        Assert.assertEquals("The comment should have matched", COMMENT, savedComment.getContent());
    }

    @Test
    public void getComment() {
        //given
        Comment savedComment = buildAndSaveComment();

        //when
        Comment foundComment = commentService.getComment(savedComment.getId());

        //then
        Assert.assertNotNull("There should have been one comment saved in the database", foundComment);
        Assert.assertEquals("The comment should have matched", COMMENT, foundComment.getContent());

    }

    @Test
    public void deleteCommentTest() {
        //given
        Comment comment = buildAndSaveComment();

        //when
        commentService.deleteComment(comment.getId());

        //then
        Assert.assertNull("Comment should have been deleted from db", commentService.getComment(comment.getId()));

    }

    @Test
    public void updateCommentTest() {
        //given
        Comment comment = buildAndSaveComment();

        //when
        comment.setContent(NEW_COMMENT);
        Comment updateComment = commentService.updateComment(comment);

        //then
        //then
        Assert.assertNotNull("There should have been one comment saved in the database", comment);
        Assert.assertEquals("The comment should have matched", NEW_COMMENT, comment.getContent());
    }


    private Comment buildAndSaveComment() {
        Comment comment = new Comment();
        comment.setContent(COMMENT);

        return commentService.createComment(comment);
    }
}
