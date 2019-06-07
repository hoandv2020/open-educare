package com.educare.open.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_post")
public class UserPost implements Serializable {
    @Column(name = "isRead")
    private Boolean isRead;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public UserPost() {
    }

    public UserPost(Boolean isRead, User user, Post post) {
        this.isRead = isRead;
        this.user = user;
        this.post = post;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
