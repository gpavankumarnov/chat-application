package com.socket.chat_app.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ChatMessage {
  /**
   * This is the class
   * thats going to represent the particular message.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String message;
  private String senderName;
  private String receiverName;
  @Enumerated(EnumType.STRING)
private Status status;

  //LocalDateTime = yyyy-MM-dd HH:mm:ss.SSS
  @CreationTimestamp
  private LocalDateTime createdAt;


//  @Enumerated(EnumType.STRING)
//  private Status status;

}
