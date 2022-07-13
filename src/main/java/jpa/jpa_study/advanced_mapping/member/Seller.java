package jpa.jpa_study.advanced_mapping.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Seller extends BaseEntity{
    private String shopName;
}