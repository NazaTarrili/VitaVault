package com.vitavault.vitavault.service.supply;

import com.vitavault.vitavault.model.domain.Supply;
import com.vitavault.vitavault.model.input.InputSupply;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface ISupplyService extends IBaseService<Supply>, ICreateUpdate<InputSupply> {
}
