package pawsitive.pawsitive_BE.domain;

import jakarta.persistence.*;
import lombok.*;
import pawsitive.pawsitive_BE.domain.common.BaseEntity;
import pawsitive.pawsitive_BE.domain.enums.Status;
import pawsitive.pawsitive_BE.domain.enums.Gender;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Adoption extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String type;

    private String specType;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Boolean neutering = false;

    private Integer age;

    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shelter_id")
    private Shelter shelter;
}
