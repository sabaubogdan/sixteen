package xyz.vegaone.sixteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.sixteen.domain.PostEntity;
import xyz.vegaone.sixteen.dto.Post;
import xyz.vegaone.sixteen.mapper.PostMapper;
import xyz.vegaone.sixteen.repo.PostRepo;

import java.util.Date;

@Service
public class PostService {

    private PostMapper postMapper;

    private PostRepo postRepo;

    @Autowired
    public PostService(PostMapper postMapper, PostRepo postRepo) {
        this.postMapper = postMapper;
        this.postRepo = postRepo;
    }

    public Post createPost(Post post) {
        PostEntity postEntity = postMapper.dtoToDomain(post);
        postEntity.setCreationDate(new Date());
        PostEntity savedPostEntity = postRepo.save(postEntity);

        return postMapper.domainToDto(savedPostEntity);
    }

    public Post getPost(Long id) {
        PostEntity foundPostEntity = postRepo.findOne(id);
        Post post = postMapper.domainToDto(foundPostEntity);

        return post;
    }

    public void deletePost(Long id) {
        postRepo.delete(id);
    }

    public Post updatePost(Post post) {
        PostEntity postEntity = postMapper.dtoToDomain(post);
        PostEntity savedPostEntity = postRepo.save(postEntity);

        Post updatedPost = postMapper.domainToDto(savedPostEntity);

        return updatedPost;
    }
}
