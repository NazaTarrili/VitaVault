package com.vitavault.vitavault.service.type.episode;

import com.vitavault.vitavault.domain.EpisodeType;
import com.vitavault.vitavault.repository.EpisodeTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class EpisodeTypeServiceImpl extends BaseServiceImpl<EpisodeType, EpisodeTypeRepository> implements IEpisodeTypeService {
}
