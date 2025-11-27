package lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "phn_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhnCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phn_id")
    Long id;

    @Column(name = "phn_category_name")
    String categoryName;

    @Column(name = "phn_category_status")
    Boolean categoryStatus;
}
