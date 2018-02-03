package xyz.vegaone.sixteen.dto;


import xyz.vegaone.sixteen.domain.UserEntity;

import java.util.Date;
import java.util.List;

public class Post {

    private Long id;

    private Date creation_Date;

    private String content;

    private User user;

//    private List<Like> likes; to be added after the classes are created

//    private List<Comment> comments; to be added after the classes are created


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreation_Date() {
        return creation_Date;
    }

    public void setCreation_Date(Date creation_Date) {
        this.creation_Date = creation_Date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
