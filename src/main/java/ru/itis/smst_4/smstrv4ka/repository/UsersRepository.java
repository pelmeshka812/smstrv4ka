package ru.itis.smst_4.smstrv4ka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.smst_4.smstrv4ka.model.User;
import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional <User> findUserByEmail(String email) ;
}
