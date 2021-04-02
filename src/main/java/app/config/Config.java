package app.config;

import app.logger.Logger;
import app.logger.LoggerImplLower;
import app.logger.LoggerImplUpper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${isUppercase}")
    private boolean isDev;

    @Bean
    public Logger logger() {
        if (isDev) {
            return new LoggerImplLower();
        } else {
            return new LoggerImplUpper();
        }

    }
}
