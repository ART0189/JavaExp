package cn.cqu.edu.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
public class MathController {
    @GetMapping(value="/add")
    public double add(double a,double b)
    {
        return a+b;
    }
}