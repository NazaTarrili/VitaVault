package com.vitavault.vitavault.service.supplier;

import com.vitavault.vitavault.model.domain.Supplier;
import com.vitavault.vitavault.model.input.InputSupplier;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface ISupplierService extends IBaseService<Supplier>, ICreateUpdate<InputSupplier> {
}
