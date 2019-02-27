package com.lambdaschool.zoos.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "zoo")
public class Zoo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long zooid;

    private String zooname;

    @ManyToMany(mappedBy = "zoo")
    @JsonIgnoreProperties("zoos")
    private Set<Animal> animal  = new HashSet<>();

    public Zoo(){}

    public long getZooid()
    {
        return zooid;
    }

    public void setZooid(long zooid)
    {
        this.zooid = zooid;
    }

    public String getZooname()
    {
        return zooname;
    }

    public void setZooname(String zooname)
    {
        this.zooname = zooname;
    }

    public Set<Animal> getAnimal()
    {
        return animal;
    }

    public void setAnimal(Set<Animal> animal)
    {
        this.animal = animal;
    }
}
