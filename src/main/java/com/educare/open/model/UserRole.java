package com.educare.open.model;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "user_role")
public class UserRole implements Serializable {
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "user_id")
    private User user;

//    @Id
//    @ManyToOne
//    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole() {
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
