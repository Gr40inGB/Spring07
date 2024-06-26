package org.gr40in.secur.repository;

import org.gr40in.secur.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByName(String name);

//    void updateUserById(long id, User user);
}
