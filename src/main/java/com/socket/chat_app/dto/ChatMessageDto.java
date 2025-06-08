package com.socket.chat_app.dto;
import com.socket.chat_app.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageDto {

  private String message;
  private String senderName;
  private String receiverName;
  private Status status;


}
