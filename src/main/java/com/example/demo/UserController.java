package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/profile")
public class UserController {
    private final UserRepo userRepo ;
    public UserController(UserRepo userRepo){
        this.userRepo=userRepo;
    }
    @PostMapping("/upload")
    public String uplaod(Model model, @RequestParam String name, @RequestParam String email,@RequestParam MultipartFile image , @RequestParam String imagename, @RequestParam String imagepath)throws IOException{
        String Folder="uploads/";
        File diractory=new File(Folder);
        if(!diractory.exists()){
            diractory.mkdir();
        }
        String fileName = image.getOriginalFilename();
        String filepath=Folder+fileName;
        image.transferTo(new File(filepath));
        User_profile userProfile=new User_profile();

        userProfile.setName(name);
        userProfile.setEmail(email);
        userProfile.setImagename(imagename);
        userProfile.setImagepath(imagepath);

        userRepo.save(userProfile);
        return "Profile uploaded successfully";
    }

}
