package pawsitive.pawsitive_BE.web.dto.main;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
@Getter
public class VolunteerResponseDTO {
    private Integer id;
    private String region;
    private String title;

    public VolunteerResponseDTO(Integer id, String region, String title) {
        this.id = id;
        this.region = region;
        this.title = title;
    }
}
