package com.celfocus.training;

import java.util.Date;

public class User {

    public String name;

    public Date birthDate;

    public boolean userIsOver18;

    public User(String name, Date birthDate, boolean userIsOver18) {
        this.name = name;
        this.birthDate = birthDate;
        this.userIsOver18 = userIsOver18;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean isUserIsOver18() {
        return userIsOver18;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setUserIsOver18(boolean userIsOver18) {
        this.userIsOver18 = userIsOver18;
    }

    public void updateUser(String name, Date birthDate, boolean userIsOver18) {
        this.name = name;
        this.birthDate = birthDate;
        this.userIsOver18 = userIsOver18;
    }
}
