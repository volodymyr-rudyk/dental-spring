package com.dental.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by light on 5/9/2015.
 */

@Entity
@Table(name = "profile")
public class Profile implements Serializable{

    @Id
    @Column(name="id")
    @GeneratedValue
//    @GenericGenerator(name="gen", strategy="foreign",
//            parameters=@Parameter(name="property", value="user"))
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "phone")
    private String phone;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "profile")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
