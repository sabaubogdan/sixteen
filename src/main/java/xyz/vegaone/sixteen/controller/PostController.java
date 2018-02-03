package xyz.vegaone.sixteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.vegaone.sixteen.dto.Post;
import xyz.vegaone.sixteen.service.PostService;

@RestController
@RequestMapping(value = "/sixteen/post")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Post getPost(@PathVariable(value = "id") Long id) {
        Post post = postService.getPost(id);

        return post;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        Post createPost = postService.createPost(post);

        return createPost;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable(value = "id") Long id) {
        postService.deletePost(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Post updatePost(@RequestBody Post post) {
        Post updatedPost = postService.updatePost(post);

        return updatedPost;
    }

}
