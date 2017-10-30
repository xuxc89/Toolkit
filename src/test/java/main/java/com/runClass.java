package main.java.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by xuxc
 * since  2017/10/20 11:23.
 * version 1
 */
@EnableCaching
@EnableScheduling
@SpringBootApplication
public class runClass extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(runClass.class, args);
    }
}
