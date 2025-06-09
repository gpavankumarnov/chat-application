package com.socket.chat_app.Controller;
import com.socket.chat_app.Service.ChatMessageService;
import com.socket.chat_app.Service.UserService;
import com.socket.chat_app.dto.ChatMessageDto;
import com.socket.chat_app.dto.UserDto;
import com.socket.chat_app.model.ChatMessage;
import com.socket.chat_app.model.Status;
import com.socket.chat_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class ChatController {
  private final ChatMessageService chatMessageService;
  private final UserService userService;

  public ChatController(ChatMessageService chatMessageService,
                        UserService userService) {
    this.chatMessageService = chatMessageService;
    this.userService = userService;
  }

  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;

  /**
   * This controller is going to handle all the requests sent form the client.
   */

  // MessageMapping - It maps the websocket messages to the destination. -
  // "/app/message"
  @MessageMapping("/message")
  @SendTo("/chatroom/public") // The processed and returned message is sent to "/chatroom/public" for
  // broardcasting.
  public ChatMessage receivePublicMessage(@Payload ChatMessageDto chatMessageDto) {
if(chatMessageDto != null){


       userService.getAllUsers();

}
    return chatMessageService.saveMessageToDB(chatMessageDto);
  }

  @MessageMapping("/private-message")
//  To send private messages dynamically (e.g., /user/{username}/private), use this instead of @SendToUser:
//  @SendToUser("/user")

  public ChatMessageDto receivePrivateMessage(@Payload ChatMessageDto chatMessageDto) {
    // client should subscribe to this url -> /user/david/private
    // here david -> is dynamic name.
    chatMessageService.saveMessageToDB(chatMessageDto);
    // This below c ommand is for dynamically creating a destination url ->
    // /user/{username}/private

    simpMessagingTemplate.convertAndSendToUser(chatMessageDto.getReceiverName(), "/private", chatMessageDto);
    return chatMessageDto;
  }


  @MessageMapping("/join-user")
  @SendTo("/new-user/add")
  public List<UserDto> joinUser(@Payload UserDto userDto){
    userService.addUser(userDto);
    return userService.getAllUsers();
  }

  @MessageMapping("/user-leave")
  @SendTo("/leave")
  public void leaveUser(@Payload UserDto userDto){
    System.out.println("User left: " + userDto.getUserName());
    userService.leaveUser(userDto);
  }

}
