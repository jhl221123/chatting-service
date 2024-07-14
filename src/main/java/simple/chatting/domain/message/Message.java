package simple.chatting.domain.message;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import simple.chatting.domain.messageroom.MessageRoom;
import simple.chatting.domain.user.User;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	private MessageRoom messageRoom;

	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	private User sender;

	private String content;

	@Builder
	private Message(Long id, MessageRoom messageRoom, User sender, String content) {
		this.id = id;
		this.messageRoom = messageRoom;
		this.sender = sender;
		this.content = content;
	}
}
