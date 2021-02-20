package com.itvillage.cshopper.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DB_SIGN_UP")
public class SignUp {

    @Id
    private String id;

    @NotNull
    @Size(min=3, max = 50)
    private String name;

    @NotNull
    @Size(min=3, max = 50)
    private String username;

    @NaturalId
    @NotNull
    @Size(max = 50)
    @Email
    private String email;

    @NotNull
    @Size(min=6, max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
    	joinColumns = @JoinColumn(name = "user_id"),
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    
}
