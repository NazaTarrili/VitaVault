package com.sigis.sigis.service.status.bed;

import com.sigis.sigis.domain.BedStatus;
import com.sigis.sigis.repository.BedStatusRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class BedStatusServiceImpl extends BaseServiceImpl<BedStatus, BedStatusRepository> implements IBedStatusService {
}
