package jpa.jpa_study.jpa.advanced_mapping.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;

//@Entity
@DiscriminatorValue("M")
@Setter
@Getter
public class Movie extends Item {

    private String director;

    private String actor;

}
