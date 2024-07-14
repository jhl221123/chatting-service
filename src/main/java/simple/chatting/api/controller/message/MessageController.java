package simple.chatting.api.controller.message;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import simple.chatting.api.controller.message.request.MessageRequest;
import simple.chatting.domain.message.Message;
import simple.chatting.domain.message.MessageRepository;
import simple.chatting.domain.messageroom.MessageRoom;
import simple.chatting.domain.messageroom.MessageRoomRepository;
import simple.chatting.domain.user.User;
import simple.chatting.domain.user.UserRepository;

@RestController
@RequiredArgsConstructor
public class MessageController {

	private final SimpMessageSendingOperations messagingTemplate;
	private final UserRepository userRepository;
	private final MessageRepository messageRepository;
	private final MessageRoomRepository messageRoomRepository;

	@MessageMapping("/messages/{id}")
	public void message(@RequestBody MessageRequest request) {
		MessageRoom messageRoom = messageRoomRepository.findById(request.getMessageRoomId())
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메시지 룸입니다."));
		User sender = userRepository.findById(request.getSenderId())
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
		Message savedMessage = messageRepository.save(request.toEntity(messageRoom, sender));
		messagingTemplate.convertAndSend("/sub/messages/" + savedMessage.getMessageRoom().getId(), savedMessage);
	}

	// @PostMapping("/messages")
	// public ResponseEntity<Message> createUser(@RequestBody MessageRequest request) {
	// 	MessageRoom messageRoom = messageRoomRepository.findById(request.getMessageRoomId())
	// 		.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메시지 룸입니다."));
	// 	User sender = userRepository.findById(request.getSenderId())
	// 		.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
	// 	Message savedMessage = messageRepository.save(request.toEntity(messageRoom, sender));
	// 	return ResponseEntity.ok(savedMessage);
	// }
}
