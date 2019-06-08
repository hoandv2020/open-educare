package com.educare.open.model;

import javax.persistence.*;
import java.sql.Timestamp;

//@Entity
//@Table(name = "comment")
public class Comment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "content")
    private String content;

//    @Column(name = "create_at")
    private Timestamp createAt;

//    @Column(name = "update_at")
    private Timestamp updateAt;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "post_id")
    private Post post;

    public Comment() {
    }

    public Comment(User user, Post post, String content, Timestamp createAt, Timestamp updateAt) {
        this.user = user;
        this.post = post;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }
}
