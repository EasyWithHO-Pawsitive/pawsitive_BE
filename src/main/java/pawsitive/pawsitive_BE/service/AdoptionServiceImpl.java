package pawsitive.pawsitive_BE.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pawsitive.pawsitive_BE.domain.Adoption;
import pawsitive.pawsitive_BE.repository.AdoptionRepository;
import pawsitive.pawsitive_BE.web.dto.adoption.AdoptionResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {
    private final AdoptionRepository adoptionRepository;

    @Override
    public AdoptionResponse.AdoptionListResultDTO adoptionList() {
        List<Adoption> adoptions = adoptionRepository.findAll();

        List<AdoptionResponse.AdoptionBriefDto> adoptionBriefDtos = adoptions.stream()
                .map(adoption -> AdoptionResponse.AdoptionBriefDto.builder()
                        .id(adoption.getId())
                        .title(adoption.getTitle())
                        .type(adoption.getType())
                        .specType(adoption.getSpecType())
                        .shelterName(adoption.getShelter() != null ? adoption.getShelter().getName() : null)
                        .createdAt(adoption.getCreatedAt().toLocalDate())
                        .build())
                .toList();

        return AdoptionResponse.AdoptionListResultDTO.builder()
                .adoptions(adoptionBriefDtos)
                .build();
    }

    @Override
    public AdoptionResponse.AdoptionDetailResultDTO adoptionDetail(Integer postId) {
        Adoption adoption = adoptionRepository.findById(Long.valueOf(postId))
                .orElseThrow(() -> new EntityNotFoundException("입양 요청이 존재하지 않습니다."));

        // Adoption 엔티티를 AdoptionDetailResultDTO로 변환
        return AdoptionResponse.AdoptionDetailResultDTO.builder()
                .id(adoption.getId())
                .title(adoption.getTitle())
                .status(adoption.getStatus().toString())
                .type(adoption.getType())
                .specType(adoption.getSpecType())
                .gender(adoption.getGender().toString())
                .neutering(adoption.getNeutering())
                .age(adoption.getAge())
                .description(adoption.getDescription())
                .shelterName(adoption.getShelter() != null ? adoption.getShelter().getName() : null)
                .createdAt(adoption.getCreatedAt().toLocalDate())
                .mangerName(adoption.getShelter() != null ? adoption.getShelter().getManagerName(): null)
                .phone(adoption.getShelter() != null ? adoption.getShelter().getPhone() : null)
                .build();
    }
}
