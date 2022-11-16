package ukrim.co.id.serversideukrim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukrim.co.id.serversideukrim.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Boolean existsByName(String name);
}
