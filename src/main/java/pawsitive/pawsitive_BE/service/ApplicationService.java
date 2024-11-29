package pawsitive.pawsitive_BE.service;

import pawsitive.pawsitive_BE.web.dto.adoption.ApplicationRequestDTO;
import pawsitive.pawsitive_BE.web.dto.application.ApplicationResponse;

public interface ApplicationService {
    ApplicationResponse.ApplicationResponseDto addApplication(ApplicationRequestDTO application);
}
