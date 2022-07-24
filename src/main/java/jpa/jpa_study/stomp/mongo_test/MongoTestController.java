package jpa.jpa_study.stomp.mongo_test;

import jpa.jpa_study.stomp.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mongo")
public class MongoTestController {

    private final MongoTestService mongoTestService;

    @GetMapping
    public TestEntity test() {
        ChatMessage chatMessage = new ChatMessage();
        return mongoTestService.test(chatMessage);
    }

    @GetMapping("/{id}")
    public List<TestEntity> find(@PathVariable(name = "id") String id) {
        List<TestEntity> msgs = mongoTestService.findAllChat(id);
        return msgs;
    }
}
