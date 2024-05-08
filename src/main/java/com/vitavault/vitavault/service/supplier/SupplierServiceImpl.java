package com.vitavault.vitavault.service.supplier;

import com.vitavault.vitavault.model.domain.Supplier;
import com.vitavault.vitavault.repository.SupplierRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier, SupplierRepository> implements ISupplierService {
}
