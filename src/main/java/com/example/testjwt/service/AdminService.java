package com.example.testjwt.service;

import com.example.testjwt.dto.AdminDTO;
import com.example.testjwt.entity.UserEntity;
import com.example.testjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(AdminDTO adminDTO){

        String username = adminDTO.getUsername();
        String password = adminDTO.getPassword();

        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity != null){return;}

//        Boolean isExist = userRepository.existsByUsername(username);
//        if (isExist) {
//            return;
//        }

        UserEntity data = new UserEntity();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}
