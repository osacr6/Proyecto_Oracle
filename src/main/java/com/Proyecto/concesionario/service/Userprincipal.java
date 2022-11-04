package com.Proyecto.concesionario.service;

import com.Proyecto.concesionario.entity.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Userprincipal implements UserDetails {
    private Usuario usuario; 
    
    public Userprincipal (Usuario usuario){
        this.usuario = usuario;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<>();      //Guarda objetos de tipo granted authority: cuales son los roles o permisos que tiene un usuario
        
        //Extract list of permissions (name)
        this.usuario.getPermissionList().forEach (p -> {                         //p es cada elemento
        GrantedAuthority authority = new SimpleGrantedAuthority(p);             //Le pasamos "p" que es el permiso
        authorities.add(authority);
        });
    
        //Extract list of roles (ROLE name)
        this.usuario.getRoleList().forEach(r -> {
           GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);   //Spring security
           authorities.add(authority);
        });
        return authorities;            //Devuelve lista de todos los permisos
    }

    @Override
    public String getPassword() {
        return this.usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return this.usuario.getNombre();
    }
        
    public long getId() {
        return this.usuario.getId();
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
        return this.usuario.getActive() == 1;
    }
    
    public boolean hasRole(String rol){
        return usuario.hasRole(rol);
    }
}