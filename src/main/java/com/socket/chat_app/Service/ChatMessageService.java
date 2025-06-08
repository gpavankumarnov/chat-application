package com.socket.chat_app.Service;
import com.socket.chat_app.Repository.ChatMessageRepository;
import com.socket.chat_app.dto.ChatMessageDto;
import com.socket.chat_app.mapper.ChatMessageMapper;
import com.socket.chat_app.model.ChatMessage;
import org.springframework.stereotype.Service;
@Service
public class ChatMessageService {
  private final ChatMessageRepository chatMessageRepository;
 private final ChatMessageMapper chatMessageMapper;



  public ChatMessageService(ChatMessageRepository chatMessageRepository, ChatMessageMapper mapper) {
    this.chatMessageMapper = mapper;
    this.chatMessageRepository = chatMessageRepository;
  }

  public ChatMessage saveMessageToDB(ChatMessageDto chatMessageDto) {
    if (chatMessageDto != null) {
 ChatMessage chatMessage =   chatMessageMapper.convertDtoToEntity(chatMessageDto);
      return chatMessageRepository.save(chatMessage);
    }
    return null;
  }
}
