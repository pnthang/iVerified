package ca.gtem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ca.gtem.model.City;

public interface CityRepository extends JpaRepository<City,Long> {
	Page<City> findByProvinceId(Long provinceId, Pageable pageable);

}
