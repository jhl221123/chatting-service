package simple.chatting.api.controller.message.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import simple.chatting.domain.message.Message;
import simple.chatting.domain.messageroom.MessageRoom;
import simple.chatting.domain.user.User;

@Getter
@NoArgsConstructor
public class MessageRequest {

	private Long messageRoomId;
	private Long senderId;
	private String content;

	public Message toEntity(MessageRoom room, User sender) {
		return Message.builder()
			.messageRoom(room)
			.sender(sender)
			.content(this.content)
			.build();
	}
}
