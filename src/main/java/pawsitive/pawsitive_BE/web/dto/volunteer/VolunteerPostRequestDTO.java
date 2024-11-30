package pawsitive.pawsitive_BE.web.dto.volunteer;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerPostRequestDTO {
    @NotNull(message = "보호소 선택은 필수입니다.")
    private Integer shelterId;

    @NotNull(message = "제목은 필수입니다.")
    private String title;

    @NotNull(message = "봉사 날짜는 필수입니다.")
    private String volunteerDate;

    @NotNull(message = "봉사 인원 수는 필수입니다.")
    private Integer numberOfStaffs;

    @NotNull(message = "봉사 시작 시간은 필수입니다.")
    private String startTime;

    @NotNull(message = "봉사 종료 시간은 필수입니다.")
    private String endTime;

    @NotNull(message = "봉사 설명은 필수입니다.")
    private String content;
}
