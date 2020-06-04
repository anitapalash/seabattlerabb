package hse.seabattlerabbit.app.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@EnableRabbit
@Configuration
public class RabbitConfig {
    @Bean
    public ConnectionFactory connectionFactory() {
        final CachingConnectionFactory cf = new CachingConnectionFactory("mustang.rmq.cloudamqp.com", 5672);
        cf.setVirtualHost("nhtvabdw");
        cf.setUsername("nhtvabdw");
        cf.setPassword("nu9sBGHcelHbTZ6DGzBEIRVkcT8DvOGq");
        return cf;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        return rabbitAdmin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }


    @Bean
    public Queue myQueue1() {
        return new Queue("sea_battle");
    }

    @Bean
    public Queue myQueue2() {
        return new Queue("sea_battle_2");
    }

    @Bean
    public FanoutExchange fanoutExchangeA(){
        return new FanoutExchange("amq.fanout");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(myQueue1()).to(fanoutExchangeA());
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(myQueue2()).to(fanoutExchangeA());
    }
}
