package pawsitive.pawsitive_BE.web.dto.adoption;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class AdoptionResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdoptionListResultDTO {
        List<AdoptionBriefDto> adoptions;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdoptionBriefDto {
        Integer id;
        String title;
        String type;
        String specType;
        String shelterName;
        LocalDate createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdoptionDetailResultDTO {
        Integer id;
        String title;
        String status;
        String type;
        String specType;
        String gender;
        Boolean neutering;
        String age;
        String description;
        String shelterName;
        LocalDate createdAt;
        String mangerName;
        String phone;
    }
}