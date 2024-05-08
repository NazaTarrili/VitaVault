package com.vitavault.vitavault.service.type.supply;

import com.vitavault.vitavault.model.domain.SupplyType;
import com.vitavault.vitavault.repository.SupplyTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SupplyTypeServiceImpl extends BaseServiceImpl<SupplyType, SupplyTypeRepository> implements ISupplyTypeService {
}
