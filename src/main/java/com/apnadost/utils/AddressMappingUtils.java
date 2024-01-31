package com.apnadost.utils;

import com.apnadost.domain.Address;
import com.apnadost.domain.User;
import com.apnadost.model.AddressDto;
import com.apnadost.model.UserDto;

public interface AddressMappingUtils {
	
	public static AddressDto map(final Address address) {
		return AddressDto.builder()
				.addressId(address.getAddressId())
				.fullAddress(address.getFullAddress())
				.postalCode(address.getPostalCode())
				.city(address.getCity())
				.userDto(
					UserDto.builder()
						.userId(address.getUser().getUserId())
						.firstName(address.getUser().getFirstName())
						.lastName(address.getUser().getLastName())
						.imageUrl(address.getUser().getImageUrl())
						.email(address.getUser().getEmail())
						.phone(address.getUser().getPhone())
						.build())
				.build();
	}
	
	public static Address map(final AddressDto addressDto) {
		return Address.builder()
				.addressId(addressDto.getAddressId())
				.fullAddress(addressDto.getFullAddress())
				.postalCode(addressDto.getPostalCode())
				.city(addressDto.getCity())
				.user(
					User.builder()
						.userId(addressDto.getUserDto().getUserId())
						.firstName(addressDto.getUserDto().getFirstName())
						.lastName(addressDto.getUserDto().getLastName())
						.imageUrl(addressDto.getUserDto().getImageUrl())
						.email(addressDto.getUserDto().getEmail())
						.phone(addressDto.getUserDto().getPhone())
						.build())
				.build();
	}
	
	
	
}










