package simple.chatting.domain.message;

import org.springframework.data.jpa.repository.JpaRepository;

import simple.chatting.domain.user.User;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
