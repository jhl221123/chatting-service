package simple.chatting.domain.messageroom;

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
import simple.chatting.domain.user.User;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	private User sender;

	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	private User receiver;

	@Builder
	private MessageRoom(Long id, User sender, User receiver) {
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
	}
}
