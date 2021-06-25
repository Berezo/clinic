package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="username")
    private String username;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="enabled", nullable = false)
    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="username")
    private List<Authority> authorities;

    public User() {
        enabled = true;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        enabled = true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public void addAuthority(Authority authority){
        if(this.authorities == null){
            this.authorities = new ArrayList<>();
        }
        this.authorities.add(authority);
    }
}
