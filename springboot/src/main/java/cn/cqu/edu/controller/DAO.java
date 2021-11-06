package cn.cqu.edu.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.cqu.edu.domain.User;
import cn.cqu.edu.repository.UserRepository;
@RestController
@CrossOrigin
public class DAO {
    @Autowired
    private UserRepository userRepository;
    //add
    @RequestMapping(value="/user/add")
    public User add(User user)
    {
        return userRepository.insert(user);
    }
    //find all
    @RequestMapping(value="/user/findAll")
    public List<User> findAll()
    {
        return userRepository.findAll();
    }
    //find id
    @RequestMapping(value="/user/findById")
    public Optional<User> findById(String userId)
    {
        return userRepository.findById(userId);
    }
    //update
    @RequestMapping(value="/user/update")
    public User update(User user)
    {
        if(userRepository.existsById(user.getUserId()))
            return userRepository.save(user);
        else
            return null;
    }
    //delete
    @RequestMapping(value="/user/delete")
    public boolean delete(String userId)
    {
        userRepository.deleteById(userId);
        if(userRepository.existsById(userId)){
            return false;
        }
        else {
            return true;
        }

    }
}
