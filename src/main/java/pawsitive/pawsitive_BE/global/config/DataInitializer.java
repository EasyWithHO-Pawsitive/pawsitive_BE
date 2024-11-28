/*
package pawsitive.pawsitive_BE.global.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import pawsitive.pawsitive_BE.domain.Shelter;
import pawsitive.pawsitive_BE.repository.AdoptionRepository;
import pawsitive.pawsitive_BE.repository.ShelterRepository;
import pawsitive.pawsitive_BE.repository.VolunteerRepository;

import java.util.Arrays;

@Component
public class DataInitializer {

    private final ShelterRepository shelterRepository;
    private final AdoptionRepository adoptionRepository;
    private final VolunteerRepository volunteerRepository;

    public DataInitializer( ShelterRepository shelterRepository, AdoptionRepository adoptionRepository, VolunteerRepository volunteerRepository) {
        this.shelterRepository = shelterRepository;
        this.adoptionRepository = adoptionRepository;
        this.volunteerRepository = volunteerRepository;
    }

    @PostConstruct
    public void init() {
        // 보호소 목록
        if(shelterRepository.count() == 0) {
            shelterRepository.saveAll(Arrays.asList(
                    new Shelter(1, "(사)동물권자유너와", "070-8691-0852", "한다미", "010-9675-6167", "부산광역시 사상구 사상로 350 찬희빌딩 2층", "경상", null, null),
                    new Shelter(2, "동물자원과(유기동물보호소)", "061-749-3093", "장정호", "010-0000-0000", "전라남도 순천시 승주읍 승주로 628 농업기술센터 동물자원과", "전라", null, null),
                    new Shelter(3, "경기도 도우미견나눔센터", "031-8030-4378", "배상준", "010-0000-0000", "경기도 화성시 마도면 마도공단로1길 181-15 ", "경기", null, null)
                    ));
        }

    }
}
*/
