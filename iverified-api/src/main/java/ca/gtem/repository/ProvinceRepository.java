package ca.gtem.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ca.gtem.model.Province;

public interface ProvinceRepository extends JpaRepository<Province,Long> {
	Page<Province> findByCountryId(Long countryId, Pageable pageable);
	Province findByName(String name);
}
