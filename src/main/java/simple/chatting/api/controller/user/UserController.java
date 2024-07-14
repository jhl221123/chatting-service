package simple.chatting.api.controller.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import simple.chatting.api.controller.user.request.UserRequest;
import simple.chatting.domain.user.User;
import simple.chatting.domain.user.UserRepository;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserRepository userRepository;

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody UserRequest request) {
		User savedUser = userRepository.save(request.toEntity());
		return ResponseEntity.ok(savedUser);
	}
}
