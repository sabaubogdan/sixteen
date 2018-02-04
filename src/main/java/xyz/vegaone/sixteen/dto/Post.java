package xyz.vegaone.sixteen.dto;


import java.util.Date;

public class Post {

    private Long id;

    private Date creationDate;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
