package com.vitavault.vitavault.service.billingDetail;

import com.vitavault.vitavault.domain.BillingDetail;
import com.vitavault.vitavault.repository.BillingDetailRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class BillingDetailServiceImpl extends BaseServiceImpl<BillingDetail, BillingDetailRepository> implements IBillingDetailService {
}
