package jpa.jpa_study.advanced_mapping.test;

import jpa.jpa_study.advanced_mapping.embedded.Parent;
import jpa.jpa_study.advanced_mapping.embedded.ParentId;
import jpa.jpa_study.advanced_mapping.item.Album;
import jpa.jpa_study.advanced_mapping.member.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

//@RestController
//@RequestMapping("/test")
public class InputTestController {

    @Autowired
    InputTestService inputTestService;

    @GetMapping
    public List test_controller_item(){
        List list = new ArrayList<>();

        Album album = inputTestService.ad_mapping_test();
        list.add(album);

        Seller seller = inputTestService.add_baseEntity();
        list.add(seller);

        Parent parent = inputTestService.add_embedded();
        list.add(parent);

        System.out.println(parent.getId().equals(new ParentId("ID1","ID2")));
        return list;
    }

}
