package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ProfileController {
    @GetMapping("/user")
    public String userprofile(){
        return "user";
    }
    @Autowired
    UserRepo userRepo;
@PostMapping("/upload")
    public String uploadte(Model model,
                           @RequestParam("name") String name,
                           @RequestParam ("email")String email,
                           @RequestParam("image")MultipartFile image)throws IOException {
    String folder = "uploads/";

    File directory = new File(folder);
    if(image.isEmpty()){
        return "redirect/user";
    }

    if (!directory.exists()) {
        directory.mkdirs();
    }


    String fileName = image.getOriginalFilename();
    String  imagename = image.getOriginalFilename();
   String  imagepath = folder + imagename;
    image.transferTo(new File(imagepath));

    User_profile profile = new User_profile();

    profile.setName(name);
    profile.setEmail(email);
    profile.setImagepath(imagepath);
    profile.setImagename(imagename);


    userRepo.save(profile);

    return "saveuser";
}
@GetMapping("/profile/{id}")
    public String profilephoto(Model model, @PathVariable Long id ) {
    User_profile userProfile = userRepo.findById(id).orElseThrow(() -> new RuntimeException("profile not found "));
    model.addAttribute("profile", userprofile());
        return "redirect/profile";

        }
  }
