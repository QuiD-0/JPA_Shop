package jpa.jpa_study.advanced_mapping.test;

import jpa.jpa_study.advanced_mapping.item.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class InputTestController {

    @Autowired
    InputTestService inputTestService;

    @GetMapping
    public Album test_controller(){
        Album album = inputTestService.ad_mapping_test();
        return album;
    }
}
