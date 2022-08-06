package ru.niatomi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author niatomi
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.jbtits.spring.mvc.webac")
public class AppConfig extends WebMvcConfigurationSupport {
}
