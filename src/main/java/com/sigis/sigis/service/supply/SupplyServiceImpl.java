package com.sigis.sigis.service.supply;

import com.sigis.sigis.domain.Supply;
import com.sigis.sigis.repository.SupplyRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SupplyServiceImpl extends BaseServiceImpl<Supply, SupplyRepository> implements ISupplyService{
}
