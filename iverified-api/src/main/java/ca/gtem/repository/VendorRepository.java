package ca.gtem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.gtem.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
