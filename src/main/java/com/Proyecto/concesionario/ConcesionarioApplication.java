package com.Proyecto.concesionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;

@SpringBootApplication
//@Component
public class ConcesionarioApplication {

	public static void main(String[] args) {
            
            String password = "123456";
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);
            System.out.println("password --> "+ password);
            System.out.println(encodedPassword);
                
            SpringApplication.run(ConcesionarioApplication.class, args);
	}

}
