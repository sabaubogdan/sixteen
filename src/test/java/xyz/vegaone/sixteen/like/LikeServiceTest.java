package xyz.vegaone.sixteen.like;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.sixteen.dto.Like;
import xyz.vegaone.sixteen.service.LikeService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LikeServiceTest {

    @Autowired
    private LikeService likeService;

    @Test
    public void createLikeTest() {
        //given
        Like like = new Like();

        //when
        Like savedLike = likeService.createLike(like);

        //then
        Assert.assertNotNull("There should have been one like saved in the database", savedLike);

    }

    @Test
    public void getLikeTest() {
        //given
        Like like = new Like();
        Like savedLike = likeService.createLike(like);

        //when
        Like foundLike = likeService.getLike(savedLike.getId());

        //then
        Assert.assertNotNull("There should have been one like saved in the database", foundLike);

    }

    @Test
    public void deleteLikeTest() {
        //given
        Like like = new Like();
        Like savedLike = likeService.createLike(like);

        //when
        likeService.deleteLike(savedLike.getId());

        //then
        Assert.assertNull("There should have been one like deleted from database", likeService.getLike(savedLike.getId()));

    }

}
