package xyz.vegaone.sixteen.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "like_table")
public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "creation_date")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userLike;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity postLike;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private CommentEntity commentLike;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserEntity getUserLike() {
        return userLike;
    }

    public void setUserLike(UserEntity userLike) {
        this.userLike = userLike;
    }

    public PostEntity getPostLike() {
        return postLike;
    }

    public void setPostLike(PostEntity postLike) {
        this.postLike = postLike;
    }

    public CommentEntity getCommentLike() {
        return commentLike;
    }

    public void setCommentLike(CommentEntity commentLike) {
        this.commentLike = commentLike;
    }
}
