package org.gr40in.secur.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.management.relation.RoleList;
import java.util.ArrayList;
import java.util.List;
@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    private String password;
    private String email;
    private boolean enabled;
//    @ElementCollection(targetClass = ArrayList.class)
    @Enumerated(EnumType.STRING)
    private Role role;
}
