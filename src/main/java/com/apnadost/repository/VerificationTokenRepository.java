package com.apnadost.repository;

import com.apnadost.domain.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {
	
	
	
}
