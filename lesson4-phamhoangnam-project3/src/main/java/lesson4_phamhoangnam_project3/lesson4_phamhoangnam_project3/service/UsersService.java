package lesson4_phamhoangnam_project3.lesson4_phamhoangnam_project3.service;

import lesson4_phamhoangnam_project3.lesson4_phamhoangnam_project3.dto.UsersDTO;
import lesson4_phamhoangnam_project3.lesson4_phamhoangnam_project3.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    private final List<User> users = new ArrayList<>();

    public UsersService() {
        users.add(new User(1L, "user1", "pass1", "Nguyen Van A", "0123456789", "a@gmail.com", true));
        users.add(new User(2L, "user2", "pass2", "Tran Van B", "0987654321", "b@gmail.com", false));
    }

    // CREATE
    public boolean create(UsersDTO dto) {
        try {
            Long newId = (long) (users.size() + 1);
            User user = new User(
                    newId,
                    dto.getUsername(),
                    dto.getPassword(),
                    dto.getFullName(),
                    dto.getPhone(),
                    dto.getEmail(),
                    dto.getStatus()
            );
            users.add(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // READ ALL
    public List<User> findAll() {
        return users;
    }

    // READ ONE
    public User findById(Long id) {
        return users.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean update(Long id, UsersDTO dto) {
        User user = findById(id);
        if (user == null) return false;

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setFullName(dto.getFullName());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setStatus(dto.getStatus());

        return true;
    }

    // DELETE
    public boolean delete(Long id) {
        return users.removeIf(x -> x.getId().equals(id));
    }
}
