package Lesson5_PhamHoangNam_Project3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhnInfo {
    private String name;
    private String nickName;
    private String email;
    private String website;
}