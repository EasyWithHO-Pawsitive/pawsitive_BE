package pawsitive.pawsitive_BE.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pawsitive.pawsitive_BE.domain.Volunteer;
import pawsitive.pawsitive_BE.repository.ShelterRepository;
import pawsitive.pawsitive_BE.repository.VolunteerRepository;
import pawsitive.pawsitive_BE.web.dto.volunteer.VolunteerResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {
    private final VolunteerRepository volunteerRepository;
    private final ShelterRepository shelterRepository;

    @Override
    public VolunteerResponse.VolunteerListResultDTO volunteerList() {
        List<Volunteer> volunteers = volunteerRepository.findAll();

        // Volunteer 엔티티를 VolunteerBriefDto로 변환
        List<VolunteerResponse.VolunteerBriefDto> volunteerBriefDtos = volunteers.stream()
                .map(volunteer -> VolunteerResponse.VolunteerBriefDto.builder()
                        .id(volunteer.getId())
                        .title(volunteer.getTitle())
                        .date(volunteer.getVolunteerDate())
                        .numberOfStaffs(volunteer.getNumberOfStaff())
                        .shelterName(volunteer.getShelter() != null ? volunteer.getShelter().getName() : null)
                        .region(volunteer.getShelter() != null ? volunteer.getShelter().getRegion() : null)
                        .build())
                .toList();

        // VolunteerListResultDTO 생성
        return VolunteerResponse.VolunteerListResultDTO.builder()
                .volunteers(volunteerBriefDtos)
                .build();
    }
}
