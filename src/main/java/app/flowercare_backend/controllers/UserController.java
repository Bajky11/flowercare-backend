package app.flowercare_backend.controllers;


import app.flowercare_backend.entities.AppUser;
import app.flowercare_backend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;
    public static final String API_USER_PATH = "/flowercare/v1/users";

    /*
    @GetMapping(value = API_USER_PATH + "/{id}")
    public ResponseEntity<String> getByID(@PathVariable Long id) {
        Optional<AppUser> appUser = userService.getById(id);
        if (!appUser.isPresent()) {
            return ResponseEntity.badRequest().body("user not found");
        }
        return ResponseEntity.ok().body("appUser");
    }
    */

    @PostMapping(value = API_USER_PATH + "/register")
    public ResponseEntity<?> register(@RequestBody AppUser user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Invalid user data");
        }

        Optional<AppUser> existingUser = userService.findByUsername(user.getUsername());

        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        userService.save(user);
        return ResponseEntity.ok().body("User registered successfully");
    }

    @PostMapping(value = API_USER_PATH + "/login")
    public ResponseEntity<?> login(@RequestBody AppUser user) {
        // Check if username or password is null
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Invalid user data");
        }

        // Attempt to find the user with the given username and password
        Optional<AppUser> foundUser = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        // Check if the user was found
        if (!foundUser.isPresent()) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        // Return the found user
        return ResponseEntity.ok(foundUser.get());
    }

}
