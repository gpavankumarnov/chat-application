package com.socket.chat_app.mapper;
import com.socket.chat_app.dto.ChatMessageDto;
import com.socket.chat_app.model.ChatMessage;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface ChatMessageMapper {

//Entity to Dto
  ChatMessageDto convertEntityToDto(ChatMessage chatMessage);


  //Dto to Entity
  ChatMessage convertDtoToEntity(ChatMessageDto chatMessageDto);




}
