package org.example.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="catagories")
public class Catagory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="catagory")
    private String catagory;

    @ManyToMany(mappedBy ="catagories",fetch = FetchType.LAZY)
    List<Post> Post1=new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }


}
