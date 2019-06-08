package com.educare.open.model;

import com.educare.open.utils.Rate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_rate")
public class UserRate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rate")
    private Integer rate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "rated_by")
    private User userRated;

    public UserRate(Rate rate, User user, User userRated) {
        this.rate = rate.getValue();
        this.user = user;
        this.userRated = userRated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate.getValue();
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUserRated() {
        return userRated;
    }

    public void setUserRated(User userRated) {
        this.userRated = userRated;
    }
}
