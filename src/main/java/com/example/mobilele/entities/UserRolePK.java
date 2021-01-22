package com.example.mobilele.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class UserRolePK implements Serializable {

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

    public UserRolePK() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
