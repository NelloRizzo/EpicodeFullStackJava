package it.epicode.blog.presentationlayer.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.blog.businesslayer.services.UserService;
import it.epicode.blog.businesslayer.services.dto.RegisterUserDto;
import it.epicode.blog.presentationlayer.controllers.api.models.LoginModel;
import it.epicode.blog.presentationlayer.controllers.api.models.RegisterUserModel;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	UserService users;

	@PostMapping
	public ResponseEntity<?> register(@RequestBody @Validated RegisterUserModel model, //
			BindingResult validation) {
		if (validation.hasErrors()) {
			throw new RuntimeException();
		}
		var r = users.register(RegisterUserDto.builder() //
				.withFriendlyName(model.friendlyName()) //
				.withPassword(model.password()) //
				.withUsername(model.username()).build());
		return new ResponseEntity<>(r, HttpStatus.ACCEPTED);
	}

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody @Validated LoginModel model, //
			BindingResult validation) {
		if (validation.hasErrors()) {
			throw new RuntimeException();
		}
		return new ResponseEntity<>(users.login(model.username(), model.password()), //
				HttpStatus.OK);
	}
}
