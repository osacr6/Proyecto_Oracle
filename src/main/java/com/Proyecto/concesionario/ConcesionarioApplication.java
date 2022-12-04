package com.Proyecto.concesionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ConcesionarioApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ConcesionarioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String password = "123";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println("encodedPassword --> " + password + " = " + encodedPassword);
        
        // this.jdbcTemplate.update("INSERT INTO T_USUARIO(username, password, rol_id, active) VALUES ('Dummy', '123', 1, 1)");  
    }

}
