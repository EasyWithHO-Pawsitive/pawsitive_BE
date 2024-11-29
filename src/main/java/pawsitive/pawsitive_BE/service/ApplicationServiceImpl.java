package pawsitive.pawsitive_BE.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pawsitive.pawsitive_BE.domain.Application;
import pawsitive.pawsitive_BE.domain.User;
import pawsitive.pawsitive_BE.domain.Volunteer;
import pawsitive.pawsitive_BE.repository.ApplicationRepository;
import pawsitive.pawsitive_BE.repository.UserRepository;
import pawsitive.pawsitive_BE.repository.VolunteerRepository;
import pawsitive.pawsitive_BE.web.dto.adoption.ApplicationRequestDTO;
import pawsitive.pawsitive_BE.web.dto.application.ApplicationResponse;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final VolunteerRepository volunteerRepository;

    @Override
    public ApplicationResponse.ApplicationResponseDto addApplication(ApplicationRequestDTO application){
        // 사용자 조회
        User user = userRepository.findById(Long.valueOf(application.getId()))
                .orElseThrow(() -> new EntityNotFoundException("사용자가 존재하지 않습니다."));

        // 자원봉사 게시글 조회
        Volunteer volunteer = volunteerRepository.findById(Long.valueOf(application.getPostId()))
                .orElseThrow(() -> new EntityNotFoundException("자원봉사 게시글이 존재하지 않습니다."));

        Application applicationEntity = new Application(user, volunteer);

        applicationRepository.save(applicationEntity);

        return new ApplicationResponse.ApplicationResponseDto(applicationEntity.getId());

    }

}
