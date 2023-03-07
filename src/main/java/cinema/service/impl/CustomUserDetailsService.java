package cinema.service.impl;

import static org.springframework.security.core.userdetails.User.UserBuilder;
import static org.springframework.security.core.userdetails.User.withUsername;

import cinema.model.User;
import cinema.service.UserService;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Can't find user " + email);
        }
        User user = userOptional.get();
        UserBuilder builder = withUsername(email);
        builder.password(user.getPassword());
        builder.roles(user.getRoles().stream()
                .map(r -> r.getRoleName().name())
                .toArray(String[]::new));
        return builder.build();
    }
}
