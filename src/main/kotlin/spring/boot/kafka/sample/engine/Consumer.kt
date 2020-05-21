package spring.boot.kafka.sample.engine

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.io.IOException
import java.util.logging.Logger

@Service
class Consumer {

    private var logger: org.slf4j.Logger? = LoggerFactory.getLogger(Producer::class.java)

    @KafkaListener(topics = ["users"], groupId = "group_id")
    fun consume(message: String) {
        logger?.info(String.format("#### -> Consumed message -> %s", message));
    }

}