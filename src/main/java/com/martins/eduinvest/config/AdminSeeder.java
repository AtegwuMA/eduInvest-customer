package com.martins.eduinvest.config;

import com.martins.eduinvest.enums.AdminRole;
import com.martins.eduinvest.enums.Gender;
import com.martins.eduinvest.model.Admin;
import com.martins.eduinvest.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class AdminSeeder implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AdminSeeder.class);

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.seed-admin.email:admin@eduinvest.local}")
    private String seedEmail;

    @Value("${app.seed-admin.password:ChangeMe123!}")
    private String seedPassword;

    @Override
    public void run(String... args) {
        if (adminRepository.existsByEmail(seedEmail)) {
            return;
        }

        Admin admin = new Admin();
        admin.setFirstName("Super");
        admin.setLastName("Admin");
        admin.setGender(Gender.MALE);
        admin.setDob(new Date(0));
        admin.setPhone("0000000000");
        admin.setEmail(seedEmail);
        admin.setPassword(passwordEncoder.encode(seedPassword));
        admin.setAdminRole(AdminRole.SUPER_ADMIN);
        adminRepository.save(admin);

        logger.info("Seeded default super admin account: {} (change the password after first login)", seedEmail);
    }
}
