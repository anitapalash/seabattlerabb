package hse.seabattlerabbit.app;

import hse.seabattlerabbit.app.config.RabbitConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@EnableAutoConfiguration
@ComponentScan
@Import(RabbitConfig.class)
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
