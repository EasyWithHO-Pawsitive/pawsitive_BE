package pawsitive.pawsitive_BE.domain;

import jakarta.persistence.*;
import lombok.*;
import pawsitive.pawsitive_BE.domain.common.BaseEntity;
import pawsitive.pawsitive_BE.domain.enums.Status;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Volunteer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Date volunteerDate;

    private String numberOfStaff;

    private String content;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shelter_id")
    private Shelter shelter;
}
