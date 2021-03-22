package com.example.myshop.service;


import com.example.myshop.domain.Role;
import com.example.myshop.domain.User;
import com.example.myshop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private  UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Ошибка ввода данных!");

        }
        return user;

    }

    public boolean addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }
        user.setActive(true);

        userRepo.save(user);


        return true;
    }


    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void saveUser(User user, String username, String email, String phone, Map<String, String> form) {
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
     //   user.setPassword(passwordEncoder.encode(user.getUsername()));

        userRepo.save(user);
    }

    public void updateProfile(User user, String password, String phone, String email) {
        String userEmail = user.getEmail();
        String userPhone = user.getPhone();

        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                (userEmail != null && !userEmail.equals(email));

        if (isEmailChanged) {
            user.setEmail(email);
        }

        boolean isPhoneChanged = (phone != null && !phone.equals(userPhone)) ||
                (userPhone != null && !userPhone.equals(phone));

        if (isPhoneChanged) {
            user.setPhone(phone);
        }

        if (!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }

        userRepo.save(user);

    }

}
