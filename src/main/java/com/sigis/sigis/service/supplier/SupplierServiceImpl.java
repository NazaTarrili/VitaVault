package com.sigis.sigis.service.supplier;

import com.sigis.sigis.domain.Supplier;
import com.sigis.sigis.repository.SupplierRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier, SupplierRepository> implements ISupplierService {
}
