package com.example.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class AtmApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtmApplication.class, args);
    }
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "application.xml"
        );

        ATM atm = context.getBean("atmBean", ATM.class);
            atm.run();
}
