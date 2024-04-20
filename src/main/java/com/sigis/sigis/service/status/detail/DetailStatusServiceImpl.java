package com.sigis.sigis.service.status.detail;

import com.sigis.sigis.domain.DetailStatus;
import com.sigis.sigis.repository.DetailStatusRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class DetailStatusServiceImpl extends BaseServiceImpl<DetailStatus, DetailStatusRepository> implements IDetailStatusService {
}
