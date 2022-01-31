package com.example.press_play_store_website.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String storeAddress;
    private String userRole;
    private Integer userEnabled;

    public UserEntity() {
    }

    public UserEntity(Integer userId, String firstName, String lastName, String email, String password, String storeAddress, String userRole, Integer userEnabled) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.storeAddress = storeAddress;
        this.userRole = userRole;
        this.userEnabled = userEnabled;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Integer getUserEnabled() {
        return userEnabled;
    }

    public void setUserEnabled(Integer userEnabled) {
        this.userEnabled = userEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(storeAddress, that.storeAddress) && Objects.equals(userRole, that.userRole) && Objects.equals(userEnabled, that.userEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, password, storeAddress, userRole, userEnabled);
    }
}