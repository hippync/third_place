package com.thirdplace;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class App {
public static void main(String[] args) { SpringApplication.run(App.class, args); }


@RestController
static class Hello {
@GetMapping("/")
public String root() { return "Third Place API up"; }
}
}