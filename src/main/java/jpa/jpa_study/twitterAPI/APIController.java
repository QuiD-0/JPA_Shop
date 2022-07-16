package jpa.jpa_study.twitterAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twitter")
public class APIController {

    @Autowired
    APIService apiService;

    @GetMapping
    public void apiTest(){
        apiService.TestTwitterLoading();
    }
}
