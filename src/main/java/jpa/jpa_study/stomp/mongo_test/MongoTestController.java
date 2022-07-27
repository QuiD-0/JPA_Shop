package jpa.jpa_study.stomp.mongo_test;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/{id}")
    public List<TestEntity> find(@PathVariable(name = "id") String id, Pageable pageable) {
        List<TestEntity> msgs = mongoTestService.findAllChat(id, pageable);
        return msgs;
    }
}
