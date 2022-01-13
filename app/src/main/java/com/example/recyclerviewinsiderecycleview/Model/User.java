package com.example.recyclerviewinsiderecycleview.Model;

import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private List<UserSub> userSubs;

    public User(String firstName, String lastName, List<UserSub> userSubs) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.userSubs =userSubs;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<UserSub> getUserSubs() {
        return userSubs;
    }

    public void setUserSubs(List<UserSub> userSubs) {
        this.userSubs = userSubs;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
