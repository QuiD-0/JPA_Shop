package jpa.jpa_study.advanced_mapping.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;

//@Entity
@DiscriminatorValue("A")
@Setter
@Getter
@ToString
public class Album extends Item{

    private String artist;

}
