package pawsitive.pawsitive_BE.web.dto.main;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@NoArgsConstructor
public class AdoptionResponseDTO {
    private Integer id;
    private String type;
    private String specType;
    private String shelterName;
    private LocalDateTime createdAt;

    public AdoptionResponseDTO(Integer id, String type, String specType, String shelterName, LocalDateTime createdAt) {
        this.id = id;
        this.type = type;
        this.specType = specType;
        this.shelterName = shelterName;
        this.createdAt = createdAt;
    }
}
