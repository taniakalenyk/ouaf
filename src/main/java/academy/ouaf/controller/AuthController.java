package academy.ouaf.controller;

import academy.ouaf.dao.UserDao;
//import academy.ouaf.dto.EmailValidationDto;
import academy.ouaf.model.Owner;
import academy.ouaf.model.User;
import academy.ouaf.security.AppUserDetails;
import academy.ouaf.security.ISecurityUtils;
import academy.ouaf.views.LoginView;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;


@CrossOrigin
@RestController
public class AuthController {

    protected UserDao userDao;
    protected PasswordEncoder passwordEncoder;
    protected AuthenticationProvider authenticationProvider;
    protected ISecurityUtils securityUtils;
//    protected EmailService emailService;

    @Autowired
    public AuthController(UserDao userDao, PasswordEncoder passwordEncoder,
                          AuthenticationProvider authenticationProvider, ISecurityUtils securityUtils) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.authenticationProvider = authenticationProvider;
        this.securityUtils = securityUtils;
//        this.emailService = emailService;
    }

    @PostMapping("/signup-owner")
    public ResponseEntity<Owner> inscription(@RequestBody @Valid Owner owner) throws IOException {

        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        owner.setRegistrationDate(LocalDateTime.now());

//        String tokenValidationEmail = UUID.randomUUID().toString();
//        user.setVerificationEmailToken(tokenValidationEmail);

        userDao.save(owner);
//        emailService.sendEmailValidationToken(user.getEmail(), tokenValidationEmail);

        // Hide sensitive information
        owner.setPassword(null);
        owner.setVerificationEmailToken(null);
        return new ResponseEntity<>(owner, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> connexion(@RequestBody @Validated(LoginView.class) @JsonView(LoginView.class) User user) {
        try {
            AppUserDetails userDetails = (AppUserDetails) authenticationProvider
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    user.getEmail(),
                                    user.getPassword()))
                    .getPrincipal();

            return new ResponseEntity<>(securityUtils.generateToken(userDetails), HttpStatus.OK);

        } catch (AuthenticationException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

//    @PostMapping("/validate-email")
//    public ResponseEntity<User> validateEmail(@RequestBody EmailValidationDto emailValidationDto) {
//        Optional<User> user = userDao.findByVerificationEmailToken(emailValidationDto.getToken());
//
//        if (user.isPresent()) {
//            user.get().setVerificationEmailToken(null);
//            userDao.save(user.get());
//            return new ResponseEntity<>(user.get(), HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//    }
}
