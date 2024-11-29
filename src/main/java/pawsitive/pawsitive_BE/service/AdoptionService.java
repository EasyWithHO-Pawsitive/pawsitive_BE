package pawsitive.pawsitive_BE.service;

import pawsitive.pawsitive_BE.web.dto.adoption.AdoptionResponse;

public interface AdoptionService {
    AdoptionResponse.AdoptionListResultDTO adoptionList();
    AdoptionResponse.AdoptionDetailResultDTO adoptionDetail(Integer postId);
}
