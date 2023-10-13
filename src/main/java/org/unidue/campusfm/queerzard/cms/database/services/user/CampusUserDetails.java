package org.unidue.campusfm.queerzard.cms.database.services.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CampusUserDetails implements UserDetails {

    @Getter private UserEntity userEntity;

    public CampusUserDetails(UserEntity userEntity){
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        this.userEntity.getPermissions().forEach(p -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(p);
            grantedAuthorities.add(grantedAuthority);
        });

        this.userEntity.getRoles().forEach(r -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + r);
            grantedAuthorities.add(grantedAuthority);
        });
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        System.out.println(userEntity.getPassword());
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return userEntity.isEnabled();
    }


    //No Password Expiration here
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userEntity.isEnabled();
    }
}
