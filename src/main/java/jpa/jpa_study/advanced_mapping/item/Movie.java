package jpa.jpa_study.advanced_mapping.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
@Setter
@Getter
public class Movie extends Item {

    private String director;

    private String actor;

}
