package pawsitive.pawsitive_BE.service;

import org.springframework.stereotype.Service;
import pawsitive.pawsitive_BE.web.dto.volunteer.VolunteerResponse;

public interface VolunteerService {
    VolunteerResponse.VolunteerListResultDTO volunteerList();
}
