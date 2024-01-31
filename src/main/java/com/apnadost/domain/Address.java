package com.apnadost.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"user"})
@Data
@Builder
public final class Address extends AbstractMappedEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", unique = true, nullable = false, updatable = false)
	private Integer addressId;
	
	@Column(name = "full_address", unique = true)
	private String fullAddress;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	private String city;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
}










