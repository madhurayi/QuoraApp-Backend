package com.example.quroapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User extends BaseModel{


    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String bio;

    @OneToMany
    private List<Question> questions=new ArrayList<>();

}
