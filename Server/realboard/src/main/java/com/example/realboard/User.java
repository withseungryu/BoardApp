package com.example.realboard;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of="idx")
@ToString
@Entity(name="user")
@Table
public class User implements Serializable {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private String password;

    @Column private String email;

//    @Column
//    private LocalDateTime createdDate;
//
//    @Column
//    private LocalDateTime supdatedDate;

    @Builder
    public User(String name, String password, String email){
        this.name =name;
        this.password = password;
        this.email = email;

    }


}
