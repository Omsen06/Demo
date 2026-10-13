package com.example.demo.Loginpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class LoginController {
    @GetMapping("/signup")
    public String signupage(){
        return "signup";
    }
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    Login_Repository loginRepository;

    @PostMapping("/singupsucess")
    public String signupscusee(Model model, @RequestParam String name, @RequestParam String email, @RequestParam int age,@RequestParam String password)
    {
        Login_Entity loginEntity1=new Login_Entity();
        loginEntity1.setNamel(name);
        loginEntity1.setAge(age);
        loginEntity1.setEmail(email);
//        loginEntity1.setPassword(password);
        loginEntity1.setPassword(
                passwordEncoder.encode(password)
        );

        if (loginRepository.existsByEmail(email)) {
            model.addAttribute("error", "Email already registered!");
            return "signup";
        }

        loginRepository.save(loginEntity1);
        return "signupsucess";
    }
    @GetMapping("/signin")
    public String signnin(){
        return "signin";
    }
    @GetMapping("/home")
    public String homeapge()
    {
        return "home";
    }
}
