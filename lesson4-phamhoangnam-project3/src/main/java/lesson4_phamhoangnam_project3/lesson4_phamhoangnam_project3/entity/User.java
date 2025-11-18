package lesson4_phamhoangnam_project3.lesson4_phamhoangnam_project3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String phone;
    private String email;
    private Boolean status;
}

