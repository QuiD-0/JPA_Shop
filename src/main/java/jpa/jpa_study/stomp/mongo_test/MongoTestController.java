package jpa.jpa_study.stomp.mongo_test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mongo")
public class MongoTestController {

    private final MongoTestService mongoTestService;

    @GetMapping
    public TestEntity test(){
        return mongoTestService.test();
    }
}
