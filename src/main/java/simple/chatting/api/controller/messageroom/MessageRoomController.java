package simple.chatting.api.controller.messageroom;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import simple.chatting.api.controller.messageroom.request.MessageRoomRequest;
import simple.chatting.domain.messageroom.MessageRoom;
import simple.chatting.domain.messageroom.MessageRoomRepository;
import simple.chatting.domain.user.User;
import simple.chatting.domain.user.UserRepository;

@RestController
@RequiredArgsConstructor
public class MessageRoomController {

	private final UserRepository userRepository;
	private final MessageRoomRepository messageRoomRepository;

	@PostMapping("/message-rooms")
	public ResponseEntity<MessageRoom> createUser(@RequestBody MessageRoomRequest request) {
		User sender = userRepository.findById(request.getSenderId())
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
		User receiver = userRepository.findById(request.getReceiverId())
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

		MessageRoom savedMessageRoom = messageRoomRepository.save(request.toEntity(sender, receiver));
		return ResponseEntity.ok(savedMessageRoom);
	}
}
