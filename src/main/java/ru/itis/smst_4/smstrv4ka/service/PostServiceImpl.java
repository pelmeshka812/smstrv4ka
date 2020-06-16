package ru.itis.smst_4.smstrv4ka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.smst_4.smstrv4ka.model.Post;
import ru.itis.smst_4.smstrv4ka.repository.PostRepository;

@Component
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;
    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
