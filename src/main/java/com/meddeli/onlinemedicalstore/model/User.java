package com.meddeli.onlinemedicalstore.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="tbl_user")
@Setter
@Getter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(name="user_name")
    private String username;

    private String password;

    private String address;

}
