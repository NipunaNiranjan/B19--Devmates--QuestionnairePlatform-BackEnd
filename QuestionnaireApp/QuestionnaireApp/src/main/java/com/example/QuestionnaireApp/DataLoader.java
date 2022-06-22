package com.example.QuestionnaireApp;

import com.example.QuestionnaireApp.model.ERole;
import com.example.QuestionnaireApp.model.Role;
import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.repository.RoleRepository;
import com.example.QuestionnaireApp.repository.UserRepository;
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
    @Value("${sms-auth.app.admin-phone}")
    private String adminPhone;

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
            User user = new User(adminUsername, passwordEncoder.encode(adminPassword), adminEmail, adminPhone);
            user.setId(100L);
            Role userRole = roleRepository.findByRole(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            user.setRole(userRole);
            userRepository.save(user);
        }
    }
}
