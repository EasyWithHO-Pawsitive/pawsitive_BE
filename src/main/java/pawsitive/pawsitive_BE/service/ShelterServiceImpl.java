package pawsitive.pawsitive_BE.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pawsitive.pawsitive_BE.domain.Shelter;
import pawsitive.pawsitive_BE.repository.ShelterRepository;
import pawsitive.pawsitive_BE.web.dto.shelter.ShelterResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShelterServiceImpl implements ShelterService {
    private final ShelterRepository shelterRepository;

    @Override
    public ShelterResponse.ShelterInfoListDTO shelterInfoList() {
        List<Shelter> shelters = shelterRepository.findAll();

        List<ShelterResponse.ShelterInfoDTO> shelterInfoDTOs = shelters.stream()
                .map(shelter -> ShelterResponse.ShelterInfoDTO.builder()
                        .id(shelter.getId())
                        .name(shelter.getName())
                        .build())
                .collect(Collectors.toList());

        return ShelterResponse.ShelterInfoListDTO.builder()
                .shelterInfos(shelterInfoDTOs)
                .build();
    }
}
