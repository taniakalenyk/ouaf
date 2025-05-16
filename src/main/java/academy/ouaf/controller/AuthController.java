package academy.ouaf.controller;

import com.tetiana.spring_2025.dao.UserDao;
import com.tetiana.spring_2025.model.User;
import com.tetiana.spring_2025.security.AppUserDetails;
import com.tetiana.spring_2025.security.ISecurityUtils;
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

@CrossOrigin
@RestController
public class AuthController {

    protected UserDao userDao;
    protected PasswordEncoder passwordEncoder;
    protected AuthenticationProvider authenticationProvider;
    protected ISecurityUtils jwtUtils;

    @Autowired
    public AuthController(PasswordEncoder passwordEncoder, UserDao userDao, AuthenticationProvider authenticationProvider, ISecurityUtils jwtUtils) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.authenticationProvider = authenticationProvider;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> inscription(@RequestBody @Validated(User.ValidInscription.class) User user) {
        try {
            // Check if user already exists
            if (userDao.findByEmail(user.getEmail()).isPresent()) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userDao.save(user);

            // we hide the password
            user.setPassword(null);

            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/connection")
    public ResponseEntity<String> login(@RequestBody @Valid User user) {
        try {
            AppUserDetails userDetails = (AppUserDetails) authenticationProvider.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    user.getEmail(),
                                    user.getPassword()))
                    .getPrincipal();

            String token = jwtUtils.generateToken(userDetails);
            return new ResponseEntity<>(token, HttpStatus.OK);

        } catch (AuthenticationException exception) {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //TODO
    @PostMapping("/validate-email")
    public ResponseEntity<User> validateEmail(@RequestBody ValidationEmailDto validationEmailDto) {

        Optional<User> user = userDao.findByEmail(validationEmailDto.getEmail());

        if (user.get().getJetonVerificationEmail().equals(validationEmailDto.getToken())) {
            user.get().setJetonVerificationEmail(null);
            userDao.save(user.get());
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
