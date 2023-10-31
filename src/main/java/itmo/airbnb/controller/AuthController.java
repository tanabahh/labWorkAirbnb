package itmo.airbnb.controller;

import itmo.airbnb.camunda.StarterService;
import itmo.airbnb.domain.UserLoginData;
import itmo.airbnb.dto.request.UserLoginRequest;
import itmo.airbnb.dto.response.UserLoginResponse;
import itmo.airbnb.security.CustomUserDetailsService;
import itmo.airbnb.security.JwtUtil;
import itmo.airbnb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService service;
    private final StarterService starterService;

    private JwtUtil jwtUtil;
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                          UserService service,
                          StarterService starterService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.service = service;
        this.starterService = starterService;
    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        UserLoginData user = service.getUser(request);
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserId(),
                            request.getPassword()));
            String id = authentication.getName();
            String token = jwtUtil.createToken(authentication);
            UserLoginResponse userLoginResponse = new UserLoginResponse();
            userLoginResponse.setToken(token);
            userLoginResponse.setId(id);

            return ResponseEntity.ok().body(userLoginResponse);

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(@RequestBody UserLoginRequest request) {
        service.registerUser(request);
    }

    @ResponseBody
    @RequestMapping(value = "/host-register",method = RequestMethod.POST)
    public void hostRegister(@RequestBody UserLoginRequest request) {
        starterService.startHostCreationProcess(request);
    }
}