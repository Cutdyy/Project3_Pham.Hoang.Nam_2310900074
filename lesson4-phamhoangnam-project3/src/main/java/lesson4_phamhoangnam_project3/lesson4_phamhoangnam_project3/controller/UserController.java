package lesson4_phamhoangnam_project3.lesson4_phamhoangnam_project3.controller;

import lesson4_phamhoangnam_project3.lesson4_phamhoangnam_project3.dto.UsersDTO;
import lesson4_phamhoangnam_project3.lesson4_phamhoangnam_project3.entity.User;
import lesson4_phamhoangnam_project3.lesson4_phamhoangnam_project3.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(usersService.findAll());
    }

    // GET ONE
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        User user = usersService.findById(id);
        return (user == null)
                ? ResponseEntity.badRequest().body("User not found!")
                : ResponseEntity.ok(user);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<String> addUser(@Valid @RequestBody UsersDTO dto) {
        return usersService.create(dto)
                ? ResponseEntity.ok("User created successfully!")
                : ResponseEntity.badRequest().body("Failed to create user!");
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @Valid @RequestBody UsersDTO dto) {
        return usersService.update(id, dto)
                ? ResponseEntity.ok("User updated successfully!")
                : ResponseEntity.badRequest().body("User not found!");
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return usersService.delete(id)
                ? ResponseEntity.ok("Deleted successfully!")
                : ResponseEntity.badRequest().body("User not found!");
    }

    // HANDLE VALIDATION ERROR
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest()
                .body(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
