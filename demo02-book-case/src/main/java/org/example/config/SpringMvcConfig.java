package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"org.example"})
//@ImportResource(locations = {"org.example.config.SpringMvcSupport"})
@EnableWebMvc
public class SpringMvcConfig {
}
