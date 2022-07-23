package jpa.jpa_study;

import jpa.jpa_study.jpa.advanced_mapping.item.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
public class AdvancedMappingTest {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void 고급매핑_테스트(){
        Album album = new Album();
        album.setArtist("아티스트");
        album.setName("앨범");
        album.setPrice(10000);
        em.persist(album);
        System.out.println(album);
    }
}
