//package com.socket.chat_app.config;
//import com.socket.chat_app.model.ChatMessage;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.event.EventListener;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class WebSocketEventListener {
//  /**
//   * Why this class?
//   Without this class - The disconnection of a user would not be detected.
//   You would not be able to log the event or broadcast a "user left" message to other connected clients.
//   */
//
////TO TELL - that when any user left - one user left.
//  @EventListener
//  public  void handleWebSocketDisconnectListener(SessionDisconnectEvent event){
//    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//    String username = (String) headerAccessor.getSessionAttributes().get("username");
//    if(username != null){
//      log.info("User disconnected: {}", username);
//      var chatMessage = ChatMessage.builder()
//
//          .sender(username)
//          .build();
//
//    }
//  }
//
//
//}
