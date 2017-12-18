package com.ws;

import com.ws.service.HelloMessageService;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.ws.service")
public class SpringBootJavaApplication implements CommandLineRunner {

    @Resource
    private HelloMessageService helloService;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(SpringBootJavaApplication.class);

        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            System.out.println(helloService.getMessage(args[0].toString()));
        } else {
            System.out.println(helloService.getMessage());
        }
    }
}