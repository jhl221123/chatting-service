package simple.chatting.api.controller.user.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import simple.chatting.domain.user.User;

@Getter
@NoArgsConstructor
public class UserRequest {

	private String name;

	public User toEntity() {
		return User.builder()
			.name(this.name)
			.build();
	}
}
