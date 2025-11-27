package lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "phn_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhnProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phn_id")
    Long id;

    @Column(name = "phn_product_name")
    String productName;

    @Column(name = "phn_product_price")
    Double productPrice;

    @Column(name = "phn_product_status")
    Boolean productStatus;

    @ManyToOne
    @JoinColumn(name = "phn_category_id")
    PhnCategory category;
}
