package com.richard.springbootquerydsl.model;


import com.querydsl.core.annotations.QueryExclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@ToString
@NoArgsConstructor
@Data

// This will exclude the querydsl from scanning the JPA entity
@QueryExclude

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

}
