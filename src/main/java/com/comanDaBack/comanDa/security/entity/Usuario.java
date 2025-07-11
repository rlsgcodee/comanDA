package com.comanDaBack.comanDa.security.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_entity")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String password;
    @Column(name = "is_enabled")
    private Boolean isEnabled;
    @Column(name = "is_account_non_expired")
    private Boolean isAccountNonExpired;
    @Column(name = "is_credentials_non_expired")
    private Boolean isCredentialNonExpired;
    @Column(name = "is_account_non_locked")
    private Boolean isAccountNonLocked;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
