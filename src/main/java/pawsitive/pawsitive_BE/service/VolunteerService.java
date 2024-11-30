package pawsitive.pawsitive_BE.service;

import pawsitive.pawsitive_BE.web.dto.volunteer.VolunteerPostRequestDTO;
import pawsitive.pawsitive_BE.web.dto.volunteer.VolunteerResponse;

public interface VolunteerService {
    VolunteerResponse.VolunteerListResultDTO volunteerList();
    VolunteerResponse.VolunteerDetailResultDTO volunteerDetail(Integer postId);
    VolunteerResponse.VolunteerPostResultDTO volunteerPost(VolunteerPostRequestDTO volunteerPostRequestDTO);
}
