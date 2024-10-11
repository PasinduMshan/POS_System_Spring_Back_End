package lk.ijse.pos_system_spring_back_end.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lk.ijse.pos_system_spring_back_end")
public class WebAppConfig {
}
