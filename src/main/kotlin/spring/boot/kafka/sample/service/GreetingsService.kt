package spring.boot.kafka.sample.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.SubscribableChannel
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service
import org.springframework.util.MimeTypeUtils
import spring.boot.kafka.sample.engine.GreetingsStreams
import spring.boot.kafka.sample.models.Greetings

@Service
class GreetingsService(@Autowired private val greetingsStreams: GreetingsStreams) {

    fun sendGreeting(greetings: Greetings){
        println("#### -> Sending greetings -> $greetings")
        val messageChannel: MessageChannel = greetingsStreams.outboundGreetings()
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build()
        )
    }

}