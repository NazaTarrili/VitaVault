package com.vitavault.vitavault.service.address;

import com.vitavault.vitavault.model.domain.Address;
import com.vitavault.vitavault.model.input.InputAddress;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IAddressService extends IBaseService<Address>, ICreateUpdate<InputAddress> {
}
