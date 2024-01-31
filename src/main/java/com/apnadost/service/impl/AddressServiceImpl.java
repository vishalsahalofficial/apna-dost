package com.apnadost.service.impl;


import com.apnadost.exception.AddressNotFoundException;
import com.apnadost.model.AddressDto;
import com.apnadost.repository.AddressRepository;
import com.apnadost.service.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.apnadost.utils.AddressMappingUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
	
	private final AddressRepository addressRepository;
	
	@Override
	public List<AddressDto> findAll() {
		log.info("*** AddressDto List, service; fetch all addresss *");
		return this.addressRepository.findAll()
				.stream()
					.map(AddressMappingUtils::map)
					.distinct()
					.collect(Collectors.toUnmodifiableList());
	}
	
	@Override
	public AddressDto findById(final Integer addressId) {
		log.info("*** AddressDto, service; fetch address by id *");
		return this.addressRepository.findById(addressId)
				.map(AddressMappingUtils::map)
				.orElseThrow(() -> new AddressNotFoundException(String.format("#### Address with id: %d not found! ####", addressId)));
	}
	
	@Override
	public AddressDto save(final AddressDto addressDto) {
		log.info("*** AddressDto, service; save address *");
		return AddressMappingUtils.map(this.addressRepository.save(AddressMappingUtils.map(addressDto)));
	}
	
	@Override
	public AddressDto update(final AddressDto addressDto) {
		log.info("*** AddressDto, service; update address *");
		return AddressMappingUtils.map(this.addressRepository.save(AddressMappingUtils.map(addressDto)));
	}
	
	@Override
	public AddressDto update(final Integer addressId, final AddressDto addressDto) {
		log.info("*** AddressDto, service; update address with addressId *");
		return AddressMappingUtils.map(this.addressRepository.save(
				AddressMappingUtils.map(this.findById(addressId))));
	}
	
	@Override
	public void deleteById(final Integer addressId) {
		log.info("*** Void, service; delete address by id *");
		this.addressRepository.deleteById(addressId);
	}
	
	
	
}










