package ru.itis.smst_4.smstrv4ka.service;

import ru.itis.smst_4.smstrv4ka.model.Post;

public interface PostService {
    void addPost(Post post);
    void deletePost(Long id);
}
