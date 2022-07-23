package jpa.jpa_study.jpa.mysql_test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysql")
@RequiredArgsConstructor
public class MysqlController {


    private final MysqlTestService mysqlTestService;

    @GetMapping
    public TestEntity test() {
        return mysqlTestService.test();
    }
}
