/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mybatis02.controller;

import com.example.mybatis02.model.Actor;
import com.example.mybatis02.service.ActorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Victor Rosales
 */
@RestController
@RequestMapping("/act")
public class ActorRestController {
    @Autowired
    private ActorService postService;
    
    @GetMapping("/all")
    public List<Actor> getPosts() {
        return postService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getPost(@PathVariable int id) {
        Actor post = postService.findById(id);
        return ResponseEntity.ok(post);
    }
    
     @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {        
        postService.deleteById(id);
    }
    
    @PostMapping("/add")
    public int addPost(@RequestBody Actor post) {  
        return postService.insert(post);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody Actor post) {  
        Actor pos = new Actor(post.getIdactor(),post.getNombre(),post.getApellido(),post.getCorreo());
        return postService.update(post);
    }
    
}
