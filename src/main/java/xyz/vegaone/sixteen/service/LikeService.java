package xyz.vegaone.sixteen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.sixteen.domain.LikeEntity;
import xyz.vegaone.sixteen.dto.Like;
import xyz.vegaone.sixteen.mapper.LikeMapper;
import xyz.vegaone.sixteen.repo.LikeRepo;

import java.util.Date;

@Service
public class LikeService {

    private LikeMapper likeMapper;

    private LikeRepo likeRepo;

    @Autowired
    public LikeService(LikeMapper likeMapper, LikeRepo likeRepo) {
        this.likeMapper = likeMapper;
        this.likeRepo = likeRepo;
    }

    public Like createLike(Like like) {
        LikeEntity likeEntity = likeMapper.dtoToDomain(like);
        likeEntity.setCreationDate(new Date());
        LikeEntity savedLike = likeRepo.save(likeEntity);

        return likeMapper.domainToDto(savedLike);
    }

    public Like getLike(Long id) {
        LikeEntity foundLikeEntity = likeRepo.findOne(id);
        Like like = likeMapper.domainToDto(foundLikeEntity);

        return like;
    }

    public void deleteLike(Long id) {
        likeRepo.delete(id);
    }

    public Like updateLike(Like like) {
        LikeEntity likeEntity = likeMapper.dtoToDomain(like);
        LikeEntity savedLikeEntity = likeRepo.save(likeEntity);

        Like updateLike = likeMapper.domainToDto(savedLikeEntity);

        return updateLike;
    }
}
