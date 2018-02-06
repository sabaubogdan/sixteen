package xyz.vegaone.sixteen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.vegaone.sixteen.dto.Like;
import xyz.vegaone.sixteen.service.LikeService;

@RestController
@RequestMapping(value = "/sixteen/like")
public class LikeController {

    private LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Like getLike(@PathVariable(value = "id") Long id) {
        Like like = likeService.getLike(id);

        return like;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Like createLike(@RequestBody Like like) {
        Like createLike = likeService.createLike(like);

        return createLike;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLike(@PathVariable(value = "id") Long id) {
        likeService.deleteLike(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Like updateLike(@RequestBody Like like) {
        Like updateLike = likeService.updateLike(like);

        return updateLike;
    }
}
