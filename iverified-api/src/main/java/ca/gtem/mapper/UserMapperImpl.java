package ca.gtem.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ca.gtem.util.StringUtil;
import ca.gtem.util.ImageUtil;

import ca.gtem.dto.UserDto;
import ca.gtem.model.User;
import ca.gtem.repository.RoleRepository;

@Component
public class UserMapperImpl implements UserMapper {
	private final RoleRepository roleRepository;
	
	@Value("${file.user-dir}")
	private String userDir;
	
	@Value("${file.root-dir}")
	private String rootDir;	
	
	public UserMapperImpl(RoleRepository roleRepository) {
		this.roleRepository= roleRepository;
	}
	
	@Override
	public User toEntity(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());
		user.setPhone(userDto.getPhone());
		user.setProfileImage(ImageUtil.storeImage(userDto.getProfileImage(),rootDir, userDir));
		
		user.setPassword(userDto.getPassword());
		if (userDto.getPassword().length()<20) {
			// Encrypt pass if userinput
			user.setPassword(StringUtil.applySha256(userDto.getPassword()));	
		}
		
		if (userDto.getRole()!=null) {
			user.setRole(roleRepository.findOne(userDto.getRole()));
		}												
		return user;
	}

	@Override
	public UserDto toDto(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> toDtos(List<User> users) {
		// TODO Auto-generated method stub
		return null;
	}

}
