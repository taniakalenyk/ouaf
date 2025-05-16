package academy.ouaf.security;

import academy.ouaf.model.Admin;
import academy.ouaf.model.Coach;
import academy.ouaf.model.Owner;
import academy.ouaf.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class AppUserDetails implements UserDetails {
    protected User user;

    public AppUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (user instanceof Admin) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (user instanceof Owner) {
            return List.of(new SimpleGrantedAuthority("ROLE_OWNER"));
        } else if (user instanceof Coach) {
            return List.of(new SimpleGrantedAuthority("ROLE_COACH"));
        } else {
            return List.of();
        }
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public boolean isEnabled() {
        return user.getVerificationEmailToken() == null;
    }
}
