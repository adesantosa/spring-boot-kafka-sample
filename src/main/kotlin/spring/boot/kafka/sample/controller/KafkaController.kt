package spring.boot.kafka.sample.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import spring.boot.kafka.sample.engine.Producer


@Controller
@RequestMapping(value = ["/kafka"])
class KafkaController(@Autowired private val producer: Producer?) {


    @PostMapping(value = ["/publish"])
    fun sendMessageToKafkaTopic(@RequestParam("message") message: String?) {
        producer?.sendMessage(message!!)
    }
}