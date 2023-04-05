package com.example.javatrainee.user;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "users", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", length = 100)
    private String firstName;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Column(name = "lastname", unique = true, length = 100)
    private String lastName;

    @Column(name = "nickname", unique = true, length = 100)
    private String nickName;


}
