package pawsitive.pawsitive_BE.web.dto.shelter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class ShelterResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShelterInfoDTO {
        Integer id;
        String name;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShelterInfoListDTO {
        List<ShelterInfoDTO> shelterInfos;
    }
}
