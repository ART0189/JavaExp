package cn.cqu.edu.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin
public class ResController {

    @GetMapping("/res/{id}")
    public String testOauth(@PathVariable String id) {
        return "Get the resource " + id;
    }
}