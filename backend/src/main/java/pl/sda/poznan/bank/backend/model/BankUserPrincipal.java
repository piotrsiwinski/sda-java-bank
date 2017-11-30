package pl.sda.poznan.bank.backend.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.sda.poznan.bank.backend.exception.EmailAlreadyRegisteredException;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class BankUserPrincipal implements UserDetails {
    private User user;

    public BankUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return Optional.of(user.getLogin()).orElseThrow(EmailAlreadyRegisteredException::new);
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
