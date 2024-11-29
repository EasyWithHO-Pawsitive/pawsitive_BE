package pawsitive.pawsitive_BE.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pawsitive.pawsitive_BE.domain.Adoption;
import pawsitive.pawsitive_BE.domain.Volunteer;
import pawsitive.pawsitive_BE.repository.AdoptionRepository;
import pawsitive.pawsitive_BE.repository.ShelterRepository;
import pawsitive.pawsitive_BE.repository.VolunteerRepository;
import pawsitive.pawsitive_BE.web.dto.main.AdoptionResponseDTO;
import pawsitive.pawsitive_BE.web.dto.main.MainResponse;
import pawsitive.pawsitive_BE.web.dto.main.VolunteerResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
    private final VolunteerRepository volunteerRepository;
    private final AdoptionRepository adoptionRepository;
    private final ShelterRepository shelterRepository;

    @Override
    public MainResponse.MainResponseDTO main() {
        try {
            List<Volunteer> volunteers = volunteerRepository.findTop3ByOrderByIdDesc();
            List<VolunteerResponseDTO> volunteerResponseDTOS = volunteers.stream()
                    .map(volunteer -> new VolunteerResponseDTO(volunteer.getId(),
                            volunteer.getShelter() != null ? volunteer.getShelter().getRegion() : null,
                            volunteer.getTitle()))
                    .collect(Collectors.toList());

            List<Adoption> adoptions = adoptionRepository.findTop3ByOrderByIdDesc();
            List<AdoptionResponseDTO> adoptionResponseDTOS = adoptions.stream()
                    .map(adoption -> new AdoptionResponseDTO(
                            adoption.getId(),
                            adoption.getType(),
                            adoption.getSpecType(),
                            adoption.getShelter() != null ? adoption.getShelter().getName() : null,
                            adoption.getCreatedAt()
                    ))
                    .collect(Collectors.toList());

            return MainResponse.MainResponseDTO.builder()
                    .volunteers(volunteerResponseDTOS)
                    .adoptions(adoptionResponseDTOS)
                    .build();
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
            e.printStackTrace();
            return null; // 또는 적절한 기본값 반환
        }
    }


}
