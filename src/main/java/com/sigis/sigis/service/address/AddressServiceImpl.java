package com.sigis.sigis.service.address;

import com.sigis.sigis.domain.Address;
import com.sigis.sigis.repository.AddressRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, AddressRepository> implements IAddressService {
}
