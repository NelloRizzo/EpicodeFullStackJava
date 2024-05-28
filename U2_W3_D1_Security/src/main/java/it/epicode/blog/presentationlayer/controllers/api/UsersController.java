package it.epicode.blog.presentationlayer.controllers.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import it.epicode.blog.businesslayer.services.UserService;
import it.epicode.blog.businesslayer.services.dto.RegisterUserDto;
import it.epicode.blog.businesslayer.services.dto.RegisteredUserDto;
import it.epicode.blog.presentationlayer.controllers.api.exceptions.FieldValidationException;
import it.epicode.blog.presentationlayer.controllers.api.models.LoginModel;
import it.epicode.blog.presentationlayer.controllers.api.models.RegisterUserModel;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UserService users;
	
	@PostMapping
	public ResponseEntity<?> register(@RequestBody @Validated RegisterUserModel model, //
			BindingResult validation, UriComponentsBuilder uri) {
		if (validation.hasErrors()) {
			throw new FieldValidationException(validation.getAllErrors());
		}
		var r = users.register(RegisterUserDto.builder() //
				.withFriendlyName(model.friendlyName()) //
				.withPassword(model.password()) //
				.withUsername(model.username()).withRoles(model.roles()).build());
		var headers = new HttpHeaders();
		headers.add("Location", uri.path("/api/users/{id}").buildAndExpand(r.getId()).toString());
		return new ResponseEntity<>(r, headers, HttpStatus.CREATED);
	}

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody @Validated LoginModel model, //
			BindingResult validation) {
		if (validation.hasErrors()) {
			throw new FieldValidationException(validation.getAllErrors());
		}
		
		return new ResponseEntity<>(users.login(model.username(), model.password()).orElseThrow(), //
				HttpStatus.OK);
	}

	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<RegisteredUserDto> get(@PathVariable long id) {
		return users.get(id);
	}
}
