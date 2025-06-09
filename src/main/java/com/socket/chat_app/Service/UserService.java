package com.socket.chat_app.Service;
import com.socket.chat_app.Repository.UserRepository;
import com.socket.chat_app.dto.UserDto;
import com.socket.chat_app.mapper.UsersMapper;
import com.socket.chat_app.model.Status;
import com.socket.chat_app.model.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {
  private UserRepository userRepository;
  private UsersMapper usersMapper;

  public UserService(UserRepository userRepository, UsersMapper usersMapper) {
    this.userRepository = userRepository;
    this.usersMapper = usersMapper;
  }

  public void addUser(UserDto userDto) {
    if(userDto.getStatus() == Status.JOIN) {
      //convert entity to dto
      User user = usersMapper.convertDtoToEntity(userDto);
      userRepository.save(user);
    }
  }

  @Transactional
  public void leaveUser(UserDto userDto) {
    if(userDto != null && userDto.getStatus() == Status.LEAVE) {
     userRepository.deleteByUserName(userDto.getUserName());
    }
  }

  public List<UserDto> getAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream().map(e -> usersMapper.convertEntityToDto(e)).collect(Collectors.toList());
  }
}
