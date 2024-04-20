package com.sigis.sigis.service.type.supply;

import com.sigis.sigis.domain.SupplyType;
import com.sigis.sigis.repository.SupplyTypeRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SupplyTypeServiceImpl extends BaseServiceImpl<SupplyType, SupplyTypeRepository> implements ISupplyTypeService {
}
