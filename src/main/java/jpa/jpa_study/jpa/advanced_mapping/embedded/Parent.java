package jpa.jpa_study.jpa.advanced_mapping.embedded;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;

//@Entity
@Getter
@Setter
public class Parent {
    @EmbeddedId
    private ParentId id;

    private String name;

}
