package lesson6_phamhoangnam_project3.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhnStudentDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
}