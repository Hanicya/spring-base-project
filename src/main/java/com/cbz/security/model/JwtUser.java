package com.cbz.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author HuangYiCheng
 * @since 2024/8/8
 * jwt标准安全用户
 */
@Getter
@AllArgsConstructor
public class JwtUser implements UserDetails {

    private final Long id;

    private final String username;

    private final String nickName;
    @JsonIgnore
    private final String password;

    private final String avatar;

    private final String email;

    private final String phone;

    private final String dept;

    private final String role;
    private final boolean enabled;


    @JsonIgnore
    private final Collection<SimpleGrantedAuthority> authorities;



    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Collection<String> getRoles() {
        return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    }
}
