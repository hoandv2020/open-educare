package com.educare.open.model;

import com.educare.open.utils.Rate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "post_rate")
public class PostRate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rate")
    private Integer rate;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "rated_by")
    private User user;

    public PostRate(Rate rate, Post post, User user) {
        this.rate = rate.getValue();
        this.post = post;
        this.user = user;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate.getValue();
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
