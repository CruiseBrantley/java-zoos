package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Zoorepository extends JpaRepository<Zoo, Long>
{
    List<Zoo> findZooByZoonameEquals(String name);
}
