package spring.boot.kafka.sample.engine

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel
import org.springframework.stereotype.Component


interface GreetingsStreams {

    companion object{
        const val INPUT = "greetings-in"
        const val OUTPUT = "greetings-out"
    }

    @Input(INPUT)
    fun inboundGreetings(): SubscribableChannel

    @Output(OUTPUT)
    fun outboundGreetings(): MessageChannel

}