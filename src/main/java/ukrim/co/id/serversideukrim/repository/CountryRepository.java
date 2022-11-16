package ukrim.co.id.serversideukrim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ukrim.co.id.serversideukrim.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {}
