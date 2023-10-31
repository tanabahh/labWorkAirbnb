package itmo.airbnb.service;

import itmo.airbnb.domain.UserLoginData;
import itmo.airbnb.dto.request.UserLoginRequest;
import itmo.airbnb.repos.UserLoginDataRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserLoginDataRepository userRepository;

    public UserService(UserLoginDataRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserLoginData getUser(UserLoginRequest request) {
        UserLoginData user = userRepository.findByLoginName(request.getLogin());
        if (user == null) {
            throw new BadCredentialsException(
                    "Login information incorrect, please check login and password");
        }
        return user;
    }

    public void registerUser(UserLoginRequest request) {
        //TODO not save the same user name
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserLoginData userLoginData = new UserLoginData();
        userLoginData.setLoginName(request.getLogin());
        userLoginData.setPasswordSalt(request.getPassword()); //TODO do we need it?
        userLoginData.setPasswordHash(encoder.encode(request.getPassword()));

        userRepository.save(userLoginData);
    }
}
