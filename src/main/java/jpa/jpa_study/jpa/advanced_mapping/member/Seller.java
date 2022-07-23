package jpa.jpa_study.jpa.advanced_mapping.member;

import lombok.Getter;
import lombok.Setter;

//@Entity
@Setter
@Getter
public class Seller extends BaseEntity{
    private String shopName;
}