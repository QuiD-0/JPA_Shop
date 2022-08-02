package jpa.jpa_study.jpa.transient_test;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class TransientEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Transient
    private List<String> sList = new ArrayList<>();

    public void add(String text){
        this.sList.add(text);
    }
}
