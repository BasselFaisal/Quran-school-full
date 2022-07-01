package com.quranSchool.backcend.seed;

import com.quranSchool.backcend.Repository.RoleRepository;
import com.quranSchool.backcend.Repository.UserRepository;
import com.quranSchool.backcend.exception.ResourceNotFoundException;
import com.quranSchool.backcend.model.entity.Role;
import com.quranSchool.backcend.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataBaseSeeder {

    Logger logger = LoggerFactory.getLogger(DataBaseSeeder.class);

//    @Autowired
//    private SettingRepository settingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
//        seedSettingTable();
        seedRoleTable();
        seedUserTable();
    }

//    private void seedSettingTable() {
//        String[] names = {"pointsValue", "vat", "min_order_price", "am_time", "pm_time"};
//        String[] values = {"3", "10", "50", "9", "9"};
//
//        for (int i = 0; i < names.length; i++) {
//            String name = names[i];
//            String value = values[i];
//            Setting setting = new Setting(name, value);
//            if (!settingRepository.existsByName(name))
//                settingRepository.save(setting);
//        }
//    }

    private void seedRoleTable() {
        String[] names = {"ROLE_ADMIN", "ROLE_USER", "ROLE_WORKER", "ROLE_COMPANY"};

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            Role role = new Role();
            role.setName(name);
            if (!roleRepository.existsByName(name))
                roleRepository.save(role);
        }
    }

    private void seedUserTable() {
        String username = "admin";
        String password = "123456789";

        User user = new User(username, password, false, true, true, true, true);

        Role role = roleRepository.findByName("ROLE_ADMIN")
                .orElseThrow(() -> new ResourceNotFoundException("Role", "name", "admin."));
        user.setRoles(new ArrayList(){{add(role);}});

        if (!userRepository.existsByUsername(username)) {
            userRepository.save(user);
        }
    }

}
