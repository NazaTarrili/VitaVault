package com.sigis.sigis.service.status.subscription;

import com.sigis.sigis.domain.SubscriptionStatus;
import com.sigis.sigis.repository.SubscriptionStatusRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class SubscriptionStatusServiceImpl extends BaseServiceImpl<SubscriptionStatus, SubscriptionStatusRepository> implements ISubscriptionStatusService {
}
