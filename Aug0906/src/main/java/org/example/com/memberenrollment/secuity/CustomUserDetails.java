package org.example.com.memberenrollment.secuity;


import org.example.com.memberenrollment.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final Member user; // Replace 'User' with your actual user entity class

    public CustomUserDetails(Member user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the user's authorities/roles here. You can customize this based on your application's logic.
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        // Return the user's password from the Member entity
        return user.getPassword();
    }


    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Return true if the user's account is not expired.
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Return true if the user's account is not locked.
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Return true if the user's credentials (password) are not expired.
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Return true if the user's account is enabled.
        return user.isEnabled();
    }
}

