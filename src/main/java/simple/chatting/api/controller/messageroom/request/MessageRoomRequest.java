package simple.chatting.api.controller.messageroom.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import simple.chatting.domain.message.Message;
import simple.chatting.domain.messageroom.MessageRoom;
import simple.chatting.domain.user.User;

@Getter
@NoArgsConstructor
public class MessageRoomRequest {

	private Long senderId;
	private Long receiverId;

	public MessageRoom toEntity(User sender, User receiver) {
		return MessageRoom.builder()
			.sender(sender)
			.receiver(receiver)
			.build();
	}
}
