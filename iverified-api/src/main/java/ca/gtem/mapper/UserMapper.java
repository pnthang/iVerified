package ca.gtem.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import ca.gtem.dto.UserDto;
import ca.gtem.model.User;

@Component
public interface UserMapper {
	User toEntity(UserDto userDto);	
	UserDto toDto(User user);
	List<UserDto> toDtos(List<User> users);
}
