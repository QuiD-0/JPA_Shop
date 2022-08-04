package jpa.jpa_study.jpa.transient_test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
@RequiredArgsConstructor
public class TransientRepo {

    private final EntityManager em;


    public void save(TransientEntity transientEntity){
        em.persist(transientEntity);
    }

    public TransientEntity find(Long id){
        return em.find(TransientEntity.class,id);
    }

}
