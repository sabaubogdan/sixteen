package xyz.vegaone.sixteen.post;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.sixteen.dto.Post;
import xyz.vegaone.sixteen.dto.User;
import xyz.vegaone.sixteen.service.PostService;
import xyz.vegaone.sixteen.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostServiceTest {

    private static final String POST_CONTENT = "test content";
    private static final String NEW_POST_CONTENT = "test content";

    private static final String USER_FIRST_NAME = "John";
    private static final String USER_SECOND_NAME = "Smith";
    private static final String USER_EMAIL = "j.smith@vegaone.xyz";
    private static final String USER_PASSWORD = "password";

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @Test
    public void createPostTest() {
        //given
        User savedUser = buildAndSaveUser();

        //when
        Post savedPost = buildAndSavePost();

        //then
        Assert.assertNotNull("There should have been one post saved in the database", savedPost);
        Assert.assertEquals("The post date should have matched", POST_CONTENT, savedPost.getContent());

    }

    @Test
    public void getPostTest() {
        //given
        Post savedPost = buildAndSavePost();

        //when
        Post findPost = postService.getPost(savedPost.getId());

        //then
        Assert.assertNotNull("There should have been one post saved in the database", findPost);
        Assert.assertEquals("The post date should have matched", POST_CONTENT, findPost.getContent());

    }

    @Test
    public void deletePost() {
        //given
        Post savedPost = buildAndSavePost();

        //when
        postService.deletePost(savedPost.getId());

        //then
        Assert.assertNull("Task should have been deleted from db", postService.getPost(savedPost.getId()));


    }

    @Test
    public void updatePostTest() {
        //given
        Post savedPost = buildAndSavePost();

        //when
        savedPost.setContent(NEW_POST_CONTENT);
        Post updatedPost = postService.updatePost(savedPost);

        //then
        Assert.assertNotNull("There should have been one post saved in the database", updatedPost);
        Assert.assertEquals("The task title should have matched", NEW_POST_CONTENT, updatedPost.getContent());
    }


    private User buildAndSaveUser() {
        User user = new User();
        user.setFirstName(USER_FIRST_NAME);
        user.setSecondName(USER_SECOND_NAME);
        user.setEmail(USER_EMAIL);
        user.setPassword(USER_PASSWORD);

        return userService.createUser(user);
    }

    private Post buildAndSavePost() {
        Post post = new Post();
        post.setContent(POST_CONTENT);

        return postService.createPost(post);
    }

}
