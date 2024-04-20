package com.sigis.sigis.service.type.episode;

import com.sigis.sigis.domain.EpisodeType;
import com.sigis.sigis.repository.EpisodeTypeRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class EpisodeTypeServiceImpl extends BaseServiceImpl<EpisodeType, EpisodeTypeRepository> implements IEpisodeTypeService {
}
