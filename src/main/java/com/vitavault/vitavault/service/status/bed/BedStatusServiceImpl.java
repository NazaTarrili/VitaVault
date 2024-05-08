package com.vitavault.vitavault.service.status.bed;

import com.vitavault.vitavault.model.domain.BedStatus;
import com.vitavault.vitavault.repository.BedStatusRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class BedStatusServiceImpl extends BaseServiceImpl<BedStatus, BedStatusRepository> implements IBedStatusService {
}
