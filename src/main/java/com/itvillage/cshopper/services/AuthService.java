package com.itvillage.cshopper.services;


import com.itvillage.cshopper.domain.Role;
import com.itvillage.cshopper.domain.RoleName;
import com.itvillage.cshopper.domain.SignUp;
import com.itvillage.cshopper.dto.request.LoginForm;
import com.itvillage.cshopper.dto.request.SignUpForm;
import com.itvillage.cshopper.dto.response.IdentityResponse;
import com.itvillage.cshopper.dto.response.JwtResponse;
import com.itvillage.cshopper.repository.RoleRepository;
import com.itvillage.cshopper.repository.SignUpRepository;
import com.itvillage.cshopper.security.jwt.JwtProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@Setter
@Getter
@AllArgsConstructor
public class AuthService {

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private SignUpRepository signUpRepository;
    @Autowired
    private RoleRepository roleRepository;

    public IdentityResponse signUp(SignUpForm signUpRequest) {


        Set<String> role = new HashSet<>();
        role.add("SUPER_ADMIN");


        if (signUpRepository.existsByUsername(signUpRequest.getUsername())) {
            //TODO
        }

        if (signUpRepository.existsByEmail(signUpRequest.getEmail())) {
            //TODO
        }

        SignUp user = new SignUp();
        UUID id = UUID.randomUUID();
        String uuid = id.toString();
        user.setId(uuid);
        user.setName(signUpRequest.getName());
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setRoles(getRolesOrThrow(role));
        signUpRepository.saveAndFlush(user);

        return new IdentityResponse(uuid);
    }


    public JwtResponse signIn(LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);



        String jwt = jwtProvider.generateJwtToken(authentication);
        return new JwtResponse(jwt,getLoggedAuthUser());
    }

    public String getLoggedAuthUser() {

        Object authUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<String> loggedInAuthUserId = null;

        if (authUser instanceof UserDetails) {

            String username = ((UserDetails) authUser).getUsername();
            loggedInAuthUserId = signUpRepository.findAuthUsersById(username);

        } else if (authUser instanceof UserDetails == false) {
            throw new RuntimeException("LoggedIn user does not  account.");

        } else {
            String username = authUser.toString();

            System.out.println(username);
        }
        return loggedInAuthUserId.get();

    }


    private Set<Role> getRolesOrThrow(Set<String> roles2) {
        Set<Role> roles = new HashSet<>();
        for (String role : roles2) {
            Optional<Role> roleOptional = roleRepository.findByName(RoleName.valueOf(role));
            System.out.println(roleOptional.get());
            if (!roleOptional.isPresent()) {
                throw new ValidationException("Role '" + role + "' does not exist.");
            }
            roles.add(roleOptional.get());
        }
        return roles;
    }
}
