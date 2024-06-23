package com.example.testjwt.service;

import com.example.testjwt.dto.CustomUserDetails;
import com.example.testjwt.entity.UserEntity;
import com.example.testjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // DB에서 조회
        UserEntity userData = userRepository.findByUsername(username);
        if(userData != null) {
            // UserDetails에 담아서 return하면 AuthenticationMAnager가 검증 함
            return new CustomUserDetails(userData);
        }
        return null;
    }
}
