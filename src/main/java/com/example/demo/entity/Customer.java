package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Getter @Setter
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @org.springframework.data.annotation.Id
    private Long id;

    private String firstName;

    private String lastName;

    private Date dob;

    private String email;

    private String password;

    private String userName;

}
