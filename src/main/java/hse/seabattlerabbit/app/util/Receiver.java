package hse.seabattlerabbit.app.util;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "sea_battle")
    public void worker1(String message) {
        System.out.println("accepted on worker 1 : " + message);
    }

    @RabbitListener(queues = "sea_battle_2")
    public void worker2(String message) {
        System.out.println("accepted on worker 2 : " + message);
    }
}
