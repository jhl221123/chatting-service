package simple.chatting.domain.messageroom;

import org.springframework.data.jpa.repository.JpaRepository;

import simple.chatting.domain.user.User;

public interface MessageRoomRepository extends JpaRepository<MessageRoom, Long> {
}
