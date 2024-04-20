package com.vitavault.vitavault.service.status.subscription;

import com.vitavault.vitavault.domain.SubscriptionStatus;
import com.vitavault.vitavault.repository.SubscriptionStatusRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SubscriptionStatusServiceImpl extends BaseServiceImpl<SubscriptionStatus, SubscriptionStatusRepository> implements ISubscriptionStatusService {
}
