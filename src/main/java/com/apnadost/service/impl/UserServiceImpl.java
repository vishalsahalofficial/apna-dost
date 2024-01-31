package com.apnadost.service.impl;


import com.apnadost.exception.UserObjectNotFoundException;
import com.apnadost.model.UserDto;
import com.apnadost.repository.UserRepository;
import com.apnadost.service.UserService;
import com.apnadost.utils.UserMappingUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	@Override
	public List<UserDto> findAll() {
		log.info("*** UserDto List, service; fetch all users *");
		return this.userRepository.findAll()
				.stream()
					.map(UserMappingUtils::map)
					.distinct()
					.collect(Collectors.toUnmodifiableList());
	}
	
	@Override
	public UserDto findById(final Integer userId) {
		log.info("*** UserDto, service; fetch user by id *");
		return this.userRepository.findById(userId)
				.map(UserMappingUtils::map)
				.orElseThrow(() -> new UserObjectNotFoundException(String.format("User with id: %d not found", userId)));
	}
	
	@Override
	public UserDto save(final UserDto userDto) {
		log.info("*** UserDto, service; save user *");
		return UserMappingUtils.map(this.userRepository.save(UserMappingUtils.map(userDto)));
	}
	
	@Override
	public UserDto update(final UserDto userDto) {
		log.info("*** UserDto, service; update user *");
		return UserMappingUtils.map(this.userRepository.save(UserMappingUtils.map(userDto)));
	}
	
	@Override
	public UserDto update(final Integer userId, final UserDto userDto) {
		log.info("*** UserDto, service; update user with userId *");
		return UserMappingUtils.map(this.userRepository.save(
				UserMappingUtils.map(this.findById(userId))));
	}
	
	@Override
	public void deleteById(final Integer userId) {
		log.info("*** Void, service; delete user by id *");
		this.userRepository.deleteById(userId);
	}
	
	@Override
	public UserDto findByUsername(final String username) {
		log.info("*** UserDto, service; fetch user with username *");
		return UserMappingUtils.map(this.userRepository.findByCredentialUsername(username)
				.orElseThrow(() -> new UserObjectNotFoundException(String.format("User with username: %s not found", username))));
	}
}










