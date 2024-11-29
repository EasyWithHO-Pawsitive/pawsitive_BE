package pawsitive.pawsitive_BE.domain;

import jakarta.persistence.*;
import lombok.*;
import pawsitive.pawsitive_BE.domain.common.BaseEntity;
import pawsitive.pawsitive_BE.domain.enums.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Volunteer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String volunteerDate;

    @Column(nullable = false)
    private Integer numberOfStaff;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String startTime;

    @Column(nullable = false)
    private String endTime;


    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) default 'OPEN")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shelter_id")
    private Shelter shelter;

    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.ALL)
    private List<Application> userApplications = new ArrayList<>();
}
