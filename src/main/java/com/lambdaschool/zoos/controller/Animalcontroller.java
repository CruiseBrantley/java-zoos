package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.repository.Animalrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/animals/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Animalcontroller
{
    @Autowired
    Animalrepository animalrepos;

    @GetMapping("/animals")
    public List<Animal> listAllAnimals()
    {
        return animalrepos.findAll();
    }
    
    @GetMapping(value = "/id/{animalid}")
    public List<Animal> getAnimalByAnimalId(@PathVariable long animalid)
    {
        return animalrepos.findById(animalid).stream().collect(Collectors.toList());
    }

    @GetMapping(value = "/name/{animaltype}")
    public List<Animal> getAnimalByAnimalName(@PathVariable String animaltype)
    {
        return animalrepos.findAnimalByAnimaltype(animaltype);
    }
}
