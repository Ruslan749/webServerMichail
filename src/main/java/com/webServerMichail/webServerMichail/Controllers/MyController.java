package com.webServerMichail.webServerMichail.Controllers;

import com.webServerMichail.webServerMichail.Modals.Post;
import com.webServerMichail.webServerMichail.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/index")
    public void formGet(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
    }
    @GetMapping("/")
    public String home(Model model){
        return "index";
    }

    @PostMapping("/")
    public String formPostData (@RequestParam String name, @RequestParam String phone, Model model){
        Post post = new Post(name, phone);
        postRepository.save(post);
        return "/index";
    }
}
