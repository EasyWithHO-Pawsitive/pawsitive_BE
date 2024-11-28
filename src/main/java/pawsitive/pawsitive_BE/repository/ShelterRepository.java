package pawsitive.pawsitive_BE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pawsitive.pawsitive_BE.domain.Shelter;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Long> {
}
