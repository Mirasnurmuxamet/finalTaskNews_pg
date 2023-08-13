package kz.techorda.finalTaskNews.mapper;

import kz.techorda.finalTaskNews.dto.UserDTO;
import kz.techorda.finalTaskNews.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDto(User user);

    User toUserModel(UserDTO userDTO);

    List<UserDTO> toUserDtoList(List<User> userList);

    List<User> toUserModelList(List<UserDTO> userDTOList);

}
