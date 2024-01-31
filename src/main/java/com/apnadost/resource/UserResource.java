package com.apnadost.resource;

import com.apnadost.model.DtoCollectionResponse;
import com.apnadost.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.apnadost.model.UserDto;
@RestController
@RequestMapping(value = {"/api/users"})
@Slf4j
@RequiredArgsConstructor
public class UserResource {
	
	private final UserService userService;
	
	@GetMapping
	public ResponseEntity<DtoCollectionResponse<UserDto>> findAll() {
		log.info("*** UserDto List, controller; fetch all users *");
		return ResponseEntity.ok(new DtoCollectionResponse<>(this.userService.findAll()));
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> findById(
			@PathVariable("userId") 
//			@NotBlank(message = "Input must not blank")
//			@Valid
			final String userId) {
		log.info("*** UserDto, resource; fetch user by id *");
		return ResponseEntity.ok(this.userService.findById(Integer.parseInt(userId.strip())));
	}
	
	@PostMapping
	public ResponseEntity<UserDto> save(
			@RequestBody
//			@NotBlank(message = "Input must not blank")
//			@Valid
			final UserDto userDto) {
		log.info("*** UserDto, resource; save user *");
		return ResponseEntity.ok(this.userService.save(userDto));
	}
	
	@PutMapping
	public ResponseEntity<UserDto> update(
			@RequestBody
//			@NotBlank(message = "Input must not blank")
//			@Valid
			final UserDto userDto) {
		log.info("*** UserDto, resource; update user *");
		return ResponseEntity.ok(this.userService.update(userDto));
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> update(
			@PathVariable("userId")
//			@NotBlank(message = "Input must not blank")
			final String userId,
			@RequestBody
//			@NotBlank(message = "Input must not blank")
//			@Valid
			final UserDto userDto) {
		log.info("*** UserDto, resource; update user with userId *");
		return ResponseEntity.ok(this.userService.update(Integer.parseInt(userId.strip()), userDto));
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Boolean> deleteById(@PathVariable("userId") /*@NotBlank(message = "Input must not blank") @Valid*/ final String userId) {
		log.info("*** Boolean, resource; delete user by id *");
		this.userService.deleteById(Integer.parseInt(userId));
		return ResponseEntity.ok(true);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<UserDto> findByUsername(
			@PathVariable("username") 
//			@NotBlank(message = "Input must not blank")
//			@Valid
			final String username) {
		return ResponseEntity.ok(this.userService.findByUsername(username));
	}
	
	
	
}










