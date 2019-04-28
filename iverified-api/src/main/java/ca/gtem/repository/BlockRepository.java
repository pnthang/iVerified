package ca.gtem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ca.gtem.model.Block;

public interface BlockRepository extends JpaRepository<Block, Long> {
	Page<Block> findByProductId(Long productId, Pageable pageable);
}
