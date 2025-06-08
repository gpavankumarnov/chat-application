package com.socket.chat_app.Repository;
import com.socket.chat_app.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
   
}