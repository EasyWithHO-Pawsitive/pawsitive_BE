package pawsitive.pawsitive_BE.domain;

import jakarta.persistence.*;
import lombok.*;
import pawsitive.pawsitive_BE.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Application extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="volunteer_id")
    private Volunteer volunteer;

    public Application(User user, Volunteer volunteer) {
        this.user = user;
        this.volunteer = volunteer;
    }
}
