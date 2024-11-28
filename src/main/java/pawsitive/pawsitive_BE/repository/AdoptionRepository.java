package pawsitive.pawsitive_BE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pawsitive.pawsitive_BE.domain.Adoption;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
}
