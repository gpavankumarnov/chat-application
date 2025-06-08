package com.socket.chat_app.config;





import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


//This class is a configuration class


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    /**
     The client initiates a connection to the WebSocket server using the STOMP endpoint.
     This initial handshake happens at the endpoint, establishing the WebSocket connection.

     const socket = new SockJS("https://localhost:8080/ws");
     */

    registry.addEndpoint("/ws")
        .setAllowedOriginPatterns("*")
    .withSockJS();
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    /**
     tell the server as to when it is supposed to expect a message okay
     so for example server will process a message with a particular prefix okay
     so for example I if a client sends a message with prefix /app okay
     then server will know that it is supposed to process okay
     */
    // Set prefix for client-to-server messages
    registry.setApplicationDestinationPrefixes("/app");

    /**
     This creates a new messageBroker
      that handles the messages for a respective topic.
     So when user sends a message from chatroom1 - /topic/chatRoom1
     Then the message has to be broadcasted to all the subscribed clients.
    */
    registry.enableSimpleBroker("/chatroom, /user");
    registry.setUserDestinationPrefix("/user");
  }
}
