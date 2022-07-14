package jpa.jpa_study.advanced_mapping.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.PrimaryKeyJoinColumn;

//@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID")

public class Book extends Item{

    private String author;

    private String isbn;

}
