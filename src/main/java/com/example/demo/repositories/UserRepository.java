package com.example.demo.repositories;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository<E extends User> extends MongoRepository<User, String>{
    Optional<User> findByEmail(String email);

    Optional<User> findByCin(int cin);
    List<User> findByRole(Role role);

    User findByResetToken(String resetToken);
	
}
