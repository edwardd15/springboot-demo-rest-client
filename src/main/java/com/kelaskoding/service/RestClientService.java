package com.kelaskoding.service;

import com.kelaskoding.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientService {
    
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getUserString(int id) {
        ResponseEntity<String> responseEntity = 
            restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users/" +id, String.class);
        return responseEntity;
    }

    public ResponseEntity<User> getUserObject(int id) {
        User user = 
            restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" +id, User.class);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User[]> findAllUser() {
        User[] users = 
            restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/", User[].class);
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<User> postUserObject(User user){
        User response = restTemplate.postForObject("https://jsonplaceholder.typicode.com/users/", user, User.class);
        return ResponseEntity.ok(response);
    }
}
