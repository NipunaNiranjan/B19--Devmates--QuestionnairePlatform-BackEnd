package com.devmates.auth;

import com.devmates.auth.model.ERole;
import com.devmates.auth.model.Role;
import com.devmates.auth.model.User;
import com.devmates.auth.repository.RoleRepository;
import com.devmates.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Value("${sms-auth.app.admin-username}")
    private String adminUsername;
    @Value("${sms-auth.app.admin-password}")
    private String adminPassword;
    @Value("${sms-auth.app.admin-email}")
    private String adminEmail;

    public DataLoader(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {

        if(!roleRepository.existsByRole(ERole.ROLE_ADMIN)) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }

        if(!roleRepository.existsByRole(ERole.ROLE_STUDENT)) {
            roleRepository.save(new Role(ERole.ROLE_STUDENT));
        }

        if(!roleRepository.existsByRole(ERole.ROLE_TEACHER)) {
            roleRepository.save(new Role(ERole.ROLE_TEACHER));
        }


        if(!userRepository.existsByUsername(adminUsername)) {
            User user = new User(adminUsername, passwordEncoder.encode(adminPassword),adminEmail ,null);
            user.setId(100L);
            Role userRole = roleRepository.findByRole(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            user.setRole(userRole);
            userRepository.save(user);
        }
    }
}
