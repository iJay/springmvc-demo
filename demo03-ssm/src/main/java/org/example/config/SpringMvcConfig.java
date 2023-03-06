package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"org.example.controller", "org.example.config", "org.example.utils"})
@EnableWebMvc
public class SpringMvcConfig {
}
