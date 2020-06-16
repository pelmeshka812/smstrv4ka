package ru.itis.smst_4.smstrv4ka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.smst_4.smstrv4ka.MySession.MySession;
import ru.itis.smst_4.smstrv4ka.dto.PostDto;
import ru.itis.smst_4.smstrv4ka.model.Post;
import ru.itis.smst_4.smstrv4ka.repository.PostRepository;
import ru.itis.smst_4.smstrv4ka.repository.UsersRepository;
import ru.itis.smst_4.smstrv4ka.service.PostService;

@Controller
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    MySession session;
    @Autowired
    UsersRepository repository;
    @Autowired
    PostRepository postRepository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/add_post")
    String addPost() {
        return "add_post";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add_post")
    String createPost(PostDto postDto) {
        Post post = Post.builder().text(postDto.getText()).topic(postDto.getTopic()).author(session.getUser()).build();
        session.getUser().getPosts().add(post);
        repository.save(session.getUser());
        session.getUser().setPosts(postRepository.findAllByAuthorId(session.getUser().getId()));
        return "redirect:/profile";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/delete_post")
    String deletePost(@RequestParam("id") Long id) {
//        Post post = Post.builder().id(id).build();
        postService.deletePost(id);
        session.getUser().setPosts(postRepository.findAllByAuthorId(session.getUser().getId()));
        return "redirect:/profile";
    }
}
