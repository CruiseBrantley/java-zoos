package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.model.Telephone;
import com.lambdaschool.zoos.repository.Telephonerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/telephones/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Telephonecontroller
{
    @Autowired
    Telephonerepository phonerepos;

    @GetMapping(value = "/telephones")
    public List<Telephone> listAllTelephones()
    {
        return phonerepos.findAll();
    }

    @GetMapping(value = "/id/{telephoneid}")
    public List<Telephone> getTelephoneByTelephoneId(@PathVariable long telephoneid)
    {
        return phonerepos.findById(telephoneid).stream().collect(Collectors.toList());
    }

    @GetMapping(value = "/number/{phonenumber}")
    public List<Telephone> getTelephoneByTelephoneName(@PathVariable String phonenumber)
    {
        return phonerepos.findTelephoneByPhonenumberEquals(phonenumber);
    }
}
