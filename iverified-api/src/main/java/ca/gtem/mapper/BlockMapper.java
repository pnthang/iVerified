package ca.gtem.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import ca.gtem.dto.BlockDto;
import ca.gtem.model.Block;

@Component
public interface BlockMapper {
	Block toEntity(BlockDto blockDto);	
	BlockDto toDto(Block block);
	List<BlockDto> toDtos(List<Block> blocks);

}
