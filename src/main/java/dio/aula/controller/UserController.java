package dio.aula.controller;

import dio.aula.model.User;
import dio.aula.repository.UserRepository;
import dio.aula.handler.BusinessException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public User getOne(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @PostMapping
    public void postUser(@RequestBody User user) {
        repository.save(user);
    }

    @PutMapping
    public void putUser(@RequestBody User user) {
        if (user.getUsername() == null) {
            throw new BusinessException("Username is required");
        }
        repository.save(user);
    }
}
