package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="authorities")
public class Authority {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name= "authority")
    private String authority;

    @OneToOne
    @JoinColumn(name = "username", updatable = false, insertable = false)
    User user;

    public Authority() {
    }

    public Authority(int id, String username, String authority, User user) {
        this.id = id;
        this.username = username;
        this.authority = authority;
        this.user = user;
    }

    public Authority(User user, String authority)
    {
        this.authority = authority;
        this.user = user;
        this.username = user.getUsername();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
