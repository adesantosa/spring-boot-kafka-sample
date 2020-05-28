package spring.boot.kafka.sample.service

import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink.INPUT
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import spring.boot.kafka.sample.engine.GreetingsStreams
import spring.boot.kafka.sample.models.Greetings


@Component
@EnableBinding(GreetingsStreams::class)
class GreetingsListener {

    @StreamListener(GreetingsStreams.INPUT)
    fun handleGreetings(@Payload greetings: Greetings){
        println("Received greetings: $greetings")
    }
}