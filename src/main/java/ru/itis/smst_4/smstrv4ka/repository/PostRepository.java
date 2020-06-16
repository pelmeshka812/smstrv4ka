package ru.itis.smst_4.smstrv4ka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.smst_4.smstrv4ka.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    void deleteById(Long id);
    List<Post> findAllByAuthorId(Long id);

}
