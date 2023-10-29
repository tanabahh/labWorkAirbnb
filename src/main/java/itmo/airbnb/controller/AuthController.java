package itmo.airbnb.controller;

import itmo.airbnb.domain.UserLoginData;
import itmo.airbnb.dto.request.UserLoginRequest;
import itmo.airbnb.dto.response.UserLoginResponse;
import itmo.airbnb.security.CustomUserDetailsService;
import itmo.airbnb.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService service;

    private JwtUtil jwtUtil;
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomUserDetailsService service) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.service = service;

    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(),
                            request.getPassword()));
            String name = authentication.getName();
            UserLoginData user = new UserLoginData();
            user.setLoginName(name);
            user.setPasswordHash(request.getPassword());
            String token = jwtUtil.createToken(user);
            System.out.println(token);
            UserLoginResponse userLoginResponse = new UserLoginResponse();
            userLoginResponse.setToken(token);
            userLoginResponse.setLogin(name);

            return ResponseEntity.ok().body(userLoginResponse);

        } catch (BadCredentialsException e) {
            //ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            //ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(@RequestBody UserLoginRequest request) {
        service.registerUser(request);
    }
}