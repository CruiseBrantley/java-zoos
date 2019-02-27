package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.repository.Zoorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/zoos/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Zoocontroller
{
    @Autowired
    Zoorepository zoorepos;

    @GetMapping("/zoos")
    public List<Zoo> listAllZoos()
    {
        return zoorepos.findAll();
    }

    @GetMapping("/id/{zooid}")
    public List<Zoo> getZooByZooId(@PathVariable long zooid)
    {
        return zoorepos.findById(zooid).stream().collect(Collectors.toList());
    }

    @GetMapping("/name/{zooname}")
    public List<Zoo > getZooByZooName(@PathVariable String zooname)
    {
        return zoorepos.findZooByZoonameEquals(zooname);
    }
}