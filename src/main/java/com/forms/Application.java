package com.forms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;

@SpringBootApplication ( scanBasePackages = {"com.forms.wl" },exclude = PageHelperAutoConfiguration.class )
@ServletComponentScan
@EnableScheduling
public class Application extends SpringBootServletInitializer  {
    
    public static void main(String[] args) {
        SpringApplication.run( Application.class , args );
    }
    
}

