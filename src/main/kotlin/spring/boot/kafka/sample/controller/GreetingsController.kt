package spring.boot.kafka.sample.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import spring.boot.kafka.sample.models.Greetings
import spring.boot.kafka.sample.service.GreetingsService


@RestController
class GreetingsController(@Autowired private val greetingsService: GreetingsService) {

    @GetMapping("/greetings")
    fun sendMessageToKafkaTopic(@RequestParam("message") message: String) {
        val greetings = Greetings(
                timestamp = System.currentTimeMillis(),
                message = message
        )
        greetingsService.sendGreeting(greetings)
    }
}