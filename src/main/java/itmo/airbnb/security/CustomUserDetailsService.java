package itmo.airbnb.security;

import itmo.airbnb.domain.UserLoginData;
import itmo.airbnb.dto.request.UserLoginRequest;
import itmo.airbnb.repos.UserLoginDataRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserLoginDataRepository userRepository;

    public CustomUserDetailsService(UserLoginDataRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        UserLoginData user =
                userRepository.findById(Long.parseLong(id)).orElseThrow(() -> new BadCredentialsException(
                        "Login information incorrect, please check login and password"));
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserId().toString())
                .password(user.getPasswordHash())
                .roles(user.getRole())
                .authorities(user.getRole())
                .build();
    }
}
