package com.example.blogv3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.blogv3.dto.JoinDTO;
import com.example.blogv3.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/join")
    public String join(JoinDTO joinDTO){
        if(joinDTO.getUsername() == null || joinDTO.getUsername().isEmpty()){
            return "redirect:/40x";
        }
        if(joinDTO.getPassword() == null || joinDTO.getPassword().isEmpty()){
            return "redirect:/40x";
        }
        if(joinDTO.getEmail() == null || joinDTO.getEmail().isEmpty()){
            return "redirect:/40x";
        }
        userRepository.save(joinDTO);
        return "redirect:/loginForm";
    }
    
    @GetMapping("/joinForm")
    public String joinForm(){
        // templates/ 가 기본이라서 user앞에 /를 붙이지 않는다
        return "user/joinForm"; // ViewResolver 는 templates 폴더를 찾아간다
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "user/loginForm";
    }

    @GetMapping("/updateForm")
    public String updateForm(){
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/";
    }
}
