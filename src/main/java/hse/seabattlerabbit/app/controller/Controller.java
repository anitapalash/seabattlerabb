package hse.seabattlerabbit.app.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    RabbitTemplate template;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Empty mapping";
    }

    @RequestMapping("/emit")
    @ResponseBody
    String emit() {
        template.setExchange("amq.fanout");
        template.convertAndSend("Fanout message");
        return "Emit to amq.fanout";
    }
}
