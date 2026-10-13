package com.example.demo.Loginpage;

import jakarta.persistence.*;

@Entity(name = "login_en")
public class Login_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namel;
     @Column(nullable = false)
    private String email;
    private int age;
    private String state;
    @Column(nullable = false)
    private String password;

    public Login_Entity() {
    }

    public Login_Entity(Long id, String namel, String email, int age, String state, String password) {
        this.id = id;
        this.namel = namel;
        this.email = email;
        this.age = age;
        this.state = state;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamel() {
        return namel;
    }

    public void setNamel(String namel) {
        this.namel = namel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
