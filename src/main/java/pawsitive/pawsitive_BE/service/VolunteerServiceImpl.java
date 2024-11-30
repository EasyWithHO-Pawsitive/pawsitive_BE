package pawsitive.pawsitive_BE.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pawsitive.pawsitive_BE.domain.Shelter;
import pawsitive.pawsitive_BE.domain.Volunteer;
import pawsitive.pawsitive_BE.domain.enums.Status;
import pawsitive.pawsitive_BE.repository.ShelterRepository;
import pawsitive.pawsitive_BE.repository.VolunteerRepository;
import pawsitive.pawsitive_BE.web.dto.volunteer.VolunteerPostRequestDTO;
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

    @Override
    public VolunteerResponse.VolunteerDetailResultDTO volunteerDetail(Integer postId) {
        Volunteer volunteer = volunteerRepository.findById(Long.valueOf(postId))
                .orElseThrow(() -> new EntityNotFoundException("봉사 요청이 존재하지 않습니다."));

        // Volunteer 엔티티를 VolunteerDetailResultDTO로 변환
        return VolunteerResponse.VolunteerDetailResultDTO.builder()
                .id(volunteer.getId())
                .title(volunteer.getTitle())
                .volunteerDate(volunteer.getVolunteerDate())
                .numberOfStaffs(volunteer.getNumberOfStaff())
                .status(volunteer.getStatus().toString())
                .region(volunteer.getShelter() != null ? volunteer.getShelter().getRegion() : null)
                .startTime(volunteer.getStartTime())
                .endTime(volunteer.getEndTime())
                .content(volunteer.getContent())
                .managerName(volunteer.getShelter() != null ? volunteer.getShelter().getManagerName() : null)
                .phone(volunteer.getShelter().getPhone())
                .shelterName(volunteer.getShelter() != null ? volunteer.getShelter().getName() : null)
                .address(volunteer.getShelter() != null ? volunteer.getShelter().getAddress() : null)
                .build();
    }

    @Override
    public VolunteerResponse.VolunteerPostResultDTO volunteerPost(VolunteerPostRequestDTO volunteerPostRequestDTO) {
        Shelter shelter = shelterRepository.findById(Long.valueOf(volunteerPostRequestDTO.getShelterId()))
                .orElseThrow(() -> new EntityNotFoundException("보호소가 존재하지 않습니다."));

        Volunteer volunteer = Volunteer.builder()
                .title(volunteerPostRequestDTO.getTitle())
                .volunteerDate(volunteerPostRequestDTO.getVolunteerDate())
                .numberOfStaff(volunteerPostRequestDTO.getNumberOfStaffs())
                .startTime(volunteerPostRequestDTO.getStartTime())
                .endTime(volunteerPostRequestDTO.getEndTime())
                .content(volunteerPostRequestDTO.getContent())
                .status(Status.OPEN)
                .shelter(shelter)
                .build();

        Volunteer savedVolunteer = volunteerRepository.save(volunteer);

        return new VolunteerResponse.VolunteerPostResultDTO(savedVolunteer.getId());
    }

}
