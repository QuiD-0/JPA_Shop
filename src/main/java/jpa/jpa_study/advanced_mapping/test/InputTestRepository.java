package jpa.jpa_study.advanced_mapping.test;

import jpa.jpa_study.advanced_mapping.item.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
@RequiredArgsConstructor
public class InputTestRepository {

    private final EntityManager em;

    public Album createAlbum() {
        Album album = new Album();
        album.setPrice(10000);
        album.setName("앨범");
        album.setArtist("아티스트");
        em.persist(album);
        return album;
    }
}
