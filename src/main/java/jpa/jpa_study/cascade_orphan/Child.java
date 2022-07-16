package jpa.jpa_study.cascade_orphan;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @Override
    public String toString() {
        return "Child{" + "id=" + id + ", name='" + name + '\'' + parent.getName()+'}';
    }
}