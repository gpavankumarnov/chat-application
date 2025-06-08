package com.socket.chat_app.mapper;
import com.socket.chat_app.dto.UserDto;
import com.socket.chat_app.model.User;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface UsersMapper {


  User convertDtoToEntity(UserDto userDto);
  UserDto convertEntityToDto(User user);

}
