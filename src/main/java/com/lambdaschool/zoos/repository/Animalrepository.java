package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Animalrepository extends JpaRepository <Animal, Long>
{
    List<Animal> findAnimalByAnimaltype(String anyimaltype);
    void deleteAnimalByAnimalid(long animalid);
}
