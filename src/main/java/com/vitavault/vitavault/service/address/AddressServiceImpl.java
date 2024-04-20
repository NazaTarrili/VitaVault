package com.vitavault.vitavault.service.address;

import com.vitavault.vitavault.domain.Address;
import com.vitavault.vitavault.repository.AddressRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, AddressRepository> implements IAddressService {
}
