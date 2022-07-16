package jpa.jpa_study.cascade_orphan;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Parent {

    @Id @GeneratedValue
    @Column(name = "parent_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL)
    private List<Child> child;

    public void add_child(Child child){
        this.child.add(child);
        child.setParent(this);
    }
}
