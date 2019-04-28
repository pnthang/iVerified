package ca.gtem.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ca.gtem.dto.BlockDto;
import ca.gtem.model.Block;
import ca.gtem.repository.BlockRepository;
import ca.gtem.repository.ProductRepository;
import ca.gtem.repository.VendorRepository;

import ca.gtem.util.StringUtil;
import ca.gtem.util.ImageUtil;

@Component
public class BlockMapperImpl implements BlockMapper {
	private final VendorRepository vendorRepository;	
	private final ProductRepository productRepository;
	private final BlockRepository blockRepository;
	
	@Value("${file.root-dir}")
	private String rootDir;	
	
	@Value("${file.transfer-dir}")
	private String transferDir;
	/**
	 * @param vendorRepository
	 */
	public BlockMapperImpl(VendorRepository vendorRepository,ProductRepository productRepository,BlockRepository blockRepository) {		
		this.vendorRepository = vendorRepository;
		this.productRepository = productRepository;
		this.blockRepository = blockRepository;
	}

	@Override
	public Block toEntity(BlockDto blockDto) {
		Block block = new Block();
		block.setId(blockDto.getId());
		block.setName(blockDto.getName());
		block.setDescription(blockDto.getDescription());
		
		block.setPreviousHash(blockDto.getPreviousHash());		
		block.setHash(StringUtil.createHash(blockDto.getName()+blockDto.getPreviousHash()));
		
		block.setImage(ImageUtil.storeImage(blockDto.getImage(),rootDir,transferDir));
		
		if (blockDto.getPreviousBlock()!=null) {
			block.setPreviousBlock(blockRepository.findOne(blockDto.getPreviousBlock()));
		}
		
		if (blockDto.getProduct()!=null) {
			block.setProduct(productRepository.findOne(blockDto.getProduct()));
		}
		
		if (blockDto.getSource()!=null) {
			block.setSource(vendorRepository.findOne(blockDto.getSource()));
		}
		
		if (blockDto.getDestination()!=null) {
			block.setDestination(vendorRepository.findOne(blockDto.getDestination()));
		}
		
		
		return block;
	}

	@Override
	public BlockDto toDto(Block block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlockDto> toDtos(List<Block> blocks) {
		// TODO Auto-generated method stub
		return null;
	}

}
