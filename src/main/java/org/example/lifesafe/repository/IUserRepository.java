package org.example.lifesafe.repository;

import org.example.lifesafe.model.entities.User;

import java.util.Optional;

public interface IUserRepository extends DefaultRepository<User> {
    Optional<User> findByEmail(String email);
}
