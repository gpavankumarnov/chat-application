package com.socket.chat_app.Repository;
import com.socket.chat_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    void deleteByUserName(String userName);

}
