package com.sigis.sigis.service.episode;

import com.sigis.sigis.domain.Episode;
import com.sigis.sigis.repository.EpisodeRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class EpisodeServiceImpl extends BaseServiceImpl<Episode, EpisodeRepository> implements IEpisodeService {
}
