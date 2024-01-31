package com.apnadost.service.impl;

import com.apnadost.exception.VerificationTokenNotFoundException;
import com.apnadost.model.VerificationTokenDto;
import com.apnadost.repository.VerificationTokenRepository;
import com.apnadost.service.VerificationTokenService;
import com.apnadost.utils.VerificationTokenMappingUtils;
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
public class VerificationTokenServiceImpl implements VerificationTokenService {
	
	private final VerificationTokenRepository verificationTokenRepository;
	
	@Override
	public List<VerificationTokenDto> findAll() {
		log.info("*** VerificationTokenDto List, service; fetch all verificationTokens *");
		return this.verificationTokenRepository.findAll()
				.stream()
					.map(VerificationTokenMappingUtils::map)
					.distinct()
					.collect(Collectors.toUnmodifiableList());
	}
	
	@Override
	public VerificationTokenDto findById(final Integer verificationTokenId) {
		log.info("*** VerificationTokenDto, service; fetch verificationToken by ids *");
		return this.verificationTokenRepository.findById(verificationTokenId)
				.map(VerificationTokenMappingUtils::map)
				.orElseThrow(() -> new VerificationTokenNotFoundException(String
						.format("#### VerificationToken with id: %d not found! ####", verificationTokenId)));
	}
	
	@Override
	public VerificationTokenDto save(final VerificationTokenDto verificationTokenDto) {
		log.info("*** VerificationTokenDto, service; save verificationToken *");
		return VerificationTokenMappingUtils.map(this.verificationTokenRepository
				.save(VerificationTokenMappingUtils.map(verificationTokenDto)));
	}
	
	@Override
	public VerificationTokenDto update(final VerificationTokenDto verificationTokenDto) {
		log.info("*** VerificationTokenDto, service; update verificationToken *");
		return VerificationTokenMappingUtils.map(this.verificationTokenRepository
				.save(VerificationTokenMappingUtils.map(verificationTokenDto)));
	}
	
	@Override
	public VerificationTokenDto update(final Integer verificationTokenId, final VerificationTokenDto verificationTokenDto) {
		log.info("*** VerificationTokenDto, service; update verificationToken with verificationTokenId *");
		return VerificationTokenMappingUtils.map(this.verificationTokenRepository.save(
				VerificationTokenMappingUtils.map(this.findById(verificationTokenId))));
	}
	
	@Override
	public void deleteById(final Integer verificationTokenId) {
		log.info("*** Void, service; delete verificationToken by id *");
		this.verificationTokenRepository.deleteById(verificationTokenId);
	}
	
	
	
}










