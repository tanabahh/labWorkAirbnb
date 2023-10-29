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
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserLoginData user = userRepository.findByLoginName(login);
        if (user == null) {
            throw new BadCredentialsException("Login information incorrect, please check login and password");
        }
        return org.springframework.security.core.userdetails.User.builder()
                        .username(user.getLoginName())
                        .password(user.getPasswordHash()) //TODO use here
                        .build();
    }

    public void registerUser(UserLoginRequest request) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserLoginData userLoginData = new UserLoginData();
        userLoginData.setLoginName(request.getLogin());
        userLoginData.setPasswordSalt(request.getPassword()); //TODO do we need it?
        userLoginData.setPasswordHash(encoder.encode(request.getPassword()));

        userRepository.save(userLoginData);
    }
}
