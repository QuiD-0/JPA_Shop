package jpa.jpa_study.advanced_mapping.test;

import jpa.jpa_study.advanced_mapping.item.Album;
import jpa.jpa_study.advanced_mapping.member.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class InputTestController {

    @Autowired
    InputTestService inputTestService;

    @GetMapping("/1")
    public Album test_controller_item(){
        Album album = inputTestService.ad_mapping_test();
        return album;
    }

    @GetMapping("/2")
    public Seller test_controller_baseEntity(){
        Seller seller = inputTestService.add_baseEntity();
        return seller;
    }
}
