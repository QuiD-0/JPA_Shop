package jpa.jpa_study.jpa.advanced_mapping.test;

import jpa.jpa_study.jpa.advanced_mapping.embedded.Parent;
import jpa.jpa_study.jpa.advanced_mapping.item.Album;
import jpa.jpa_study.jpa.advanced_mapping.member.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputTestService {

    @Autowired
    InputTestRepository inputTestRepository;

    public Album ad_mapping_test(){
        return inputTestRepository.createAlbum();
    }

    public Seller add_baseEntity() {
        return inputTestRepository.createSeller();
    }

    public Parent add_embedded() {
        return inputTestRepository.createParent();
    }
}
