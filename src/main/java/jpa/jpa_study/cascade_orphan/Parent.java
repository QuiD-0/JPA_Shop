package jpa.jpa_study.cascade_orphan;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Getter
@Setter
@ToString
public class Parent {

    @Id
    @GeneratedValue
    @Column(name = "parent_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> child = new ArrayList<>();

    public void add_child(Child child) {
        this.child.add(child);
        child.setParent(this);
    }
}
