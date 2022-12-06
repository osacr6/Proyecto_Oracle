package com.Proyecto.concesionario.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// https://github.com/vijaysrj/spring-boot-postgresql-dbauthentication/tree/master/src/main/java/com/springboot/dbauthentication

@Entity
@Table(name = "T_USUARIO")
public class Usuario implements UserDetails {
    @Id
    @Column(name = "usuario_id")
    private long usuarioId;
    private String username;
    private String password;
    @Column(name = "rol_id")
    private String rolId;
    private int active;

    public Usuario() {
    }

    public Usuario(long usuario_id, String username, String password, String rol_id, int active) {
        this.usuarioId = usuario_id;
        this.username = username;
        this.password = password;
        this.rolId = rolId;
        this.active = active;
    }

    public long getUsuario_id() {
        return usuarioId;
    }

    public void setUsuario_id(long usuario_id) {
        this.usuarioId = usuario_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRol() {
        return rolId;
    }

    public void setRol(String rol) {
        this.rolId = rol;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }
    
    

    public boolean getActive() {
        return active == 1;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<String> getRoleList() {
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        return new ArrayList<>();
    }

    public boolean hasRole(String rol) {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
