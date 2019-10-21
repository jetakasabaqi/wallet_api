package abc.workshop.wallet.controller;

import abc.workshop.wallet.model.User;
import abc.workshop.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping
    public User create(User user) {
        return userService.save(user);
    }

    @PutMapping
    public User update(User user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable int id) {
        userService.deleteById(id);
    }
}
