package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Telephonerepository extends JpaRepository<Telephone, Long>
{
    List<Telephone> findTelephoneByPhonenumberEquals(String name);
}

