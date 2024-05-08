package com.vitavault.vitavault.service.supply;

import com.vitavault.vitavault.model.domain.Supply;
import com.vitavault.vitavault.repository.SupplyRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SupplyServiceImpl extends BaseServiceImpl<Supply, SupplyRepository> implements ISupplyService{
}
