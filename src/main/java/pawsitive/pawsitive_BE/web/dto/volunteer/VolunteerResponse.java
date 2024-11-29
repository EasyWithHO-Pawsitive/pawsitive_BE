package pawsitive.pawsitive_BE.web.dto.volunteer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class VolunteerResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VolunteerListResultDTO {
        List<VolunteerBriefDto> volunteers;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VolunteerBriefDto {
        Integer id;
        String title;
        String date;
        Integer numberOfStaffs;
        String shelterName;
        String region;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VolunteerDetailResultDTO {
        Integer id;
        String title;
        String volunteerDate;
        Integer numberOfStaffs;
        String status;
        String region;
        String startTime;
        String endTime;
        String content;
        String managerName;
        String phone;
        String shelterName;
        String address;
    }
}
