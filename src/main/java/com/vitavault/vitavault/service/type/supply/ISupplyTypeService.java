package com.vitavault.vitavault.service.type.supply;

import com.vitavault.vitavault.model.domain.SupplyType;
import com.vitavault.vitavault.model.input.InputSupplyType;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface ISupplyTypeService extends IBaseService<SupplyType>, ICreateUpdate<InputSupplyType> {
}
