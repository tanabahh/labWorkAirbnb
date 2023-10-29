package itmo.airbnb.security;

import itmo.airbnb.domain.UserLoginData;
import itmo.airbnb.repos.UserLoginDataRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserLoginDataRepository userRepository;

    public CustomUserDetailsService(UserLoginDataRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserLoginData user = userRepository.findByLoginName(login);
        //List<String> roles = new ArrayList<>();
        //roles.add("USER");
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getLoginName())
                        .password(user.getPasswordHash())
                        //.roles(roles.toArray(new String[0]))
                        .build();
        return userDetails;
    }
}
