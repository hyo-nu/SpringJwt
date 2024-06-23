package com.example.testjwt.controller;

import com.example.testjwt.dto.AdminDTO;
import com.example.testjwt.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/join")
    public String joinProcess(AdminDTO adminDTO) {
        adminService.joinProcess(adminDTO);
        return "ok";
    }
}


