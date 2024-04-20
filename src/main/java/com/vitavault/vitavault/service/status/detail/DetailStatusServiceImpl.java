package com.vitavault.vitavault.service.status.detail;

import com.vitavault.vitavault.domain.DetailStatus;
import com.vitavault.vitavault.repository.DetailStatusRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class DetailStatusServiceImpl extends BaseServiceImpl<DetailStatus, DetailStatusRepository> implements IDetailStatusService {
}
