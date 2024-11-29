package pawsitive.pawsitive_BE.domain;

import jakarta.persistence.*;
import lombok.*;
import pawsitive.pawsitive_BE.domain.common.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Shelter extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length =30)
    private String name;

    @Column(nullable = false, length =20)
    private String phone;

    @Column(nullable = false, length =10)
    private String managerName;

    @Column(nullable = false, length =20)
    private String managerPhone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length =10)
    private String region;


}
