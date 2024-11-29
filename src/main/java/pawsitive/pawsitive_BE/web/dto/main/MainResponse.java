package pawsitive.pawsitive_BE.web.dto.main;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class MainResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MainResponseDTO {
        private List<VolunteerResponseDTO> volunteers;
        private List<AdoptionResponseDTO> adoptions;
    }
}
