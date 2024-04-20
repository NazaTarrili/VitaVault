package com.sigis.sigis.service.billingDetail;

import com.sigis.sigis.domain.BillingDetail;
import com.sigis.sigis.repository.BillingDetailRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class BillingDetailServiceImpl extends BaseServiceImpl<BillingDetail, BillingDetailRepository> implements IBillingDetailService {
}
