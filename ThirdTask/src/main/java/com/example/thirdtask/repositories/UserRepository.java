package com.example.thirdtask.repositories;

import com.example.thirdtask.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findById(int id);

    Iterable<User> findAll();

    User findByEmail(String email);

    User save(User user);

    void deleteById(int id);

}
