package xyz.vegaone.sixteen.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userPost;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "commentLike")
    private List<LikeEntity> likeList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public UserEntity getUserPost() {
        return userPost;
    }

    public void setUserPost(UserEntity userPost) {
        this.userPost = userPost;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<LikeEntity> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<LikeEntity> likeList) {
        this.likeList = likeList;
    }
}
