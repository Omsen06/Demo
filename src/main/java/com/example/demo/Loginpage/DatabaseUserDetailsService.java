package com.example.demo.Loginpage;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService  implements UserDetailsService {
    private final Login_Repository loginRepository;

    public DatabaseUserDetailsService (Login_Repository loginRepository){
        this.loginRepository=loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Login_Entity user=loginRepository.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException("Email not found")
        );
        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .roles("user")
                .build();
    }


}
