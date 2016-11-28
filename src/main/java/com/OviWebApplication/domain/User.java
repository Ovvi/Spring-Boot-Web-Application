package com.OviWebApplication.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Created by Ovi on 11/20/2016.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;


    @Size(min=2, max=30, message = "Please insert a valid name")
    private String firstName;
    @NotNull
    @Size(min=2, max=30,message = "Please insert a valid name")
    private String lastName;
    @NotNull
    @Size(min=2, max=30,message = "Please insert a valid hobby")
    private String hobby;

    public User() {
    }

    public User(String firstName, String lastName, String hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobby = hobby;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
